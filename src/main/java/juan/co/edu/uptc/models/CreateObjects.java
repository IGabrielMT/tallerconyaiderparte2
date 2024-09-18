package juan.co.edu.uptc.models;

import co.edu.uptc.models.SimpleList;
import com.fasterxml.jackson.databind.ObjectMapper;
import juan.co.edu.uptc.pojos.*;
import lombok.SneakyThrows;
import java.util.List;

public class CreateObjects {
    @SneakyThrows
    private ElectricVehicle createElectricVehicle() {
        ObjectMapper om = new ObjectMapper();
        String inputStream = ReadFromURL.getFileFromURL("https://data.wa.gov/api/views/f6w7-q2d2/rows.json?accessType=DOWNLOAD");
        ElectricVehicle root = om.readValue(inputStream, ElectricVehicle.class);
        return root;
    }

    private List<Vehicle> createVehicles() {
        ElectricVehicle electricVehicle = createElectricVehicle();
        List<Vehicle> vehicles = new SimpleList<>();
        for (List<Object> vehicle : electricVehicle.data) {
            Vehicle v = new Vehicle();

            vehicles.add(v);
        }
        return vehicles;
    }


}
