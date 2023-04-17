package CS304.Autocarsale.Service;

import CS304.Autocarsale.DTO.LoginDTO;
import CS304.Autocarsale.DTO.LoginResponseDTO;
import CS304.Autocarsale.DTO.UserDTO;
import CS304.Autocarsale.Entity.Login;
import CS304.Autocarsale.Entity.User;
import CS304.Autocarsale.Repositary.LoginRepository;
import CS304.Autocarsale.Repositary.UserRepositary;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private UserRepositary userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public boolean validateEmail(String email){
        Login login = loginRepository.validateEmail(email);
        if(login == null){
            return true;
        }
        return false;
    }

    public LoginDTO addLoginDetails(LoginDTO loginDTO){
        Login login = modelMapper.map(loginDTO, Login.class);

        Login l = loginRepository.save(login);

        if(login != null){
            return modelMapper.map(l,new TypeToken<LoginDTO>(){}.getType());
        }
        return  null;
    }

    public UserDTO login(LoginDTO data) {
        Login l = loginRepository.validateLogin(data.getEmail(), data.getPassword());
        if(l != null){
            User user=userRepo.getReferenceById(l.getLoginId());
            return modelMapper.map(user,new TypeToken<UserDTO>(){}.getType());
        }
        return null;
    }
}
