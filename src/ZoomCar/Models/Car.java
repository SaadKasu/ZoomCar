package ZoomCar.Models;

import java.util.Date;

public class Car extends BaseClass{
    private CarType typeOfCar;
    private String modelYear, registrationNumber, licenceNumber, modelName;
    private int seatingCapacity;
    private CarCondition conditionOfCar;
    private CarStatus statusOfCar;

    private Location basedIn;

    private Car(){}

    public Location getBasedIn(){
        return this.basedIn;
    }

    public String getId(){
        return this.id;
    }
    public CarStatus getStatusOfCar(){
        return this.statusOfCar;
    }
    public CarType getTypeOfCar(){
        return this.typeOfCar;
    }

    public static Car buildCar(CarBuilder carBuilder){

        Car newCar = new Car();
        newCar.typeOfCar = carBuilder.typeOfCar;
        newCar.conditionOfCar = carBuilder.conditionOfCar;
        newCar.licenceNumber = carBuilder.licenceNumber;
        newCar.modelName = carBuilder.modelName;
        newCar.registrationNumber = carBuilder.registrationNumber;
        newCar.modelYear = carBuilder.modelYear;
        newCar.seatingCapacity = carBuilder.seatingCapacity;
        newCar.statusOfCar = carBuilder.statusOfCar;
        newCar.basedIn = carBuilder.basedIn;
        newCar.id = carBuilder.id;
        return newCar;
    }

    public static class CarBuilder{
        CarType typeOfCar;
        String modelYear, registrationNumber, licenceNumber, modelName, id;
        int seatingCapacity;
        CarCondition conditionOfCar;
        CarStatus statusOfCar;

        Location basedIn;

        public void setTypeOfCar(CarType carType){
            this.typeOfCar = carType;
        }
        public void setModelYear(String modelYear){
            this.modelYear = modelYear;
        }
        public void setModelName(String modelName){
            this.modelName = modelName;
        }
        public void setRegistrationNumber(String registrationNumber){
            this.registrationNumber = registrationNumber;
        }
        public void setLicenceNumber(String licenceNumber){
            this.licenceNumber = licenceNumber;
        }
        public void setSeatingCapacity(int seatingCapacity){
            this.seatingCapacity = seatingCapacity;
        }
        public void setConditionOfCar(CarCondition conditionOfCar){
            this.conditionOfCar = conditionOfCar;
        }
        public void setStatusOfCar(CarStatus statusOfCar){
            this.statusOfCar = statusOfCar;
        }

        public void setBasedIn(Location basedIn){
            this.basedIn = basedIn;
        }

        public void setID(){
            this.id = this.registrationNumber;
        }
        public String getId(){
            return this.id;
        }

    }

}
