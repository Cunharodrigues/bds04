package com.devsuperior.bds04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;

public interface CityRepository extends JpaRepository<City, Long> {

	Event save(Event entity);
	
}
