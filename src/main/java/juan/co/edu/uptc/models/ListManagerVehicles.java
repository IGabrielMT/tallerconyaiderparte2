package juan.co.edu.uptc.models;

import co.edu.uptc.models.SimpleList;
import juan.co.edu.uptc.interfaces.Interfaces;
import juan.co.edu.uptc.pojos.Vehicle;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListManagerVehicles implements Interfaces.Model{
    private final SimpleList<Vehicle> listVehicles;

    public ListManagerVehicles(){
        CreateObjects createObjects = new CreateObjects();
        listVehicles = createObjects.getVehicles();
    }

    @Override
    public List<Vehicle> ListByCountry_byState() {
        return null;
    }

    private List<Vehicle> createListByCountry() {
        listVehicles.sort(VehicleComparator.byCountry());
        return null;
    }


    @Override
    public List<Vehicle> ListByCountry_byCountryQuantity() {
        return List.of();
    }

    @Override
    public List<String> ListByState() {
    SimpleList<String> existingStates = new SimpleList<>();
    int[] counts = countVehiclesByState(existingStates);
    sortStatesByCount(existingStates, counts);
    return createStatePlusQuantityList(existingStates, counts);
}
    private int[] countVehiclesByState(SimpleList<String> existingStates) {
        int[] counts = new int[listVehicles.size()];
        for (Vehicle vehicle : listVehicles) {
            String state = vehicle.getState();
            int index = existingStates.indexOf(state);
            if (index == -1) {
                existingStates.add(state);
                counts[existingStates.size() - 1] = 1;
            } else {
                counts[index]++;
            }
        }
        return counts;
    }
    private void sortStatesByCount(SimpleList<String> existingStates, int[] counts) {
        for (int i = 0; i < existingStates.size() - 1; i++) {
            for (int j = i + 1; j < existingStates.size(); j++) {
                if (counts[i] < counts[j]) {
                    int tempCount = counts[i];
                    counts[i] = counts[j];
                    counts[j] = tempCount;

                    String tempState = existingStates.get(i);
                    existingStates.set(i, existingStates.get(j));
                    existingStates.set(j, tempState);
                }
            }
        }
    }
    private List<String> createStatePlusQuantityList(SimpleList<String> existingStates, int[] counts) {
        SimpleList<String> statePlusQuantity = new SimpleList<>();
        for (int i = 0; i < existingStates.size(); i++) {
            statePlusQuantity.add(existingStates.get(i) + " " + counts[i]);
        }
        return statePlusQuantity;
    }

    @Override
    public List<String> ListByCity() {
        return List.of();
    }

    @Override
    public List<Vehicle> allVehicles() {
        return listVehicles;
    }

}
