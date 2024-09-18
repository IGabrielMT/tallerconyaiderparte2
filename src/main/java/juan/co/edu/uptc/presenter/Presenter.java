package juan.co.edu.uptc.presenter;

import co.edu.uptc.models.SimpleList;
import juan.co.edu.uptc.interfaces.Interfaces;
import juan.co.edu.uptc.pojos.Vehicle;

public class Presenter implements Interfaces.Presenter {

    private Object[][] vehicles;

    public Presenter() {
    }

    @Override
    public Object[][] obtainVehicles() {
        return vehicles;
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

    }

    @Override
    public void setView(Interfaces.View view) {

    }

    @Override
    public void start(SimpleList<Vehicle> vehicles) {
        this.vehicles = transformToMatrix(vehicles);
    }

    private Object[][] transformToMatrix(SimpleList<Vehicle> vehicles) {
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
