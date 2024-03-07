package com.autobuses.reservacion.domain.repository;

import com.autobuses.reservacion.domain.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingSqlRepository extends JpaRepository<Booking, Long> {
}
