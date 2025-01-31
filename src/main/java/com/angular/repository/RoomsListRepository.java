package com.angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angular.entity.RoomsList;

public interface RoomsListRepository extends JpaRepository<RoomsList, String> {

}
