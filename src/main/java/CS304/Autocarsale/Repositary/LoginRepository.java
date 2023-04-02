package CS304.Autocarsale.Repositary;

import CS304.Autocarsale.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface LoginRepository extends JpaRepository<Login,Integer> {

    @Query(value = "SELECT * FROM login WHERE email =?1",nativeQuery = true)
    Login validateEmail(String email);
}


