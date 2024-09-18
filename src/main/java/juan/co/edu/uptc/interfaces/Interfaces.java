package juan.co.edu.uptc.interfaces;

import juan.co.edu.uptc.pojos.Vehicle;

import java.util.List;

public interface Interfaces {
    interface Model {
        List<Vehicle> ListByCountry();
        List<Vehicle> ListByState();
        List<Vehicle> ListByCity();
        void setPresenter(Presenter presenter);
    }

    interface View {
        void start();

        void setPresenter(Presenter presenter);
    }


    interface Presenter {
        String[] obtainVaccinesName();
        Object[][] obtainVehicles();
        Object[][] obtainVehiclesBycity();
        Object[][] obtainVehiclesByCountry();
        Object[][] obtainVehiclesByState();
        void getDataAndSetData();
        Object[][] obtainVisitsUpWeight(int i);
        Object[][] obtainVisitsDownWeight(int i);
        void registerAppointment(String[] strings);

        void setModel(Model model);

        void setView(View view);

        void start();
    }
}