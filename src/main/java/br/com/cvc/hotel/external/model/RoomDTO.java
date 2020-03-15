package br.com.cvc.hotel.external.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDTO {
    private Long roomID;
    private String categoryName;
    private PriceDTO price;
}
