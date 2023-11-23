package ZoomCar.Services;

import ZoomCar.Models.*;
import ZoomCar.Repos.CarBookingRepository;
import ZoomCar.Repos.CarRepository;
import ZoomCar.Repos.TransactionRepositories;
import ZoomCar.Repos.UserRepository;
import ZoomCar.Stratergies.CarTypeBasedStratergy;
import ZoomCar.Stratergies.PaymentStratergy;

import java.util.ArrayList;
import java.util.Date;

public class ZoomCarService {
    public static AddCarResponseDTO addCar(AddCarRequestDTO requestDTO){

        Car.CarBuilder carBuilder = new Car.CarBuilder();
        carBuilder.setConditionOfCar(requestDTO.conditionOfCar);
        carBuilder.setStatusOfCar(requestDTO.statusOfCar);
        carBuilder.setTypeOfCar(requestDTO.typeOfCar);
        carBuilder.setBasedIn(requestDTO.basedIn);
        carBuilder.setModelName(requestDTO.modelName);
        carBuilder.setLicenceNumber(requestDTO.licenceNumber);
        carBuilder.setSeatingCapacity(requestDTO.seatingCapacity);
        carBuilder.setRegistrationNumber(requestDTO.registrationNumber);
        carBuilder.setID();
        if (CarRepository.getCarById(carBuilder.getId()) != null)
            return null;
        Car car = Car.buildCar(carBuilder);
        CarRepository.addCarToRepository(car.getId(),car);

        AddCarResponseDTO carResponseDTO = new AddCarResponseDTO();
        carResponseDTO.car = car;
        return carResponseDTO;
    }

    public static AddUserResponseDTO addUser(AddUserRequestDTO requestDTO){
        if (UserRepository.getUserByName(requestDTO.name) != null)
            return null;
        User user = new User(requestDTO.name, requestDTO.password, requestDTO.basedInCity);
        UserRepository.addUser(requestDTO.name, user);
        AddUserResponseDTO responseDTO = new AddUserResponseDTO();
        responseDTO.user = user;
        return responseDTO;
    }

    public static SearchCarsResponseDTO searchCar(SearchCarsRequestDTO requestDTO){
        ArrayList<Car> carsAtLocation = CarRepository.getCarByLocation(requestDTO.location);
        SearchCarsResponseDTO responseDTO = new SearchCarsResponseDTO();
        responseDTO.carsAtLocation = carsAtLocation;
        return responseDTO;
    }

    public static UserResponseDTO userLogin(UserRequestDTO requestDTO){
        String userName = requestDTO.userName;
        User user = UserRepository.getUserByName(userName);
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.user = user;
        if (user == null)
            responseDTO.status = "User Does not Exist";
        else if (!user.getPassword().equals(requestDTO.password))
            responseDTO.status = "Incorrect Password";
        else
            responseDTO.status = "Successful";
        return responseDTO;
    }

    public static CarBookingResponseDTO bookCar(CarBookingRequestDTO requestDTO){
        CarBookingResponseDTO responseDTO = new CarBookingResponseDTO();
        Car car = requestDTO.car;
        Car carInRepo = CarRepository.getCarById(car.getId());
        if (carInRepo == null){
            responseDTO.status = "Car does not exist";
            return responseDTO;
        }
        else if (carInRepo.getStatusOfCar() != CarStatus.FREE){
            responseDTO.status = "Car is Unavailable";
            return responseDTO;
        }
        CarBooking bookCar = new CarBooking(car, requestDTO.bookedByUser, requestDTO.bookedAt, requestDTO.bookedTill);

        Transaction transaction;
        if (requestDTO.modeOfPayment == PaymentType.CASH)
            transaction = new CashTransaction(new Date(), requestDTO.rentAmount, bookCar);
        else {
            transaction = new PhonePeTransaction(new Date(), requestDTO.rentAmount, bookCar);
        }
        responseDTO.transaction = transaction;
        responseDTO.status = "Booking Completed";
        TransactionRepositories.addTransaction(transaction);
        CarBookingRepository.addCarBooking(bookCar);
        return responseDTO;
    }

    public static CalculateRentResponseDTO calculateRent(CalculateRentRequestDTO requestDTO){
        PaymentStratergy paymentStratergy = new CarTypeBasedStratergy();
        CalculateRentResponseDTO responseDTO = new CalculateRentResponseDTO();
        responseDTO.amount = paymentStratergy.calculateRent(requestDTO);
        return responseDTO;
    }
}
