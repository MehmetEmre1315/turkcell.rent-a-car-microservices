package com.turkcell.carservice.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.turkcell.carservice.dto.responses.AddCarToDtoResponse;
import com.turkcell.carservice.entities.Car;
import com.turkcell.carservice.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryUploader {
    private final CarRepository carRepository;
    public Cloudinary cloudinaryUploaderConfig(String cloudName, String apiKey, String apiSecret) {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "ddqdxkqrs",
                "api_key", "656332648762754",
                "api_secret", "_ixEY-PCGzpRv2KVJF_z1xnT8JQ"));
        return cloudinary;
    }

    //"images/Untitled_Diagram.drawio_1.png"
    public AddCarToDtoResponse uploadPhotoToCloudinary(String path, int id) throws IOException {

        File file = new File(path);
        Cloudinary cloud = cloudinaryUploaderConfig("a","a","a");
        Map uploadResult = cloud.uploader().upload(file, ObjectUtils.emptyMap());
        String url = uploadResult.get("url").toString();

        Car car = carRepository.findbyIdQuery(id);
        car.setPicture(url);
        car = carRepository.save(car);
        AddCarToDtoResponse response = AddCarToDtoResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .color(car.getColor())
                .modelYear(car.getModelYear())
                .dailyRentalPrice(car.getDailyRentalPrice())
                .picture(car.getPicture())
                .build();
        return response;
    }
}
