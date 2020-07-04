package models;

import lombok.*;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Person extends AbstractDto{
  private Integer person_id;
  private String name;
  private String surname;
  private Integer age;
  private String email;
  private String phone;
  private String login;
  private String password;
  private String password2;
  private String url;
  private String date;



}
