package com.angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.model.dto.RoomsListDto;
import com.angular.model.request.RoomsListRequest;
import com.angular.service.RoomsListService;
@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomsListController {
	
	@Autowired
	private RoomsListService service;

	@PostMapping
	public RoomsListDto addRoomsList(@RequestBody RoomsListRequest request) {
		return service.addRoomsList(request);
	}
	
	@GetMapping
	public List<RoomsListDto> getAllRoomsList() {
		return service.getAllRoomsList();
	}
	
	@GetMapping("/{id}")
	public RoomsListDto getAllRoomsListById(@PathVariable String id) {
		return service.getAllRoomsListById(id);
	}
	
	@DeleteMapping("/{id}")
	public RoomsListDto deleteById(@PathVariable String id) {
		return service.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public RoomsListDto updateListDto(@PathVariable String id,@RequestBody RoomsListRequest request) {
		return service.updateListDto(id,request);
	}
}
