package CS304.Autocarsale.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDTO {
    private String Brand;
    private String Model;
    private Integer Manufacture_year;
    private Integer Mileage;
    private String Condition;
    private Integer price;
    private String Description;
    private String  Sel_Name;
    private String S_email;
    private String S_phonenum;
    private String S_Address;
}
