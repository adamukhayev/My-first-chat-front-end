package mappers;


import models.AbstractDto;

public interface Mapper<D extends AbstractDto> {

    D mapperJsonToDto(String json);

    String mapperDtoToJson(D dto);

}

