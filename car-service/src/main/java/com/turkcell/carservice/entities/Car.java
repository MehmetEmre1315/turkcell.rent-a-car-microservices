package com.turkcell.carservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(value = "Cars")
public class Car {
    @Id
    private int id;
    private String brand;
    private String model;
    private String color;
    private int modelYear;
    private float dailyRentalPrice;
    private String picture;
    private String _class;


}
