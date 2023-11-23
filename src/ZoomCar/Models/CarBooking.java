package ZoomCar.Models;

import java.util.Date;

public class CarBooking extends BaseClass{
    Car bookedCar;
    User bookedByUser;
    Date bookedAt, bookedTill;

    public CarBooking (Car bookedCar, User bookedByUser, Date bookedAt, Date bookedTill){
        this.bookedAt = bookedAt;
        this.bookedByUser = bookedByUser;
        this.bookedCar = bookedCar;
    }
}
