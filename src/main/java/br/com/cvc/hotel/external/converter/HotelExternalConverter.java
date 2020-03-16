package br.com.cvc.hotel.external.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.cvc.hotel.external.model.HotelDTO;
import br.com.cvc.hotel.external.model.RoomDTO;
import br.com.cvc.hotel.model.Category;
import br.com.cvc.hotel.model.City;
import br.com.cvc.hotel.model.Hotel;
import br.com.cvc.hotel.model.Price;
import br.com.cvc.hotel.model.Room;

@Component
public class HotelExternalConverter {

	public List<Hotel> convert(List<HotelDTO> hotels) {
		return hotels.stream().map(e -> convert(e)).collect(Collectors.toList());
	}

	public Hotel convert(HotelDTO hotel) {
		return Hotel.builder()
				.id(hotel.getId())
				.name(hotel.getName())
				.city(convertCity(hotel))
				.rooms(convertRooms(hotel))
				.build();
	}

	private List<Room> convertRooms(HotelDTO hotel) {
		return hotel.getRooms().stream().map(e -> convertRoom(e)).collect(Collectors.toList());
	}

	private Room convertRoom(RoomDTO e) {
		return Room.builder()
				.id(e.getRoomID())
				.price(Price.builder()
						.adultPerDay(e.getPrice().getAdult())
						.childPerDay(e.getPrice().getChild())
						.build())
				.category(Category.builder().name(e.getCategoryName()).build())
				.build();
	}

	private City convertCity(HotelDTO hotel) {
		return City.builder()
				.id(hotel.getId())
				.name(hotel.getCityName())
				.build();
	}
	
}
