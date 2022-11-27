package com.railwayservice.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;


@Data
public class CreditCardDto {
    @NotEmpty(message = "This field can't be empty")
    private String cardNumber;

}
