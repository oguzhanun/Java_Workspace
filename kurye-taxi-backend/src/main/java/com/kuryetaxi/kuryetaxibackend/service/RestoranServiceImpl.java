package com.kuryetaxi.kuryetaxibackend.service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuryetaxi.kuryetaxibackend.DAO.RestoranDAO;
import com.kuryetaxi.kuryetaxibackend.entity.Restoran;



@Service
public class RestoranServiceImpl implements RestoranService {

	
	
	@Autowired
	private RestoranDAO restoranDAO;
	
	
	
	@Override
	@Transactional
	public List<Restoran> findAllRestoran() {
		
		List<Restoran> restoranlar = restoranDAO.findAll();
		
		return restoranlar;
	}

	@Override
	@Transactional
	public Restoran findRestoran(String username) {
		
		Restoran restoran = restoranDAO.findByUsername(username);
		
		return restoran;
	}

	@Override
	@Transactional
	public Restoran saveOrUpdateRestoran(Restoran restoran) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public int deleteRestoran(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
