package ZoomCar.ClientController;

import ZoomCar.Controllers.ZoomCarController;
import ZoomCar.Models.*;
import ZoomCar.Repos.CarRepository;
import ZoomCar.Repos.UserRepository;

import java.util.Date;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ZoomCarController zoomCar = new ZoomCarController();
        Scanner inp = new Scanner(System.in);
        int testCases = Integer.parseInt(inp.nextLine());
        while(testCases-- > 0){
            String inputTestCase = inp.nextLine();
            if (inputTestCase.substring(0,6).equals("ADDCAR")){
                AddCarRequestDTO newCar = new AddCarRequestDTO();
                newCar.conditionOfCar = CarCondition.FAIR;
                newCar.basedIn = Location.BANGALORE;
                newCar.statusOfCar = CarStatus.FREE;
                newCar.typeOfCar = CarType.HATCHBACK;
                newCar.licenceNumber = "KA-02-HA-2031";
                newCar.modelName = "Santro";
                newCar.modelYear = "2018";
                newCar.seatingCapacity = 5;
                newCar.registrationNumber = "HNA-1242-BN-355";
                System.out.println(zoomCar.addCar(newCar));


            }
            else if (inputTestCase.substring(0,6).equals("ADDUSR")){
                AddUserRequestDTO newUser = new AddUserRequestDTO();
                newUser.basedInCity = Location.BANGALORE;
                newUser.name = "Saad";
                newUser.password = "123";
                System.out.println(zoomCar.adduser(newUser));
            }
            else if (inputTestCase.substring(0,6).equals("SRHCAR")){
                SearchCarsRequestDTO requestDTO = new SearchCarsRequestDTO();
                requestDTO.location = Location.BANGALORE;
                for (Car car : zoomCar.searchCarsBasedOnLocation(requestDTO))
                    System.out.println("Car Type - "+car.getTypeOfCar() + " Car Id"+car.getId());
            }
            else if (inputTestCase.substring(0,6).equals("LGNUSR")){
                    UserRequestDTO requestDTO = new UserRequestDTO();
                    requestDTO.userName = "Saad";
                    requestDTO.password = "MN";
                System.out.println(zoomCar.userLogin(requestDTO));
            }
            else if (inputTestCase.substring(0,6).equals("CLRENT")){
                CalculateRentRequestDTO requestDTO = new CalculateRentRequestDTO();
                requestDTO.bookedAt = new Date();
                requestDTO.bookedTill = new Date();
                requestDTO.car = CarRepository.getCarById("HNA-1242-BN-355");
                System.out.println(zoomCar.calculateRent(requestDTO));
            }
            else if (inputTestCase.substring(0,6).equals("BOKCAR")){
                CarBookingRequestDTO requestDTO = new CarBookingRequestDTO();
                requestDTO.modeOfPayment = PaymentType.CASH;
                requestDTO.bookedAt = new Date();
                requestDTO.car = CarRepository.getCarById("HNA-1242-BN-355");
                requestDTO.bookedTill = new Date();
                requestDTO.bookedByUser = UserRepository.getUserByName("Saad");
                CalculateRentRequestDTO requestDTO2 = new CalculateRentRequestDTO();
                requestDTO2.bookedAt = new Date();
                requestDTO2.bookedTill = new Date();
                requestDTO2.car = CarRepository.getCarById("HNA-1242-BN-355");
                requestDTO.rentAmount = zoomCar.calculateRent(requestDTO2);
                System.out.println(zoomCar.bookACar(requestDTO));
            }
        }
    }
}
