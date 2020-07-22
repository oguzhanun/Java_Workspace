package com.kuryetaxi.kuryetaxibackend.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kuryetaxi.kuryetaxibackend.entity.Restoran;



public interface RestoranDAO extends JpaRepository<Restoran, Integer> {

	public Restoran findByUsername(String username);

	

}
