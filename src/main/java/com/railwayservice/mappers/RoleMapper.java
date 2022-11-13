package com.railwayservice.mappers;

import com.railwayservice.dto.RoleDto;
import com.railwayservice.model.entity.Role;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RoleMapper {
    RoleDto roleToDto(Role role);

}
