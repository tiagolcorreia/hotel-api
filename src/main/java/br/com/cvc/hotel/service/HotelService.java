package br.com.cvc.hotel.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.cvc.hotel.external.CvcBackendHotelExternal;
import br.com.cvc.hotel.external.converter.HotelExternalConverter;
import br.com.cvc.hotel.external.model.HotelDTO;
import br.com.cvc.hotel.model.Hotel;
import br.com.cvc.hotel.model.Price;
import br.com.cvc.hotel.model.Room;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class HotelService {
	
	private CvcBackendHotelExternal backendHotel;
	private HotelExternalConverter hotelConverter;
	private final BigDecimal COMMISION = BigDecimal.valueOf(0.7);
	
	@Cacheable(value = "hotels")
	public List<Hotel> search(Long cityId, Date checkin, Date checkout, Integer amountAdults, Integer amountChildren) {
		List<HotelDTO> hotelsDTO = backendHotel.getAvailableHotelsPerCity(cityId);
		List<Hotel> hotels = hotelConverter.convert(hotelsDTO);
		long days = daysBetweenDates(checkin, checkout);
		final BigDecimal adultsFactor = BigDecimal.valueOf(days * amountAdults);
		final BigDecimal childrenFactor = BigDecimal.valueOf(days * amountChildren);
		for (final Hotel hotel : hotels) {
			for (final Room room : hotel.getRooms()) {
				final Price price = room.getPrice();
				final BigDecimal adultsPerDay = price.getAdultPerDay().multiply(adultsFactor).divide(COMMISION, RoundingMode.HALF_UP);
				final BigDecimal childrenPerDay = price.getChildPerDay().multiply(childrenFactor).divide(COMMISION, RoundingMode.HALF_UP);
				price.setAdultsPerDay(adultsPerDay);
				price.setChildrenPerDay(childrenPerDay);
				price.setTotal(adultsPerDay.add(childrenPerDay));
			}
		}
		return hotels;
	}
	
	private long daysBetweenDates(Date checkin, Date checkout) {
	    long diff = checkout.getTime() - checkin.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
}
