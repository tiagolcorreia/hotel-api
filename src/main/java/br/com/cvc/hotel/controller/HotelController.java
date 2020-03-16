package br.com.cvc.hotel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.hotel.controller.converter.HotelConverter;
import br.com.cvc.hotel.controller.model.HotelSearchRequest;
import br.com.cvc.hotel.controller.model.HotelsDTO;
import br.com.cvc.hotel.model.Hotel;
import br.com.cvc.hotel.service.HotelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/hotels")
@AllArgsConstructor
@Slf4j
public class HotelController {

	private HotelService hotelService;

	private HotelConverter hotelConverter;

	@GetMapping(path = "") public List<HotelsDTO> search(HotelSearchRequest request) {
		log.debug("init search");

		List<Hotel> hotels = hotelService.search(request.getCityCode(), request.getCheckin(), request.getCheckout(),
				request.getAmountAdults(), request.getAmountChildren());
		
		return hotelConverter.convert(hotels);
	}

}
