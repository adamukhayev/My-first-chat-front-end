//package mappers;
//
//import com.google.gson.Gson;
//import entity.ContatcEntity;
//import models.ContactDto;
//
//
//public class ContactMapper implements Mapper <ContactDto> {
//
//    Gson gson = new Gson();
//
//    public ContactDto mapperJsonToDto(String json){ /// Dto Работа между клиентом и бекЭндом
//        return  gson.fromJson(json, ContactDto.class);
//    }
//
//    public ContatcEntity mapperDtoToEntity(ContactDto contactDto){
//        String json = gson.toJson(contactDto);
//        return gson.fromJson(json, ContatcEntity.class);
//    }
//
//    public ContactDto mapperEntityToDto(ContatcEntity contactEntity){ // Entity  работа между бекЭндом и Базой данных
//        String json = gson.toJson(contactEntity);
//        return gson.fromJson(json, ContactDto.class);
//    }
//
//    public String mapperDtoToJson(ContactDto contactDto){
//        return gson.toJson(contactDto);
//    }
//
//
//}
//
