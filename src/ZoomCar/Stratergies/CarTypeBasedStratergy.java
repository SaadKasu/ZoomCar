package ZoomCar.Stratergies;

import ZoomCar.Models.CalculateRentRequestDTO;
import ZoomCar.Models.CarBooking;
import ZoomCar.Models.CarType;

public class CarTypeBasedStratergy implements PaymentStratergy{
    @Override
    public int calculateRent(CalculateRentRequestDTO requestDTO) {
        if (requestDTO.car.getTypeOfCar() == CarType.HATCHBACK)
            return 100;
        else if (requestDTO.car.getTypeOfCar() == CarType.SEDAN)
            return 200;
        else if (requestDTO.car.getTypeOfCar() == CarType.SUV)
            return 300;
        return 400;
    }
}
