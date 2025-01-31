package com.angular.model.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoomsListRequest {

	private String roomNumber;
	private String roomType ;
	private String amenities;

	private Integer price;
	private String photo;
	private Date checkInTime;
	private Date checkOutTime;
}
