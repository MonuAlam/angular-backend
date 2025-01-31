package com.angular.util;

import com.angular.entity.RoomsList;
import com.angular.model.dto.RoomsListDto;

public class RoomsListDtoMapper {
	
public	static RoomsListDto toResponseDto(RoomsList roomsList) {
		
		return RoomsListDto.builder()
				.roomNumber(roomsList.getRoomNumber())
				.roomType(roomsList.getRoomType())
				.photo(roomsList.getPhoto())
				.price(roomsList.getPrice())
				.amenities(roomsList.getAmenities())
				.checkInTime(roomsList.getCheckInTime())
				.checkOutTime(roomsList.getCheckOutTime())
				.build();
	}

}
