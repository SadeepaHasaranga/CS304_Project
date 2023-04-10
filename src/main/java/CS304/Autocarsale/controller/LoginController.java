package CS304.Autocarsale.controller;

import CS304.Autocarsale.DTO.LoginDTO;
import CS304.Autocarsale.DTO.LoginResponseDTO;
import CS304.Autocarsale.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping
public class LoginController {


            @Autowired
            private LoginService loginService;

//            @GetMapping("/getAllLoginDetails")
//            public ResponseEntity<?> getAllLoginDetails() {
//                Map<String, Object> map = new LinkedHashMap<>();
//                List<LoginDTO> loginList = loginservice
//                if (!loginList.isEmpty()) {
//                    map.put("status", 1);
//                    map.put("data", loginList);
//                    return new ResponseEntity<>(map, HttpStatus.OK);
//                } else {
//                    map.clear();
//                    map.put("status", 0);
//                    map.put("message", "Login detail list is not found");
//                    return new ResponseEntity<>(map, HttpStatus.OK);
//                }
//            }

            @PostMapping("/addlogindetails")
            public ResponseEntity<?> addLoginDetails(@RequestBody LoginDTO userdata) throws NoSuchAlgorithmException {
                Map<String, Object> map = new LinkedHashMap<String, Object>();
                LoginDTO loginDetails = loginService.addLoginDetails(userdata);
                if (loginDetails != null) {
                    map.put("status", 1);
                    map.put("data", loginDetails);
                    return new ResponseEntity<>(map, HttpStatus.OK);
                } else {
                    map.clear();
                    map.put("status", 0);
                    map.put("message", "Login details is not found");
                    return new ResponseEntity<>(map, HttpStatus.OK);
                }
            }

//    @PutMapping("/updatepassword/{userId}")
//    public ResponseEntity<?> updatePassword(@PathVariable int userId, @RequestBody UpdatePasswordRequestDTO updateRequest) throws NoSuchAlgorithmException{
//        Map<String, Object> map = new LinkedHashMap<String, Object>();
//        int result = loginservice.updatePassword(userId,updateRequest);
//
//        if (result == 1) {
//            map.put("status", 1);
//            map.put("data", "Password updated");
//            return new ResponseEntity<>(map, HttpStatus.OK);
//        } else if (result==-1) {
//            map.clear();
//            map.put("status", 0);
//            map.put("message", "User not found");
//            return new ResponseEntity<>(map, HttpStatus.OK);
//        }
//        else if (result==-2) {
//            map.clear();
//            map.put("status", 0);
//            map.put("message", "Update password is failed");
//            return new ResponseEntity<>(map, HttpStatus.OK);
//        }
//        else {
//            map.clear();
//            map.put("status", 0);
//            map.put("message", "Invalid current password");
//            return new ResponseEntity<>(map, HttpStatus.OK);
//        }
//    }

//            @PostMapping("/validateemail")
//            public ResponseEntity<?> validateEmail(@RequestBody String email) {
//                Map<String, Object> map = new LinkedHashMap<String, Object>();
//                boolean valid = loginservice.validateEmail(email);
//
//                if (valid) {
//                    map.put("status", 1);
//                    map.put("message", "Email is available");
//                    return new ResponseEntity<>(map, HttpStatus.OK);
//                } else {
//                    map.clear();
//                    map.put("status", 0);
//                    map.put("message", "Email is not available");
//                    return new ResponseEntity<>(map, HttpStatus.OK);
//                }
//            }

//            @GetMapping("/getemailbyloginid/{userId}")
//            public ResponseEntity<?> getEmailByLoginId(@PathVariable int loginId) {
//                Map<String, Object> map = new LinkedHashMap<String, Object>();
//                LoginUserDetailsDTO user = loginservice.getEmailByLoginId(loginId);
//
//                if (user != null) {
//                    map.put("status", 1);
//                    map.put("data", user.getEmail());
//                    return new ResponseEntity<>(map, HttpStatus.OK);
//                } else {
//                    map.clear();
//                    map.put("status", 0);
//                    map.put("message", "Email not found");
//                    return new ResponseEntity<>(map, HttpStatus.OK);
//                }
//            }

    @PostMapping("login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO data){

                return ResponseEntity.ok(loginService.login(data));
    }

}
