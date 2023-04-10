package CS304.Autocarsale.Service;

import CS304.Autocarsale.DTO.BankDTO;
import CS304.Autocarsale.DTO.UserDTO;
import CS304.Autocarsale.Entity.Bank;
import CS304.Autocarsale.Entity.User;
import CS304.Autocarsale.Repositary.BankRepositary;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    BankRepositary bankRepositary;

    @Autowired
    ModelMapper modelMapper;


    public Bank saveBank(Bank bank) {
//        Bank bank = modelMapper.map(bankDTO, Bank.class);
//        Bank bank1 = bankRepositary.save(bank);
//
//        return modelMapper.map(bank1, new TypeToken<BankDTO>() {
//        }.getType());
        return bankRepositary.save(bank);

    }

}
