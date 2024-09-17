package juan;

import juan.co.edu.uptc.interfaces.Interfaces;
import juan.co.edu.uptc.models.JSONReader;
import juan.co.edu.uptc.pojos.ElectricVehicles;
import juan.co.edu.uptc.presenter.Presenter;
import juan.co.edu.uptc.views.mainpage.MainPageFrame;

import java.util.List;


public class App {
    public static void main(String[] args) {
        MainPageFrame mainPageFrame = new MainPageFrame();
        Interfaces.Presenter presenter = new Presenter();
        mainPageFrame.setPresenter(presenter);
        mainPageFrame.start();

        List<ElectricVehicles> list = JSONReader.readJsonFromUrl("https://data.wa.gov/api/views/f6w7-q2d2/rows.json?accessType=DOWNLOAD", ElectricVehicles.class);
        for (ElectricVehicles electricVehicles : list) {
            System.out.println(electricVehicles);
        }
    }
}
