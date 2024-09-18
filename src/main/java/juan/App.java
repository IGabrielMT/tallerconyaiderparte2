package juan;

import com.fasterxml.jackson.databind.ObjectMapper;
import juan.co.edu.uptc.models.CreateObjects;
import juan.co.edu.uptc.models.ReadFromURL;
import juan.co.edu.uptc.pojos.ElectricVehicle;
import juan.co.edu.uptc.pojos.Vehicle;
import juan.co.edu.uptc.views.mainpage.MainPageFrame;
import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class App {
    @SneakyThrows
    public static void main(String[] args) {
        MainPageFrame mainPageFrame = new MainPageFrame();
        mainPageFrame.start();
        CreateObjects createObjects = new CreateObjects();
        List<Vehicle> list= createObjects.getVehicles();
   }
}
