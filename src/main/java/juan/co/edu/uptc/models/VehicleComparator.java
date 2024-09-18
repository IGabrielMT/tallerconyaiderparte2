package juan.co.edu.uptc.models;

import juan.co.edu.uptc.pojos.Vehicle;

import java.util.Comparator;

public class VehicleComparator {

    public static Comparator<Vehicle> byState() {
        return Comparator.comparing(Vehicle::getState);
    }

    public static Comparator<Vehicle> byCountry() {
        return Comparator.comparing(Vehicle::getCountry);
    }

    public static Comparator<Vehicle> byCity() {
        return Comparator.comparing(Vehicle::getCity);
    }

    public static Comparator<Vehicle> byModelVehicle() {
        return Comparator.comparing(Vehicle::getModelVehicle);
    }

    public static Comparator<Vehicle> byManufacturer() {
        return Comparator.comparing(Vehicle::getManufacturer);
    }

    public static Comparator<Vehicle> byElectricRange() {
        return Comparator.comparing(Vehicle::getElectricRange);
    }


}