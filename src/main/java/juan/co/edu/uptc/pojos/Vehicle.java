package juan.co.edu.uptc.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Vehicle {
    private String state;
    private String country;
    private String city;
    private String modelVehicle;
    private String manufacturer;
    private String electricRange;
}
