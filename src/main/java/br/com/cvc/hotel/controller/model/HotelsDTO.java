package br.com.cvc.hotel.controller.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelsDTO {
    private Long id;
    private String cityName;
    private List<RoomDTO> rooms;	
}
