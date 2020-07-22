package com.kuryetaxi.kuryetaxibackend.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.kuryetaxi.kuryetaxibackend.entity.Restoran;



@Repository
public abstract class RestoranDAOImpl implements RestoranDAO {

	
	
	private EntityManager entityManager;
	
	
	
	@Override
	public Restoran findByUsername(String username){
		
		Query query = entityManager.createQuery("from restoran where username=:username");
		query.setParameter("username", username);

		Restoran restoran = null;
		
		if(query.getResultList() != null) {
			restoran = (Restoran) query.getResultList().get(0);
		}
		
		return restoran;
	}
	
}
