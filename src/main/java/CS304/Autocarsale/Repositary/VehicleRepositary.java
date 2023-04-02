package CS304.Autocarsale.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import CS304.Autocarsale.Entity.Vehicle;
public interface VehicleRepositary extends JpaRepository<Vehicle,Integer> {

}
