package com.turkcell.Rental.Service.services;

import com.turkcell.Rental.Service.dto.requests.AddRentalToDtoRequest;
import com.turkcell.Rental.Service.dto.requests.DeleteRentalCarDto;
import com.turkcell.Rental.Service.dto.requests.IsAvailableToRentRequest;
import com.turkcell.Rental.Service.dto.responses.AddRentalToDtoResponse;
import com.turkcell.Rental.Service.entities.RentalCars;
import com.turkcell.Rental.Service.repositories.RentalServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalManager implements RentalService{
    private final RentalServiceRepository rentalServiceRepository;

    @Override
    public AddRentalToDtoResponse addRental(AddRentalToDtoRequest request) {
        RentalCars rentalCars = RentalCars.builder()
                .carId(request.getCarId())
                .isAvailable(true)
                .build();
        rentalCars =rentalServiceRepository.save(rentalCars);

        AddRentalToDtoResponse response = AddRentalToDtoResponse.builder()
                .id(rentalCars.getId())
                .carId(rentalCars.getCarId())
                .isAvailable(rentalCars.isAvailable())
                .build();
        return response;
    }

    @Override
    public boolean isAvailableToRent(IsAvailableToRentRequest request) {
        return rentalServiceRepository.isAvailableByCarId(request.getCarId());
    }

    @Override
    public void deleteRentalCar(DeleteRentalCarDto request) {
        RentalCars rentalCars = rentalServiceRepository.findByCarId(request.getCarId());
        rentalServiceRepository.delete(rentalCars);
    }

    @Override
    public AddRentalToDtoResponse rentCar(IsAvailableToRentRequest request) {
        RentalCars rentalCars = rentalServiceRepository.findByCarId(request.getCarId());
        rentalCars.setAvailable(false);
        rentalServiceRepository.save(rentalCars);
        AddRentalToDtoResponse response = AddRentalToDtoResponse.builder()
                .id(rentalCars.getId())
                .carId(rentalCars.getCarId())
                .isAvailable(rentalCars.isAvailable())
                .build();
        return response;
    }

    @Override
    public AddRentalToDtoResponse returnCar(IsAvailableToRentRequest request) {
        RentalCars rentalCars = rentalServiceRepository.findByCarId(request.getCarId());
        rentalCars.setAvailable(true);
        rentalServiceRepository.save(rentalCars);
        AddRentalToDtoResponse response = AddRentalToDtoResponse.builder()
                .id(rentalCars.getId())
                .carId(rentalCars.getCarId())
                .isAvailable(rentalCars.isAvailable())
                .build();
        return response;
    }


}
