package CS304.Autocarsale.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;
    private String name;
    private String address;
    private String phone_num;
    private String nic;
    private String role;
    @OneToOne(mappedBy = "user")
    private Login login;
    @OneToMany(mappedBy ="user", cascade = CascadeType.REMOVE)
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "user")
     private List<Bank> banks;

   @OneToMany(mappedBy = "user")
    private List<Finance> finances;

}

