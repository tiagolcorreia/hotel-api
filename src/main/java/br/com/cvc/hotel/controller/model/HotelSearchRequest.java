package br.com.cvc.hotel.controller.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class HotelSearchRequest {

    @ApiModelProperty(value = "City Code", required = true, example = "7110")
    @NotNull
	private Long cityCode = 7110L;
    @ApiModelProperty(value = "Check-in Date", required = true, example = "01/01/2020")
    @NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date checkin;
    @ApiModelProperty(value = "Check-out Date", required = true, example = "05/01/2020")
    @NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date checkout;
    @ApiModelProperty(value = "Amount Adults", required = true, example = "2")
    @NotNull
    @Max(15)
    @Min(1)
	private Integer amountAdults = 2;
    @ApiModelProperty(value = "Amount Children", required = true, example = "0")
    @NotNull
    @Max(15)
    @Min(0)
	private Integer amountChildren = 0;
}
