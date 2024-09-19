package juan.co.edu.uptc.presenter;

import juan.co.edu.uptc.interfaces.Interfaces;
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
        List<String> listCity = model.listByCity();
        Object[][] data = new Object[listCity.size() / 2][2];
        for (int i = 0; i < listCity.size(); i += 2) {
            data[i / 2][0] = listCity.get(i);
            data[i / 2][1] = listCity.get(i + 1);
        }
        return data;
    }

    @Override
    public Object[][] obtainVehiclesByCountry() {
        return new Object[0][];
    }

    @Override
    public Object[][] obtainVehiclesByState() {
        List<String> listByState = model.listByState();
        Object[][] data = new Object[listByState.size()][2];
        for (int i = 0; i < listByState.size(); i++) {
            String[] parts = listByState.get(i).split(" ");
            data[i][0] = parts[0];
            data[i][1] = parts[1];
        }
        return data;
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

    @Override
    public Object[] getVehicleModels() {
        return model.getVehiclesModels().toArray();
    }

    @Override
    public Object[] getManufacters() {
        return model.getVehiclesManufacturers().toArray();
    }

    @Override
    public String countByModelManufacturerAndElectricRange(String modelV, String manufacturer, int electricRange) {
        return model.countByModelManufacturerAndElectricRange(modelV, manufacturer, electricRange);
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
