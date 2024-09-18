package juan;

import com.fasterxml.jackson.databind.ObjectMapper;
import juan.co.edu.uptc.models.ElectricVehicleManager;
import juan.co.edu.uptc.models.ReadFromURL;
import juan.co.edu.uptc.pojos.ElectricVehicle;
import juan.co.edu.uptc.views.mainpage.MainPageFrame;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class App {
    @SneakyThrows
    public static void main(String[] args) {
        MainPageFrame mainPageFrame = new MainPageFrame();
        mainPageFrame.start();
   }
}
