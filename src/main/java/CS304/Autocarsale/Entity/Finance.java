package CS304.Autocarsale.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table




public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fID;
    private String name;
    private String phonenum;
    private String address;
    private String email;
    private String company;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="userID",referencedColumnName = "userID")
private User user;

}
