package ZoomCar.Models;

import java.util.List;

public class SearchCarsResponseDTO implements DTO{
    public List<Car> carsAtLocation;
    public Location location;
}
