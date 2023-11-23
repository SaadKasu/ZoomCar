package ZoomCar.Models;

public class AddCarRequestDTO implements DTO{
    public CarType typeOfCar;
    public String modelYear, registrationNumber, licenceNumber, modelName;
    public int seatingCapacity;
    public CarCondition conditionOfCar;
    public CarStatus statusOfCar;
    public Location basedIn;
}
