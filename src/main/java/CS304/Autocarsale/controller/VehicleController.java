package CS304.Autocarsale.controller;

import CS304.Autocarsale.DTO.UserDTO;
import CS304.Autocarsale.DTO.VehicleDTO;
import CS304.Autocarsale.DTO.VehiclePriceDto;
import CS304.Autocarsale.Entity.Vehicle;
import CS304.Autocarsale.Service.UserService;
import CS304.Autocarsale.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

//    @PostMapping("/save")
//    public String save(@RequestBody VehicleDTO vehicleDTO){
//        return vehicleService.saveVehicle(vehicleDTO);
//        //  return "saved";
//    }

    @PostMapping("/save")
    public String saveVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.saveVehicle(vehicle);
    }

    @GetMapping("/getVehicles")
    public List<Vehicle> allVehicles(){
        return vehicleService.getVehicle();
    }

    @GetMapping("/allPrices")
    public List<VehiclePriceDto> getALlPriceOfVehicles(){
        return vehicleService.getPriceList();
    }

    //@GetMapping("/")

}
