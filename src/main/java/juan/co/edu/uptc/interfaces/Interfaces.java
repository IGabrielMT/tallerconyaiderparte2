package juan.co.edu.uptc.interfaces;

import co.edu.uptc.models.SimpleList;
import juan.co.edu.uptc.pojos.Vehicle;

import java.util.List;

public interface Interfaces {
    interface Model {
        List<Vehicle> listByCountry_byState();
        List<String> listByCountry_byCountryQuantity();
        List<String> listByState();
        List<String> listByCity();
        List<Vehicle> allVehicles();
        List<String> getVehiclesModels();
        List<String> getVehiclesManufacturers();
        String countByModelManufacturerAndElectricRange(String model, String manufacturer, int electricRange);
    }

    interface View {
        void start();
        void setPresenter(Presenter presenter);
    }


    interface Presenter {
        Object[][] obtainVehicles();
        Object[][] obtainVehiclesBycity();
        Object[][] obtainVehiclesByCountry();
        Object[][] obtainVehiclesByState();
        void setModel(Model model);

        void setView(View view);

        void start();

        Object[] getVehicleModels();

        Object[] getManufacters();

        String countByModelManufacturerAndElectricRange(String model, String manufacturer, int electricRange);
    }
}