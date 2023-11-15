package com.turkcell.carservice.controllers;

import com.turkcell.carservice.dto.requests.AddCarToDtoRequest;
import com.turkcell.carservice.dto.responses.AddCarToDtoResponse;
import com.turkcell.carservice.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("CarService")
@RestController
@RequiredArgsConstructor
public class CarServiceController {
    private final CarService carService;

    @PostMapping("addCar")
    @ResponseStatus(HttpStatus.CREATED)
    public AddCarToDtoResponse addCar(@RequestBody AddCarToDtoRequest request) {
        return carService.addCar(request);
    }


}
