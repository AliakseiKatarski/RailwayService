package com.railwayservice.mappers;

import com.railwayservice.dto.UserRegistrationDto;
import com.railwayservice.model.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserRegistrationDtoMapper {
    User userRegistrationDtoToUser(UserRegistrationDto userRegistrationDto);

}
