package br.com.cvc.hotel.external.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelDTO {

    private Long id;
    private String name;
    private Long cityCode;
    private String cityName;
    private List<RoomDTO> rooms;
}
