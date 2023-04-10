package CS304.Autocarsale.Service;

import CS304.Autocarsale.DTO.LoginDTO;
import CS304.Autocarsale.DTO.LoginResponseDTO;
import CS304.Autocarsale.Entity.Login;
import CS304.Autocarsale.Repositary.LoginRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

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

    public LoginResponseDTO login(LoginDTO data) {

        Login l = loginRepository.validateLogin(data.getEmail(), data.getPassword());
        if(l != null){
            return LoginResponseDTO.builder().userID(l.getUser().getUserID()).role(l.getUser().getRole()).name(l.getUser().getName()).phone_num(l.getUser().getPhone_num()).email(l.getEmail()).build();
        }
        return null;
    }
}
