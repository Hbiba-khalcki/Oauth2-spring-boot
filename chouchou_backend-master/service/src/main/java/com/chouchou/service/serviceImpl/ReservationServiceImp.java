package com.chouchou.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chouchou.dao.ReservationRepository;
import com.chouchou.model.Reservation;
import com.chouchou.service.ReservationService;

@Service
public class ReservationServiceImp implements ReservationService{

	@Autowired
	ReservationRepository rep;

	@Override
	public Reservation savOrUpdate(Reservation o) {
		return rep.save(o);
	}

	@Override
	public void delete(Long id) {
		rep.deleteById(id);
	}

	@Override
	public List<Reservation> findAll() {
		return rep.findAll();
	}

	@Override
	public Optional<Reservation> findByID(long id) {
		return rep.findById(id);
	}
}