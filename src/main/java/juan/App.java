package juan;

import co.edu.uptc.models.SimpleList;
import com.fasterxml.jackson.databind.ObjectMapper;
import juan.co.edu.uptc.interfaces.Interfaces;
import juan.co.edu.uptc.models.CreateObjects;
import juan.co.edu.uptc.models.ListManagerVehicles;
import juan.co.edu.uptc.models.ReadFromURL;
import juan.co.edu.uptc.pojos.ElectricVehicle;
import juan.co.edu.uptc.pojos.Vehicle;
import juan.co.edu.uptc.presenter.Presenter;
import juan.co.edu.uptc.views.mainpage.MainPageFrame;
import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class App {
    @SneakyThrows
    public static void main(String[] args) {
        Interfaces.Presenter presenter = new Presenter();
        Interfaces.Model model = new ListManagerVehicles();

        presenter.setModel(model);

        Interfaces.View view = new MainPageFrame();
        view.setPresenter(presenter);
        presenter.setView(view);
        presenter.start();
        view.start();
//
//        ListManagerVehicles listManagerVehicles = new ListManagerVehicles();
//        for (String vehicle : listManagerVehicles.ListByCity()){
//            System.out.println(vehicle);
//        }

   }
}
