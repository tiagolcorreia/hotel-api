package br.com.cvc.hotel.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.cvc.hotel.external.model.HotelDTO;

@FeignClient(name = "CvcBackendHotel", url = "${external.cvcbackendhotel.uri}")
public interface CvcBackendHotel {

	@GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	List<HotelDTO> getHotelDetails(@PathVariable Long id);

	@GetMapping(value = "/avail/{cityId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	List<HotelDTO> getAvailableHotelsPerCity(@PathVariable Long cityId);
}
