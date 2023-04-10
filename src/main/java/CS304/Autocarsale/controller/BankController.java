package CS304.Autocarsale.controller;


import CS304.Autocarsale.DTO.BankDTO;
import CS304.Autocarsale.DTO.SignUpDTO;
import CS304.Autocarsale.DTO.UserDTO;
import CS304.Autocarsale.Entity.Bank;
import CS304.Autocarsale.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bank")
@CrossOrigin("*")
public class BankController {
    @Autowired
    private BankService bankService;

//    @PostMapping("/save")
//    public BankDTO saveBank(@RequestBody BankDTO bankDTO) {
////        return bankService.addBank(BankDTO);
//    }

    @PostMapping("/save")
    public Bank saveDetails(@RequestBody Bank bank){
        return bankService.saveBank(bank);
    }

}
