package CS304.Autocarsale.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private int userID;
    private String name;
    private String address;
    private String phone_num;
    private String nic;
    private String role;
}
