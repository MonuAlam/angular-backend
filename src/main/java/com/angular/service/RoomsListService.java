package com.angular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.angular.entity.RoomsList;
import com.angular.model.dto.RoomsListDto;
import com.angular.model.request.RoomsListRequest;
import com.angular.repository.RoomsListRepository;
import com.angular.util.RoomsListDtoMapper;

@Service
public class RoomsListService {
	
	@Autowired
	private RoomsListRepository repository;

	public RoomsListDto addRoomsList(RoomsListRequest request) {
		
		RoomsList roomsList =toEntity(request);

		return RoomsListDtoMapper.toResponseDto(repository.save(roomsList));
	}

	private RoomsList toEntity(RoomsListRequest request) {
	return	RoomsList.builder()
			.roomNumber(request.getRoomNumber())
			.roomType(request.getRoomType())
			.amenities(request.getAmenities())
			.price(request.getPrice())
			.photo(request.getPhoto())
			.checkInTime(request.getCheckInTime())
			.checkOutTime(request.getCheckOutTime())
			.build();
	}

	
	public List<RoomsListDto> getAllRoomsList() {

		return repository.findAll().stream().map(RoomsListDtoMapper::toResponseDto).toList();
	}

	public RoomsListDto deleteById(String id) {
		
		RoomsList roomsList=repository.findById(id).orElseThrow(()->new RuntimeException("Rooms not find"));
		
		repository.delete(roomsList);
		
		return RoomsListDtoMapper.toResponseDto(roomsList);
	}

	public RoomsListDto getAllRoomsListById(String id) {

		return RoomsListDtoMapper.toResponseDto(repository.findById(id).orElse(null));
	}

	public RoomsListDto updateListDto(String id, RoomsListRequest request) {
		
		RoomsList roomsList=repository.findById(id).orElseThrow(()->new RuntimeException("Room not find"));

		RoomsList updatedRoomsList=updateWithBuilder(request, roomsList);
		repository.save(updatedRoomsList);
		return RoomsListDtoMapper.toResponseDto(updatedRoomsList);
	}
	
	private RoomsList updateWithBuilder(RoomsListRequest request,RoomsList roomsList) {
		
		return roomsList.toBuilder()
				.roomNumber(request.getRoomNumber())
				.roomType(request.getRoomType())
				.price(request.getPrice())
				.amenities(request.getAmenities())
				.photo(request.getPhoto())
				.checkInTime(request.getCheckInTime())
				.checkOutTime(request.getCheckOutTime())
				.build();
	}
}
