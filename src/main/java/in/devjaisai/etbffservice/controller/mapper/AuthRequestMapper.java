package in.devjaisai.etbffservice.controller.mapper;

import in.devjaisai.etbffservice.controller.model.AuthRequestDto;
import in.devjaisai.etbffservice.service.model.AuthRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthRequestMapper {

    AuthRequestMapper INSTANCE= Mappers.getMapper(AuthRequestMapper.class);

   AuthRequest toAuthRequest(AuthRequestDto authRequestDto);
}
