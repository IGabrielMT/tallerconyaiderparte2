package juan.co.edu.uptc.interfaces;

public interface Interfaces {
    interface Model {

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
    }
}