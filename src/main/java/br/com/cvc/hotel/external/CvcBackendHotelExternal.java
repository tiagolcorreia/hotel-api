package br.com.cvc.hotel.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.cvc.hotel.external.model.HotelDTO;

@FeignClient(name = "CvcBackendHotelExternal", url = "${external.cvcbackendhotel.uri}")
public interface CvcBackendHotelExternal {

	@GetMapping(value = "/hotels/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	List<HotelDTO> getHotelDetails(@PathVariable Long id);

	@GetMapping(value = "/hotels/avail/{cityId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	List<HotelDTO> getAvailableHotelsPerCity(@PathVariable Long cityId);

}
