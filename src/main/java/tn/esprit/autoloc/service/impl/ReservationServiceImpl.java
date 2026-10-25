package tn.esprit.autoloc.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.IReservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final IReservation reservationRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation introuvable avec l'id : " + id));
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        if (reservation.getIdReservation() == null || !reservationRepository.existsById(reservation.getIdReservation())) {
            throw new EntityNotFoundException("Reservation introuvable avec l'id : " + reservation.getIdReservation());
        }
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new EntityNotFoundException("Reservation introuvable avec l'id : " + id);
        }
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
