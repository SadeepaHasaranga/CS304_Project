package CS304.Autocarsale.Service;

import CS304.Autocarsale.DTO.LoginDTO;
import CS304.Autocarsale.DTO.SignUpDTO;
import CS304.Autocarsale.DTO.UserDTO;
import CS304.Autocarsale.Entity.Login;
import CS304.Autocarsale.Entity.User;
import CS304.Autocarsale.Repositary.LoginRepository;
import CS304.Autocarsale.Repositary.UserRepositary;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
   @Autowired
   private UserRepositary userRepositary;

   @Autowired
   private ModelMapper modelMapper;

   @Autowired
   private LoginService loginService;
   @Autowired
   private LoginRepository loginRepository;

    public UserDTO saveUser(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        User user1 = userRepositary.save(user);

        return modelMapper.map(user1,new TypeToken<UserDTO>(){}.getType());

    }

    public UserDTO addUser(SignUpDTO data){
        try{
            boolean validate = loginService.validateEmail(data.getEmail());

            if (validate){
                User newUser = new User();
                newUser.setName(data.getName());
                newUser.setAddress(data.getAddress());
                newUser.setPhone_num(data.getPhone_num());
                newUser.setNic(data.getNic());
                newUser.setRole(data.getRole());

                User u = userRepositary.save(newUser);

                if(u != null){
                    Login l = new Login(0, data.getEmail(), data.getPassword(), u);

                    LoginDTO loginDTO = modelMapper.map(l,new TypeToken<LoginDTO>(){}.getType());
                    LoginDTO k = loginService.addLoginDetails(loginDTO);

                    if (k != null){
                        return modelMapper.map(u,new TypeToken<UserDTO>(){}.getType());
                    }else {
                        return null;
                    }
                }
                return null;
                }else {
                    return null;
                }

        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    public List<User> getAllUsers(){
       return userRepositary.findAll();
    }

    public Optional<User> searchById(int id){
        return userRepositary.findById(id);
    }



}
