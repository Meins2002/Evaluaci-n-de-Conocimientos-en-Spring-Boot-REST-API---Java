package com.autobuses.reservacion.application.service;

import com.autobuses.reservacion.application.mapper.BookingMapperMongo;
import com.autobuses.reservacion.domain.dto.BookingDto;
import com.autobuses.reservacion.domain.entity.Booking;
import com.autobuses.reservacion.domain.repository.BookingMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingMongoService implements BookingService<BookingDto> {
    private final BookingMongoRepository bookingRepository; // Repositorio de MongoDB
    private final BookingMapperMongo bookingMapperMongo; // Mapper para las reservas de MongoDB

    public BookingMongoService(BookingMongoRepository bookingRepository, BookingMapperMongo bookingMapperMongo) {
        this.bookingRepository = bookingRepository;
        this.bookingMapperMongo = bookingMapperMongo;
    }

    @Override
    public List<BookingDto> findAll() {
        List<Booking> bookings = bookingRepository.findAll(); // Obtener todas las reservas desde MongoDB
        return bookings.stream()
                .map(bookingMapperMongo::toDto) // Mapear las reservas a DTOs
                .collect(Collectors.toList()); // Convertir la lista a List<BookingDto>
    }

    @Override
    public BookingDto findById(Long id) {
        Booking booking = bookingRepository.findById(id.toString()).orElse(null); // Buscar una reserva por su ID en MongoDB
        return booking != null ? bookingMapperMongo.toDto(booking) : null; // Mapear la reserva a un DTO
    }

    @Override
    public BookingDto create(BookingDto bookingDto) {
        Booking booking = bookingMapperMongo.toEntity(bookingDto); // Convertir el DTO a una entidad
        Booking savedBooking = bookingRepository.save(booking); // Guardar la reserva en MongoDB
        return bookingMapperMongo.toDto(savedBooking); // Devolver el DTO de la reserva guardada
    }

    @Override
    public BookingDto update(BookingDto bookingDto) {
        Booking booking = bookingMapperMongo.toEntity(bookingDto); // Convertir el DTO a una entidad
        Booking updatedBooking = bookingRepository.save(booking); // Actualizar la reserva en MongoDB
        return bookingMapperMongo.toDto(updatedBooking); // Devolver el DTO de la reserva actualizada
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id.toString()); // Eliminar una reserva por su ID en MongoDB
    }
}