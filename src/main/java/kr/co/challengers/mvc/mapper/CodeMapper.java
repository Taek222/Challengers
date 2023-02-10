package kr.co.challengers.mvc.mapper;

import kr.co.challengers.mvc.domain.Code;
import kr.co.challengers.mvc.parameter.CodeRequestParameter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CodeMapper {

    CodeMapper INSTANCE = Mappers.getMapper(CodeMapper.class);

    Code getCodeFromCodeCreateRequest(CodeRequestParameter.CodeCreateRequest request);
}
