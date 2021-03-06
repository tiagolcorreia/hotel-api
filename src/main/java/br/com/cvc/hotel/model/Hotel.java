package br.com.cvc.hotel.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hotel {
	private Long id;
	private String name;
    private City city;
    private List<Room> rooms;
}
