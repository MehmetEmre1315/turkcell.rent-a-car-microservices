package com.turkcell.carservice.controllers;

import com.cloudinary.Cloudinary;
import com.turkcell.carservice.dto.requests.AddCarToDtoRequest;
import com.turkcell.carservice.dto.requests.GetByIdCarDtoRequest;
import com.turkcell.carservice.dto.requests.ImageDtoRequest;
import com.turkcell.carservice.dto.responses.AddCarToDtoResponse;
import com.turkcell.carservice.dto.responses.GetByIdCarDtoResponse;
import com.turkcell.carservice.services.CarService;
import com.turkcell.carservice.services.CloudinaryUploader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("CarService")
@RestController
@RequiredArgsConstructor
public class CarServiceController {
    private final CarService carService;
    private final CloudinaryUploader cloudinaryUploader;

    @PostMapping("addCar")
    @ResponseStatus(HttpStatus.CREATED)
    public AddCarToDtoResponse addCar(@RequestBody AddCarToDtoRequest request) {
        return carService.addCar(request);
    }

    @PostMapping("getByIdCar")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdCarDtoResponse getByIdCar(@RequestBody GetByIdCarDtoRequest request) {return carService.getById(request);}

    @GetMapping("getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetByIdCarDtoResponse> getAll() {return carService.getAll();}

    @DeleteMapping("deleteById")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestBody GetByIdCarDtoRequest request) {carService.deleteById(request);}

    @PutMapping("updateCar")
    @ResponseStatus(HttpStatus.OK)
    public AddCarToDtoResponse updateCar(@RequestBody AddCarToDtoRequest request) throws IOException {return carService.update(request);}

    @PostMapping("uploadImage")
    public AddCarToDtoResponse uploadImage(@RequestParam("id") int id, @RequestParam("path") String path) throws IOException {

        return cloudinaryUploader.uploadPhotoToCloudinary(path, id);
    }
}
