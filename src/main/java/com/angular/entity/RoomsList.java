package com.angular.entity;

import java.awt.datatransfer.Transferable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class RoomsList {
	
	@Id
	private String roomNumber;
	private String roomType ;
	private String amenities;
	private Integer price;
	private String photo;
	private Date checkInTime;
	private Date checkOutTime;
}
