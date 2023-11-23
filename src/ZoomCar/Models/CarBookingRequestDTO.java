package ZoomCar.Models;

import java.util.Date;

public class CarBookingRequestDTO implements DTO{
    public Car car;
    public Date bookedAt, bookedTill;
    public User bookedByUser;

    public PaymentType modeOfPayment;

    public int rentAmount;

}
