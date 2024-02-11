package in.devjaisai.etbffservice.controller.mapper;

import in.devjaisai.etbffservice.controller.model.VerifyTokenRequestDto;
import in.devjaisai.etbffservice.service.external.auth.VerifyTokenRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface VerifyTokenRequestMapper {
    VerifyTokenRequestMapper INSTANCE = Mappers.getMapper(VerifyTokenRequestMapper.class);

    VerifyTokenRequest toVerifyTokenRequest(VerifyTokenRequestDto dto);
}