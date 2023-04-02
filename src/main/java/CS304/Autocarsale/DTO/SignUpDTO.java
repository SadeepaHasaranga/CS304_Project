package CS304.Autocarsale.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {

    private String name;
    private String address;
    private String phone_num;
    private String nic;
    private String email;
    private String role;
    private String password;

}
