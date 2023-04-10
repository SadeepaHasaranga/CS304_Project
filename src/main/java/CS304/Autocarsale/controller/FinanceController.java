package CS304.Autocarsale.controller;


import CS304.Autocarsale.Entity.Bank;
import CS304.Autocarsale.Entity.Finance;
import CS304.Autocarsale.Service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/finance")
public class FinanceController {
    @Autowired
    private FinanceService financeService;

    @PostMapping("/save")
    public Finance saveDetails(@RequestBody Finance finance){

        return financeService.saveFinance(finance);
    }

}
