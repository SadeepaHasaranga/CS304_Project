package CS304.Autocarsale.DTO;

import CS304.Autocarsale.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    private int loginId;
    private String email;
    private String password;

    private int userID;
}
