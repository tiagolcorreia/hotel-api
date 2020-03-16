package br.com.cvc.hotel.controller.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.cvc.hotel.controller.model.HotelsDTO;
import br.com.cvc.hotel.controller.model.PriceDTO;
import br.com.cvc.hotel.controller.model.RoomDTO;
import br.com.cvc.hotel.model.Hotel;
import br.com.cvc.hotel.model.Price;
import br.com.cvc.hotel.model.Room;

@Component
public class HotelConverter {

	public List<HotelsDTO> convert(List<Hotel> hotels) {
		return hotels.stream().map(e -> convert(e)).collect(Collectors.toList());
	}

	public HotelsDTO convert(Hotel hotel) {
		return HotelsDTO.builder()
				.id(hotel.getId())
				.cityName(hotel.getCity().getName())
				.rooms(convertRooms(hotel))
				.build();
	}

	private List<RoomDTO> convertRooms(Hotel hotel) {
		List<RoomDTO> roomsDTO = new ArrayList<>();
		for (int i = 0; i < hotel.getRooms().size(); i++) {
			Room room = hotel.getRooms().get(i);
			roomsDTO.add(RoomDTO.builder()
					.roomID(room.getId())
					.categoryName(room.getCategory().getName())
					.totalPrice(room.getPrice().getTotal())
					.priceDetail(convertPrice(room.getPrice()))
					.build());
		}
		return roomsDTO;
	}

	private PriceDTO convertPrice(Price price) {
		return PriceDTO.builder()
				.pricePerDayAdult(price.getAdultsPerDay())
				.pricePerDayChild(price.getChildrenPerDay())
				.build();
	}

}
