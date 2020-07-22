package com.kuryetaxi.kuryetaxibackend.service;

import java.util.List;
import com.kuryetaxi.kuryetaxibackend.entity.Restoran;


public interface RestoranService {
	
	public List<Restoran> findAllRestoran();
	public Restoran findRestoran(String username);
	public Restoran saveOrUpdateRestoran(Restoran restoran);
	public int deleteRestoran(int id);

}
