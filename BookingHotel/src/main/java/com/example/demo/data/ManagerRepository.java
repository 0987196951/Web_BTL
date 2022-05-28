package com.example.demo.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Manager;

public interface ManagerRepository extends CrudRepository<Manager, Long>{

}
