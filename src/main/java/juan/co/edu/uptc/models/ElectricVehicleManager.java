package juan.co.edu.uptc.models;

import co.edu.uptc.models.SimpleList;
import com.fasterxml.jackson.databind.ObjectMapper;
import juan.co.edu.uptc.pojos.ElectricVehicle;

import java.util.ArrayList;

public class ElectricVehicleManager {
    private String url;
    private SimpleList<ElectricVehicle> electricVehicles;

    public ElectricVehicleManager(String url) {
        this.url = url;
        this.electricVehicles = new SimpleList<>();
    }

    public void loadElectricVehicles() throws Exception {
        ObjectMapper om = new ObjectMapper();
        String inputStream = ReadFromURL.getFileFromURL(url);
        ElectricVehicle root = om.readValue(inputStream, ElectricVehicle.class);
        for (ArrayList<Object> vehicle : root.data) {
            for (Object o : vehicle) {
                electricVehicles.add(om.convertValue(o, ElectricVehicle.class));
            }
        }
    }
}