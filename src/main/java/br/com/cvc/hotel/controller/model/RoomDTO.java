package br.com.cvc.hotel.controller.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RoomDTO {
	private Long roomID;
	private String categoryName;
	private BigDecimal totalPrice;
	private PriceDTO priceDetail;
}
