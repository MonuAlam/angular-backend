package com.angular.model.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RoomsListDto {
	private String roomNumber;
	private String roomType ;
	private String amenities;

	private Integer price;
	private String photo;
	private Date checkInTime;
	private Date checkOutTime;
}
