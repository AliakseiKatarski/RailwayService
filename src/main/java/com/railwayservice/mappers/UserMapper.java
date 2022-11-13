package com.railwayservice.mappers;

import com.railwayservice.dto.UserDto;
import com.railwayservice.model.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mappings({
            @Mapping(source = "user.userInformation.name",target = "name"),
            @Mapping(source = "user.userInformation.surname",target = "surname"),
            @Mapping(source = "user.userInformation.phoneNumber",target = "phoneNumber"),
            @Mapping(source = "user.userInformation.email",target = "email")
    })
    UserDto userToDto(User user);
    User userDtoToUser(UserDto userDto);


}
