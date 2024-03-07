package com.autobuses.reservacion.domain.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDto {
    private Object id;
    private String name;
    private String email;
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private Duration duration;
}