package ZoomCar.Repos;

import ZoomCar.Models.CarBooking;

import java.util.ArrayList;

public class CarBookingRepository {
    public static ArrayList<CarBooking> carBookings = new ArrayList<>();
    public static void addCarBooking(CarBooking carBooking){
        carBookings.add(carBooking);
    }
}
