package ZoomCar.Repos;

import ZoomCar.Models.CarBooking;

import java.util.ArrayList;

public class CarBookingRepositories {
    static ArrayList<CarBooking> carBookings = new ArrayList<>();
    public static void addCarBooking(CarBooking carBooking){
        carBookings.add(carBooking);
    }
    public ArrayList<CarBooking> getListOfBookings(){
        return carBookings;
    }
}
