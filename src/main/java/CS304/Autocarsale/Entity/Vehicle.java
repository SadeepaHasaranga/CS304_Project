package CS304.Autocarsale.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleID;
    private String brand;
    private String vehicleModel;
    private int manufactureYear;
    private int Mileage;
    private String vehicleCondition;
    private int price;
    private String description;
    private String  Sel_Name;
    private String S_email;
    private String S_phonenum;
    private String S_Address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userID",referencedColumnName = "userID")
    private User user;

}