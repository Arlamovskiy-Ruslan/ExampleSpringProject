package com.example.examplespringproject.mapper;

import com.example.examplespringproject.dto.UserSessionResponse;
import com.example.examplespringproject.model.UserSession;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        builder = @Builder(disableBuilder = true),
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SessionMapper {

    @Mapping(source = "creationTime", target = "creationTime")
    @Mapping(source = "uuid", target = "uuid")
    UserSessionResponse toResponse(UserSession userSession);
}
