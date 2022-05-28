package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.BookedRoom;

public interface BookedRoomRepository extends CrudRepository<BookedRoom	, Long> {

}
