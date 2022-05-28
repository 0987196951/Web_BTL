package com.example.demo.data;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Booking;
@Repository
public interface BookingRepository extends PagingAndSortingRepository<Booking, Long> {
}
