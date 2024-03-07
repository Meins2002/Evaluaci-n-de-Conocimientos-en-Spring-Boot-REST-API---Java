package com.autobuses.reservacion.application.mapper;

import com.autobuses.reservacion.domain.dto.BookingDto;
import com.autobuses.reservacion.domain.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
@Mapper(componentModel = "spring")
public interface BookingMapperMongo extends IBaseMapper {
    @Mapping(source = "id", target = "id", qualifiedByName = "objectToString")
    Booking toEntity(BookingDto bookingDtodto);

    BookingDto toDto(Booking bookingEntity);

    List<Booking> toEntityList(List<BookingDto> dtoList);

    List<BookingDto> toDtoList(List<Booking> entityList);
    @Named("objectToString")
    default String objectToString(Object obj) {
        return obj.toString();
    }
}
