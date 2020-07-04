package services;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import mappers.PersonMappers;
import models.AddFriend;
import models.Msg;
import models.Person;
import utils.Utils;

public  class PersonService {
  Gson gson = new Gson();
  Utils utils = new Utils();
  PersonMappers personMappers = new PersonMappers();

  private String host = "http://localhost:9090";

  public PersonService() {

  }

  public Person getPersonById(String login) {
    HashMap<String, Object> hashMap = new HashMap<String, Object>();
    Person person = new Person();

    hashMap.put("login", login);
    String strLine = null;
    try {
      person = personMappers.mapperJsonToDto(utils.GETRequest(host + "/login", hashMap));
      System.out.println(person.getName() + " " + person.getSurname());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return person;
  }

  public List<Person> getPersons() throws IOException {

    String json = utils.GETRequest(host + "/all", null);
    List<Person> list = personMappers.mapperJsonToListDto(json);
    for (int i = 0; i < list.size(); i++) {
      Person person = list.get(i);
      System.out.println(person.getName() + " NAME");
    }
    return list;
  }

  public void savePerson(Person person) {
    String json = gson.toJson(person);
    try {
      utils.POSTRequest(json, host + "/add");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String loginPerson(Person person) {
    try {
      String json = gson.toJson(person);
      String info = utils.POSTRequest(json, host + "/login");
      if (!info.equals("")) {
        return info;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return "not found";
  }

  public void updatePerson(Person person) throws IOException {
    String json = gson.toJson(person);
       utils.POSTRequest(json,host+"/update");
  }

  public void deletePerson(Integer id) throws IOException {
      utils.DELETERequest(id,host+"/delete");
  }


  public List<Msg> getMessage(String name, String accountName) throws IOException {
    HashMap<String, Object> hashMap = new HashMap<String, Object>();


    hashMap.put("login", name);
    hashMap.put("accountName", accountName);
    String json = utils.GETRequest(host + "/message", hashMap);
    List<Msg> msg = personMappers.mapperJsonToListMsgDto(json);
    for (Msg list : msg) {
      System.out.println("My SMS : " + list);
    }
    return msg;
  }

  public void saveMsg(Msg msg) {
    System.out.println(msg.getMsg() + "   AS");
    String json = gson.toJson(msg);
    try {
      utils.POSTRequest(json, host + "/addMsg");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void addFriend(AddFriend addFriend) {
    String json = gson.toJson(addFriend);
    try {
      utils.POSTRequest(json, host + "/friend");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public AddFriend bol(AddFriend addFriend) {
    HashMap<String, Object> hashMap = new HashMap<String, Object>();

    hashMap.put("nickName1", addFriend.getNickName1());
    hashMap.put("nickName2", addFriend.getNickName2());
    Boolean boll = true;
    try {
      addFriend = personMappers.mapperJsonToAddFriendDto(utils.GETRequest(host + "/bol", hashMap));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return addFriend;
  }
}