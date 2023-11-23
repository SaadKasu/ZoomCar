package ZoomCar.Stratergies;

import ZoomCar.Models.CalculateRentRequestDTO;
import ZoomCar.Models.CarBooking;

public interface PaymentStratergy {
    public int calculateRent(CalculateRentRequestDTO requestDTO);
}
