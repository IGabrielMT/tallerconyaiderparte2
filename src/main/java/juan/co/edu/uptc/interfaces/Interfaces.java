package juan.co.edu.uptc.interfaces;

import co.edu.uptc.models.SimpleList;
import juan.co.edu.uptc.pojos.Vehicle;

import java.util.List;

public interface Interfaces {
    interface Model {
        List<Vehicle> ListByCountry_byState();
        List<Vehicle> ListByCountry_byCountryQuantity();
        List<Vehicle> ListByState();
        List<Vehicle> ListByCity();
        List<Vehicle> allVehicles();
        void setPresenter(Presenter presenter);
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

        void registerAppointment(String[] strings);

        void setModel(Model model);

        void setView(View view);

        void start();
    }
}