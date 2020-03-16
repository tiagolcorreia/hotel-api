package br.com.cvc.hotel.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {
	private BigDecimal total;
	private BigDecimal adultPerDay;
	private BigDecimal childPerDay;
	private BigDecimal adultsPerDay;
	private BigDecimal childrenPerDay;
}
