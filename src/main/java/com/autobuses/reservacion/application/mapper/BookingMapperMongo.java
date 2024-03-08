package com.autobuses.reservacion.application.mapper;

import com.autobuses.reservacion.domain.dto.BookingDto;
import com.autobuses.reservacion.domain.entity.Booking;
import com.autobuses.reservacion.domain.entity.BookingMongo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
@Mapper(componentModel = "spring")
public interface BookingMapperMongo extends IBaseMapper {
    @Mapping(source = "id", target = "id", qualifiedByName = "objectToString")
    BookingMongo toEntity(BookingDto bookingDto);

    BookingDto toDto(BookingMongo bookingEntity);

    List<BookingMongo> toEntityList(List<BookingDto> dtoList);

    List<BookingDto> toDtoList(List<BookingMongo> entityList);

    @Named("objectToString")
    default String objectToString(Object obj) {
        return obj.toString();
    }
}
