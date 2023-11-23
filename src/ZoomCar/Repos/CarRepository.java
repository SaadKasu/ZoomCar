package ZoomCar.Repos;

import ZoomCar.Models.Car;
import ZoomCar.Models.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class CarRepository {
    static HashMap<String, Car> carRepository = new HashMap<>();

    public static Car getCarById(String id){
        return carRepository.get(id);
    }
    public static void addCarToRepository(String id, Car car){
        carRepository.put(id, car);
    }
    public static ArrayList<Car> getCarByLocation(Location loc){
        ArrayList<Car> carsAtLocation = new ArrayList<>();
        for (Car car : carRepository.values()){
            if (car.getBasedIn() == loc)
                carsAtLocation.add(car);
        }
        return carsAtLocation;
    }
}
