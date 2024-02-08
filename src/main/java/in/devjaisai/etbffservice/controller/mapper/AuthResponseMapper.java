package in.devjaisai.etbffservice.controller.mapper;


import in.devjaisai.etbffservice.controller.model.AuthResponseDto;
import in.devjaisai.etbffservice.service.model.AuthResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthResponseMapper {

    AuthResponseMapper INSTANCE = Mappers.getMapper(AuthResponseMapper.class);

    AuthResponseDto toAuthResponseDto(AuthResponse authResponse);
}
