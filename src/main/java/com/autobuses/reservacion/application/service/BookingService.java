package com.autobuses.reservacion.application.service;

import com.autobuses.reservacion.domain.dto.BookingDto;

import java.util.List;

public interface BookingService<B> {
    List<BookingDto> findAll();

    BookingDto findById(Long id);

    BookingDto create(BookingDto bookingDto);

    BookingDto update(BookingDto bookingDto);

    void delete(Long id);

}
