package juan.co.edu.uptc.presenter;

import juan.co.edu.uptc.interfaces.Interfaces;

public class Presenter implements Interfaces.Presenter {
    public Presenter() {
    }


    @Override
    public String[] obtainVaccinesName() {
        return new String[0];
    }

    @Override
    public Object[][] obtainVehicles() {
        return new Object[0][];
    }

    @Override
    public Object[][] obtainVehiclesBycity() {
        return new Object[0][];
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
    public void getDataAndSetData() {

    }

    @Override
    public Object[][] obtainVisitsUpWeight(int i) {
        return new Object[0][];
    }

    @Override
    public Object[][] obtainVisitsDownWeight(int i) {
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
    public void start() {

    }
}
