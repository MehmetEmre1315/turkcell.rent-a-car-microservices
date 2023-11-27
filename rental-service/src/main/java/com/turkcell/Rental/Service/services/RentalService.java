package com.turkcell.Rental.Service.services;

import com.turkcell.Rental.Service.dto.requests.*;
import com.turkcell.Rental.Service.dto.responses.AddRentalToDtoResponse;
import com.turkcell.Rental.Service.dto.responses.GetByIdCarFromCarServiceResponse;
import com.turkcell.Rental.Service.dto.responses.RentACarDtoResponse;

public interface RentalService {

    AddRentalToDtoResponse addRental(AddRentalToDtoRequest request);
    boolean isAvailableToRent(IsAvailableToRentRequest request);
    void deleteRentalCar(DeleteRentalCarDto request);

    RentACarDtoResponse rentCar(RentACarDtoRequest request);
    AddRentalToDtoResponse returnCar(IsAvailableToRentRequest request);


}
