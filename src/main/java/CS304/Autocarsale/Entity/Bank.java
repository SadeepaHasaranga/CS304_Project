package CS304.Autocarsale.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;
import org.modelmapper.internal.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.WebProperties;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Bank")

public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankID;
    private String name;
    private String job;
    private String phonenum;
    private String  address;
    private int amount;
    private String bank;


//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="userID",referencedColumnName = "userID")

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userID",referencedColumnName = "userID")
    private User user;
}

