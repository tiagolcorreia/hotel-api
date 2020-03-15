package br.com.cvc.hotel.controller.model;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PriceDTO {
    private BigDecimal pricePerDayAdult;
    private BigDecimal pricePerDayChild;
}