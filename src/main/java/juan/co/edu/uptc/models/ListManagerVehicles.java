package juan.co.edu.uptc.models;

import juan.co.edu.uptc.interfaces.Interfaces;
import juan.co.edu.uptc.pojos.Vehicle;

import java.util.List;

public class ListManagerVehicles implements Interfaces.Model{

    @Override
    public List<Vehicle> ListByCountry() {

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
