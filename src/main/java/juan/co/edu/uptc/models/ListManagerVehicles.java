package juan.co.edu.uptc.models;

import co.edu.uptc.models.SimpleList;
import juan.co.edu.uptc.interfaces.Interfaces;
import juan.co.edu.uptc.pojos.Vehicle;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListManagerVehicles implements Interfaces.Model{
    private final SimpleList<Vehicle> listVehicles;

    public ListManagerVehicles(){
        CreateObjects createObjects = new CreateObjects();
        listVehicles = createObjects.getVehicles();

    }

    @Override
    public List<Vehicle> ListByCountry_byState() {

    }

    private List<Vehicle> createListByCountry() {
        listVehicles.sort(VehicleComparator.);
    }


    @Override
    public List<Vehicle> ListByCountry_byCountryQuantity() {
        return List.of();
    }
//TODO: Terminar este metodo
    @Override
    public List<Vehicle> ListByState() {
        int cont = 0;
        for (Vehicle vehicle : listVehicles) {
            String state;
            state = vehicle.getState();
            if (vehicle.getState() == state){
                cont++;
            }
        }
    }

    @Override
    public List<Vehicle> ListByCity() {
        return List.of();
    }

    @Override
    public List<Vehicle> allVehicles() {
        return listVehicles;
    }



}
