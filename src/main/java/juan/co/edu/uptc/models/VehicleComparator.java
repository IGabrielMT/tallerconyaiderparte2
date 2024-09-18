package juan.co.edu.uptc.models;
import juan.co.edu.uptc.pojos.Vehicle;

import java.util.Comparator;

public class VehicleComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        // Comparar por estado
        int stateComparison = v1.getState().compareTo(v2.getState());
        if (stateComparison != 0) {
            return stateComparison;
        }

        // Comparar por país
        int countryComparison = v1.getCountry().compareTo(v2.getCountry());
        if (countryComparison != 0) {
            return countryComparison;
        }

        // Comparar por ciudad
        int cityComparison = v1.getCity().compareTo(v2.getCity());
        if (cityComparison != 0) {
            return cityComparison;
        }

        // Comparar por modelo de vehículo
        int modelComparison = v1.getModelVehicle().compareTo(v2.getModelVehicle());
        if (modelComparison != 0) {
            return modelComparison;
        }

        // Comparar por fabricante
        int manufacturerComparison = v1.getManufacturer().compareTo(v2.getManufacturer());
        if (manufacturerComparison != 0) {
            return manufacturerComparison;
        }

        // Comparar por rango eléctrico
        return v1.getElectricRange().compareTo(v2.getElectricRange());
    }
}