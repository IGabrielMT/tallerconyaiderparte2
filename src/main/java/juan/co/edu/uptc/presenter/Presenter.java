package juan.co.edu.uptc.presenter;

import co.edu.uptc.models.SimpleList;
import juan.co.edu.uptc.interfaces.Interfaces;
import juan.co.edu.uptc.models.CreateObjects;
import juan.co.edu.uptc.models.ListManagerVehicles;
import juan.co.edu.uptc.pojos.Vehicle;

import java.util.List;

public class Presenter implements Interfaces.Presenter {
    private Interfaces.Model model;
    private Interfaces.View view;
    private List<Vehicle> vehicles;
    public Presenter() {
    }

    @Override
    public Object[][] obtainVehicles() {
        return transformToMatrix(vehicles);
    }

    @Override
    public Object[][] obtainVehiclesBycity() {
        return null;
    }

    @Override
    public Object[][] obtainVehiclesByCountry() {
        return new Object[0][];
    }

    @Override
    public Object[][] obtainVehiclesByState() {
        return new Object[0][];
    }

    @Override
    public void registerAppointment(String[] strings) {

    }

    @Override
    public void setModel(Interfaces.Model model) {
        this.model = model;
    }

    @Override
    public void setView(Interfaces.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        vehicles = model.allVehicles();
    }


    private Object[][] transformToMatrix(List<Vehicle> vehicles) {
        Object[][] data = new Object[vehicles.size()][10];
        for (int i = 0; i < vehicles.size(); i++) {
            data[i] = fillRow(vehicles.get(i));
        }
        return data;
    }

    private Object[] fillRow(Vehicle vehicle) {
        Object[] row = new Object[11];
        row[0] = vehicle.getState();
        row[1] = vehicle.getCountry();
        row[2] = vehicle.getCity();
        row[3] = vehicle.getModelVehicle();
        row[4] = vehicle.getManufacturer();
        row[5] = vehicle.getElectricRange();
        return row;
    }
}
