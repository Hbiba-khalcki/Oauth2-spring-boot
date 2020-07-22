package com.chouchou.service;

import java.util.List;
import java.util.Optional;

import com.chouchou.model.Reservation;

public interface ReservationService {
	public Reservation savOrUpdate(Reservation o);
	public void delete(Long id);
	public List<Reservation> findAll();
	public Optional<Reservation> findByID(long id);
}
