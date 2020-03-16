package br.com.cvc.hotel.controller.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class HotelSearchRequest {
	private long cityCode = 7110;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date checkin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date checkout;
	private int amountAdults = 2;
	private int amountChildren = 0;
}
