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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="userID",referencedColumnName = "userID")
    private User user;

}