package com.autobuses.reservacion.domain.repository;

import com.autobuses.reservacion.domain.entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookingMongoRepository extends MongoRepository<Booking, String> {

}
