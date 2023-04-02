package CS304.Autocarsale.Repositary;

import CS304.Autocarsale.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositary extends JpaRepository<User,Integer>  {

//    @Query(value = "select u from User where u.email =?1",nativeQuery = true);
//    String getEmail();

}
