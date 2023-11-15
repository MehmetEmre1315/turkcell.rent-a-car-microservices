package com.turkcell.carservice.services;

import com.turkcell.carservice.dto.requests.AddCarToDtoRequest;
import com.turkcell.carservice.dto.responses.AddCarToDtoResponse;

public interface CarService {
    AddCarToDtoResponse addCar(AddCarToDtoRequest Request);

}
