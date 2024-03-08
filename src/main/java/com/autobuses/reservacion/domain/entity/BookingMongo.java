package com.autobuses.reservacion.domain.entity;

import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "booking")
@Data
public class BookingMongo {

    @Id
    private String id;
    private String name;
    private String email;
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private Duration duration;




    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        com.autobuses.reservacion.domain.entity.Booking booking = (com.autobuses.reservacion.domain.entity.Booking) o;
        return getId() != null && Objects.equals(getId(), booking.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
