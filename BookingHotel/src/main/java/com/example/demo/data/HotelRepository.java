package com.example.demo.data;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.Hotel;

public interface HotelRepository extends PagingAndSortingRepository<Hotel, Long> {

}
