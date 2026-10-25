package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation createReservation(Reservation reservation);

    Reservation getReservationById(Long id);

    Reservation updateReservation(Reservation reservation);

    void deleteReservation(Long id);

    List<Reservation> getAllReservations();
}
