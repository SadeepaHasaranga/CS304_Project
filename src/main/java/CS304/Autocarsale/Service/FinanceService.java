package CS304.Autocarsale.Service;

import CS304.Autocarsale.Entity.Finance;
import CS304.Autocarsale.Repositary.FinanceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FinanceService {

    @Autowired
    FinanceRepository financeRepository;

    @Autowired
    ModelMapper modelMapper;

    public Finance saveFinance(Finance finance){

        return financeRepository.save(finance);
    }

}
