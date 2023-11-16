package com.turkcell.carservice.services;

import com.turkcell.carservice.dto.requests.AddCarToDtoRequest;
import com.turkcell.carservice.dto.requests.GetByIdCarDtoRequest;
import com.turkcell.carservice.dto.responses.AddCarToDtoResponse;
import com.turkcell.carservice.dto.responses.GetByIdCarDtoResponse;

import java.util.List;

public interface CarService {
    AddCarToDtoResponse addCar(AddCarToDtoRequest request);
    GetByIdCarDtoResponse getById(GetByIdCarDtoRequest request);
    List<GetByIdCarDtoResponse> getAll();
    void deleteById(GetByIdCarDtoRequest request);
    AddCarToDtoResponse update(AddCarToDtoRequest request);

}
