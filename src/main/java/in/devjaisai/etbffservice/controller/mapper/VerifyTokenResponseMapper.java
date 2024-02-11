package in.devjaisai.etbffservice.controller.mapper;

import in.devjaisai.etbffservice.controller.model.VerifyTokenResponseDto;
import in.devjaisai.etbffservice.service.external.auth.VerifyTokenResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VerifyTokenResponseMapper {
    VerifyTokenResponseMapper INSTANCE = Mappers.getMapper(VerifyTokenResponseMapper.class);

    VerifyTokenResponseDto toVerifyTokenResponseDto(VerifyTokenResponse tokenResponse);
}