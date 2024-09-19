package juan.co.edu.uptc.models;

import co.edu.uptc.models.SimpleList;
import juan.co.edu.uptc.interfaces.Interfaces;
import juan.co.edu.uptc.pojos.Vehicle;

import java.util.*;

public class ListManagerVehicles implements Interfaces.Model{
    private final SimpleList<Vehicle> listVehicles;

    public ListManagerVehicles(){
        CreateObjects createObjects = new CreateObjects();
        listVehicles = createObjects.getVehicles();
    }
    @Override
    public List<Vehicle> listByCountry_byState() {
        List<Vehicle> sortedVehicles = new java.util.ArrayList<>(new java.util.ArrayList<>(List.copyOf(listVehicles)));
        sortedVehicles.sort(VehicleComparator.byState());
        return sortedVehicles;
    }

    @Override
    public List<String> listByCountry_byCountryQuantity() {
        List<Vehicle> sortedByState = listByCountry_byState();
        List<List<Vehicle>> separatedByState = separateByState(sortedByState);
        return createCountryPlusQuantityList(separatedByState);
    }

    private List<String> createCountryPlusQuantityList(List<List<Vehicle>> separatedByState) {
        Map<String, Integer> countryCountMap = new HashMap<>();
        for (List<Vehicle> stateList : separatedByState) {
            for (Vehicle vehicle : stateList) {
                String country = vehicle.getCountry();
                countryCountMap.put(country, countryCountMap.getOrDefault(country, 0) + 1);
            }
        }

        Set<String> uniqueEntries = new HashSet<>();
        SimpleList<String> countryPlusQuantity = new SimpleList<>();
        for (List<Vehicle> stateList : separatedByState) {
            for (Vehicle vehicle : stateList) {
                String country = vehicle.getCountry();
                int count = countryCountMap.get(country);
                String entry = vehicle.getState() + " " + country + " " + count;
                if (uniqueEntries.add(entry)) {
                    countryPlusQuantity.add(entry);
                }
            }
        }
        return countryPlusQuantity;
    }

    private String countByCountry(String country) {
        int count = 0;
        for (Vehicle vehicle : listVehicles) {
            if (vehicle.getCountry().equals(country)) {
                count++;
            }
        }
        return String.valueOf(count);
    }


    private List<List<Vehicle>> separateByState(List<Vehicle> sortedByState) {
        List<List<Vehicle>> separatedByState = new java.util.ArrayList<>();
        List<Vehicle> currentList = new java.util.ArrayList<>();
        String currentState = sortedByState.getFirst().getState();
        for (Vehicle vehicle : sortedByState) {
            if (!vehicle.getState().equals(currentState)) {
                separatedByState.add(currentList);
                currentList = new java.util.ArrayList<>();
                currentState = vehicle.getState();
            }
            currentList.add(vehicle);
        }
        separatedByState.add(currentList);
        return separatedByState;
    }

    @Override
    public List<String> listByState() {
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
    public List<Vehicle> allVehicles() {
        return listVehicles;
    }

    @Override
    public List<String> listByCity() {
        SimpleList<String> existingCities = new SimpleList<>();
        int[] counts = countVehiclesByCity(existingCities);
        int maxCount = findMaxCount(counts);
        return listCitiesWithMaxCount(existingCities, counts, maxCount);
    }

    private int[] countVehiclesByCity(SimpleList<String> existingCities) {
        int[] counts = new int[listVehicles.size()];
        for (Vehicle vehicle : listVehicles) {
            String city = vehicle.getCity();
            int index = existingCities.indexOf(city);
            if (index == -1) {
                existingCities.add(city);
                counts[existingCities.size() - 1] = 1;
            } else {
                counts[index]++;
            }
        }
        return counts;
    }
    private int findMaxCount(int[] counts) {
        int maxCount = 0;
        for (int count : counts) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }
    private List<String> listCitiesWithMaxCount(SimpleList<String> existingCities, int[] counts, int maxCount) {
        SimpleList<String> citiesWithMaxCount = new SimpleList<>();
        for (int i = 0; i < existingCities.size(); i++) {
            if (counts[i] == maxCount) {
                citiesWithMaxCount.add(existingCities.get(i));
                citiesWithMaxCount.add(String.valueOf(maxCount));
            }
        }
        return citiesWithMaxCount;
    }

    @Override
    public List<String> getVehiclesModels(){
        SimpleList<String> models = new SimpleList<>();
        models.add("Ninguno");
        for (Vehicle vehicle : listVehicles){
            models.add(vehicle.getModelVehicle());
        }
        return models;
    }
    @Override
    public List<String> getVehiclesManufacturers(){
        SimpleList<String> manufacturers = new SimpleList<>();
        manufacturers.add("Ninguno");
        for (Vehicle vehicle : listVehicles){
            manufacturers.add(vehicle.getManufacturer());
        }
        return manufacturers;
    }

    @Override
    public String countByModelManufacturerAndElectricRange(String model, String manufacturer, int electricRange) {
        int count = 0;
        for (Vehicle vehicle : listVehicles) {
            boolean matchesModel = model.equals("Ninguno") || vehicle.getModelVehicle().equals(model);
            boolean matchesManufacturer = manufacturer.equals("Ninguno") || vehicle.getManufacturer().equals(manufacturer);
            boolean matchesElectricRange = vehicle.getElectricRange().equals(""+electricRange);

            if (matchesModel && matchesManufacturer && matchesElectricRange) {
                count++;
            }
        }
        return "El numero de vehiculos con modelo " + model + " \nFabricante " + manufacturer + " \nRango electrico " + electricRange + " \nes: " + count;
    }
}
