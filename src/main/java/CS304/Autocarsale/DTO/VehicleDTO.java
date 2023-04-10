package CS304.Autocarsale.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDTO {
    private int vehicleID;
    private String brand;
    private String model;
    private int manufactureYear;
    private int mileage;
    private String cndition;
    private int price;
    private String description;
    private String  name;
    private String email;
    private String phonenum;
    private String address;
    private Integer userId;
}
