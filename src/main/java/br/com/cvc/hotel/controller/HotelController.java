package br.com.cvc.hotel.controller;

import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.hotel.controller.converter.HotelConverter;
import br.com.cvc.hotel.controller.model.HotelSearchRequest;
import br.com.cvc.hotel.controller.model.HotelsDTO;
import br.com.cvc.hotel.model.Hotel;
import br.com.cvc.hotel.service.HotelService;
import br.com.cvc.hotel.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/hotels")
@AllArgsConstructor
@Slf4j
public class HotelController {

	private HotelService hotelService;

	private HotelConverter hotelConverter;
	
	private DateUtil dateUtil;

	@GetMapping(path = "")
	public List<HotelsDTO> search(@Validated HotelSearchRequest request) throws InvalidAttributesException {
		log.debug("init search");
		
		long days = dateUtil.daysBetweenDates(request.getCheckin(), request.getCheckout());
		if  (days <= 0)
			throw new InvalidAttributesException("Invalid number of days");
		List<Hotel> hotels = hotelService.search(request.getCityCode(), request.getCheckin(), request.getCheckout(),
				request.getAmountAdults(), request.getAmountChildren());
		
		return hotelConverter.convert(hotels);
	}

}
