package ZoomCar.Controllers;

import ZoomCar.Models.*;
import ZoomCar.Services.ZoomCarService;

import java.util.List;

public class ZoomCarController {

    public int calculateRent(CalculateRentRequestDTO requestDTO){
        CalculateRentResponseDTO responseDTO = ZoomCarService.calculateRent(requestDTO);
        return responseDTO.amount;
    }

    public List<Car> searchCarsBasedOnLocation (SearchCarsRequestDTO requestDTO){
        SearchCarsResponseDTO responseDTO = ZoomCarService.searchCar(requestDTO);
        return responseDTO.carsAtLocation;
    }

    public String bookACar(CarBookingRequestDTO requestDTO){
        CarBookingResponseDTO responseDTO = ZoomCarService.bookCar(requestDTO);
        if (responseDTO.status.equals("Sucess"))
            return "Booking Successful";
        return responseDTO.status;
    }

    public String userLogin(UserRequestDTO requestDTO){
        UserResponseDTO responseDTO = ZoomCarService.userLogin(requestDTO);
        return responseDTO.status;
    }

    public String addCar(AddCarRequestDTO requestDTO){
        AddCarResponseDTO responseDTO = ZoomCarService.addCar(requestDTO);
        return checkResponse(responseDTO);
    }

    public String adduser (AddUserRequestDTO requestDTO){
        AddUserResponseDTO responseDTO = ZoomCarService.addUser(requestDTO);
        return checkResponse(responseDTO);
    }

    public String checkResponse(DTO response){
        if (response == null)
            return "FAILED";
        return "SUCCESS";
    }

}
