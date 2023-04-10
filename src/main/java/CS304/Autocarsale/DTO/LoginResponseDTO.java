package CS304.Autocarsale.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDTO {
    private Integer userID;
    private String name;
    private String phone_num;
    private String email;

    private String role;

}
