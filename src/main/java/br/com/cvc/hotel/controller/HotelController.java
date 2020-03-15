package br.com.cvc.hotel.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.hotel.controller.model.HotelsDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/hotels")
@AllArgsConstructor
@Slf4j
public class HotelController {

	@GetMapping(path = "")
	public List<HotelsDTO> search(@RequestParam(defaultValue = "7110") Long cityCFode,
			@DateTimeFormat(pattern = "dd/MM/yyyy") Date checkin, @DateTimeFormat(pattern = "dd/MM/yyyy") Date checkout,
			@RequestParam(defaultValue = "2") Integer amountAdults,
			@RequestParam(defaultValue = "0") Integer amountChildren) {
		log.debug("init search");
		return null;
	}

}
