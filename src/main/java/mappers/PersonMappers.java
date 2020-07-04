package mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import models.AddFriend;
import models.Msg;
import models.Person;
import org.modelmapper.ModelMapper;
//import models.PersonDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonMappers {
    Gson gson = new Gson();
    ModelMapper mapper = new ModelMapper();
    ObjectMapper objectMapper = new ObjectMapper();

    public Person mapperJsonToDto(String json) { /// Dto Работа между клиентом и бекЭндом
        return gson.fromJson(json, Person.class);
    }


    public String mapperDtoToJson(Person personDto) {
        return gson.toJson(personDto);
    }

    public Person readerToDto(BufferedReader reader) {
        return gson.fromJson(reader, Person.class);
    }

    public List<Person> mapperJsonToListDto(String json) throws IOException {
        List<Person> persons =  Arrays.asList( objectMapper.readValue(json, Person[].class));
        return persons;
    }
    public List<Msg> mapperJsonToListMsgDto(String json) throws IOException {
        List<Msg> msg =  Arrays.asList( objectMapper.readValue(json, Msg[].class));
        return msg;
    }

    public AddFriend mapperJsonToAddFriendDto(String json) { /// Dto Работа между клиентом и бекЭндом
        return gson.fromJson(json, AddFriend.class);
    }

    public String mapperAddFriendDtoToJson(AddFriend addFriend) {
        return gson.toJson(addFriend);
    }

    public AddFriend readerToAddFriendDto(BufferedReader reader) {
        return gson.fromJson(reader, AddFriend.class);
    }
}
