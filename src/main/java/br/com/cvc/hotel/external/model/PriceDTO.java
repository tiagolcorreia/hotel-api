package br.com.cvc.hotel.external.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceDTO {
	private BigDecimal adult;
	private BigDecimal child;
}
