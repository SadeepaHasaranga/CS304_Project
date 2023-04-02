package CS304.Autocarsale.Service;

import CS304.Autocarsale.DTO.VehicleDTO;
import CS304.Autocarsale.DTO.VehiclePriceDto;
import CS304.Autocarsale.Entity.Vehicle;
import CS304.Autocarsale.Repositary.VehicleRepositary;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private VehicleRepositary vehicleRepositary;
//    public String saveVehicle(VehicleDTO vehicleDTO) {
//        vehicleRepositary.save(modelMapper.map(vehicleDTO, Vehicle.class));
//        return "saved";
//    }

    public String saveVehicle(Vehicle vehicle){
        vehicleRepositary.save(vehicle);
        return "Saved";
    }

    public List<Vehicle> getVehicle(){
        return vehicleRepositary.findAll();
    }

    public List<VehiclePriceDto> getPriceList(){
        List<Vehicle> vehicles = vehicleRepositary.findAll();

        return modelMapper.map(vehicles,new TypeToken<ArrayList<VehiclePriceDto>>(){}.getType());

    }

}
