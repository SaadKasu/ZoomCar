package ZoomCar.Stratergies;

import ZoomCar.Models.CalculateRentRequestDTO;
import ZoomCar.Models.CarBooking;

import java.util.Date;

public class TimeBasedStratergy implements PaymentStratergy{
    @Override
    public int calculateRent(CalculateRentRequestDTO requestDTO) {
        return  requestDTO.bookedTill.compareTo(requestDTO.bookedAt) * 10 ;
    }
}
