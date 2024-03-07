package com.autobuses.reservacion.application.service;

import com.autobuses.reservacion.application.mapper.BookingMapperMongo;
import com.autobuses.reservacion.application.mapper.BookingMapperPostgres;
import com.autobuses.reservacion.domain.dto.BookingDto;
import com.autobuses.reservacion.domain.entity.Booking;
import com.autobuses.reservacion.domain.repository.BookingMongoRepository;
import com.autobuses.reservacion.domain.repository.BookingSqlRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingSqlService implements BookingService<BookingDto> {

    private final BookingSqlRepository bookingSqlRepository; // Repositorio de MongoDB
    private final BookingMapperPostgres bookingMapperPostgres; // Mapper para las reservas de MongoDB

    public BookingSqlService(BookingSqlRepository bookingSqlRepository, BookingMapperPostgres bookingMapperPostgres) {
        this.bookingSqlRepository = bookingSqlRepository;
        this.bookingMapperPostgres = bookingMapperPostgres;
    }

    @Override
    public List<BookingDto> findAll() {
        List<Booking> bookings = bookingSqlRepository.findAll(); // Obtener todas las reservas desde la base de datos SQL
        return bookings.stream()
                .map(bookingMapperPostgres::toDto) // Mapear las reservas a DTOs
                .collect(Collectors.toList()); // Convertir la lista a List<BookingDto>
    }

    @Override
    public BookingDto findById(Long id) {
        Booking booking = bookingSqlRepository.findById(id).orElse(null); // Buscar una reserva por su ID en la base de datos SQL
        return booking != null ? bookingMapperPostgres.toDto(booking) : null; // Mapear la reserva a un DTO
    }

    @Override
    public BookingDto create(BookingDto bookingDto) {
        Booking booking = bookingMapperPostgres.toEntity(bookingDto); // Convertir el DTO a una entidad
        Booking savedBooking = bookingSqlRepository.save(booking); // Guardar la reserva en la base de datos SQL
        return bookingMapperPostgres.toDto(savedBooking); // Devolver el DTO de la reserva guardada
    }

    @Override
    public BookingDto update(BookingDto bookingDto) {
        Booking booking = bookingMapperPostgres.toEntity(bookingDto); // Convertir el DTO a una entidad
        Booking updatedBooking = bookingSqlRepository.save(booking); // Actualizar la reserva en la base de datos SQL
        return bookingMapperPostgres.toDto(updatedBooking); // Devolver el DTO de la reserva actualizada
    }

    @Override
    public void delete(Long id) {
        bookingSqlRepository.deleteById(id); // Eliminar una reserva por su ID en la base de datos SQL
    }
}
