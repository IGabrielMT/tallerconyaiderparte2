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
        createListByCountry();
    }

    private void createListByCountry() {
        Collections.sort(listVehicles, );
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
    public void setPresenter(Interfaces.Presenter presenter) {

    }
}
