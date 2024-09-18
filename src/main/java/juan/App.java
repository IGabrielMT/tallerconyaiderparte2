package juan;

import com.fasterxml.jackson.databind.ObjectMapper;
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
//        ObjectMapper om = new ObjectMapper();
//        String inputStream = ReadFromURL.getFileFromURL("https://data.wa.gov/api/views/f6w7-q2d2/rows.json?accessType=DOWNLOAD");
////        ElectricVehicle root = om.readValue(inputStream, ElectricVehicle.class);
////        int cont = 0;
////        for (ArrayList<Object> vehicle : root.data) {
////            System.out.print("Vehicle " + cont++ + ": ");
////            System.out.println(vehicle);
////        }
//        System.out.println(inputStream);

   }
}
