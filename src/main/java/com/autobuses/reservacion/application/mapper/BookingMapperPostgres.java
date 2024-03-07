package com.autobuses.reservacion.application.mapper;

import com.autobuses.reservacion.domain.dto.BookingDto;
import com.autobuses.reservacion.domain.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapperPostgres extends IBaseMapper{
    @Mapping(source = "id", target = "id", qualifiedByName = "objectToInteger")
    Booking toEntity(BookingDto dto);

    BookingDto toDto(Booking entity);

    List<Booking> toEntityList(List<BookingDto> dtoList);

    List<BookingDto> toDtoList(List<Booking> entityList);
    @Named("objectToInteger")
    default Integer objectToInteger(Object obj){
        return Integer.valueOf(obj.toString());
    }


}
