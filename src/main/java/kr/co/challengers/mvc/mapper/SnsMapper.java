package kr.co.challengers.mvc.mapper;

import kr.co.challengers.mvc.domain.Sns;
import kr.co.challengers.mvc.parameter.SnsRequestParameter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SnsMapper {

    SnsMapper INSTANCE = Mappers.getMapper(SnsMapper.class);

    Sns dtoToEntity(SnsRequestParameter dto);

    SnsRequestParameter entityToDto (Sns entity);
}
