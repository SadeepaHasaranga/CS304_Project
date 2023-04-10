package CS304.Autocarsale.Repositary;

import CS304.Autocarsale.Entity.Bank;
import CS304.Autocarsale.Entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRepository extends JpaRepository<Finance,Integer> {
}
