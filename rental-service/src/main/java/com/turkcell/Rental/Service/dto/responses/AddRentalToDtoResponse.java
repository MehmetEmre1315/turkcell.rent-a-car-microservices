package com.turkcell.Rental.Service.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddRentalToDtoResponse {
    private short id;
    private int carId;
    private boolean isAvailable;
}
