package CS304.Autocarsale.controller;

import CS304.Autocarsale.DTO.SignUpDTO;
import CS304.Autocarsale.DTO.UserDTO;
import CS304.Autocarsale.Entity.User;
import CS304.Autocarsale.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public UserDTO saveUser(@RequestBody SignUpDTO signUpDTO){
        return userService.addUser(signUpDTO);
      //  return "saved";
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable int id){
        return userService.searchById(id);
    }


}
