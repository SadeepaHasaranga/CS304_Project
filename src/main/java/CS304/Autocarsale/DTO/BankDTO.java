package CS304.Autocarsale.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class BankDTO {
    private String bankID;
    private String name;
    private String job;
    private String phonenum;
    private String  address;
    private int amount;
    private String bankName;

}
