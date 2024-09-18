package juan.co.edu.uptc.models;

import co.edu.uptc.models.SimpleList;
import com.fasterxml.jackson.databind.ObjectMapper;
import juan.co.edu.uptc.pojos.*;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class CreateObjects {
    ElectricVehicle root;
    @Getter
    SimpleList<Vehicle> vehicles;

    public CreateObjects(){
        root = createElectricVehicle();
        exeStringToData();
    }
    @SneakyThrows
    private ElectricVehicle createElectricVehicle() {
        ObjectMapper om = new ObjectMapper();
//        InputStream inputStream = new FileInputStream("src/main/resources/api/rows.json");
        String inputStream = ReadFromURL.getFileFromURL("https://data.wa.gov/api/views/f6w7-q2d2/rows.json?accessType=DOWNLOAD");
        return om.readValue(inputStream, ElectricVehicle.class);
    }
    private void exeStringToData(){
        vehicles = new SimpleList<>();
        for (ArrayList<Object> vehicle : root.data) {
            stringToData(vehicle);
        }
    }

    private void stringToData(ArrayList dataString){
        Vehicle vehicle = new Vehicle();
        vehicle.setCountry(dataString.get(9)+"");
        vehicle.setCity(dataString.get(10)+"");
        vehicle.setState(dataString.get(11)+"");
        vehicle.setManufacturer(dataString.get(14)+"");
        vehicle.setModelVehicle(dataString.get(15)+"");

        vehicles.add(vehicle);
        if(dataString.get(18)==null){
            vehicle.setElectricRange(String.valueOf(0));
        }else{
            vehicle.setElectricRange(dataString.get(18)+"");
        }
    }

}
