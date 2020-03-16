package br.com.cvc.hotel.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Room {
	private Long id;
	private Price price;
	private Category category;
}
