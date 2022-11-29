package com.railwayservice.mappers;

import com.railwayservice.dto.DepartureDto;
import com.railwayservice.model.entity.Departure;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DepartureMapper {
    @Mappings({
            @Mapping(source = "departure.departureCity.name",target = "departureCity"),
            @Mapping(source = "departure.arrivalCity.name",target = "arrivalCity"),
            @Mapping(source = "departure.train.name",target = "trainName"),
            @Mapping(source = "departure.route.type",target = "routeType")
    })
    DepartureDto departureToDto(Departure departure);


    @Mappings({
            @Mapping(source = "departureDto.trainName",target = "train.name"),
            @Mapping(source = "departureDto.routeType", target = "route.type"),
            @Mapping(source = "departureDto.departureCity",target = "departureCity.name"),
            @Mapping(source = "departureDto.arrivalCity",target = "arrivalCity.name")
    })
    Departure departureDtoToDeparture(DepartureDto departureDto);

}
