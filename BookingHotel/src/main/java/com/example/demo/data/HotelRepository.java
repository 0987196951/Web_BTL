package com.example.demo.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.Hotel;

public interface HotelRepository extends PagingAndSortingRepository<Hotel, Long> {

}
