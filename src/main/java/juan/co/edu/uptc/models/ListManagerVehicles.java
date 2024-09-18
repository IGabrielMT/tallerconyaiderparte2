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
        return List.of();
    }

    private List<Vehicle> createListByCountry() {
        listVehicles.sort(VehicleComparator.byCountry());
        return listVehicles;
    }


    @Override
    public List<Vehicle> ListByCountry_byCountryQuantity() {
        return List.of();
    }

    @Override
    public List<Vehicle> ListByState() {
        return List.of();
    }

    @Override
    public List<Vehicle> ListByCity() {
        return List.of();
    }

    @Override
    public List<Vehicle> allVehicles() {
        return listVehicles;
    }

    @Override
    public void setPresenter(Interfaces.Presenter presenter) {

    }

}
