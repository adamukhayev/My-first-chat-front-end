package utils;

import models.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class Utils {

  public String POSTRequest(String json, String url) throws IOException {
    URL obj = new URL(url);
    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
    postConnection.setRequestMethod("POST");
    postConnection.setRequestProperty("Content-Type", "application/json; utf-8");
    postConnection.setRequestProperty("Accept", "application/json");
    postConnection.setDoOutput(true);

    OutputStream os = postConnection.getOutputStream();
    os.write(json.getBytes());
    os.flush();
    os.close();

    int responseCode = postConnection.getResponseCode();
    System.out.println("POST Response Code :  " + responseCode);
    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
    if (responseCode == HttpURLConnection.HTTP_CREATED || responseCode == HttpURLConnection.HTTP_OK) {
      BufferedReader in = new BufferedReader(new InputStreamReader(
          postConnection.getInputStream()));
      String inputLine;
      StringBuilder response = new StringBuilder();
      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      System.out.println("STRING "+response.toString());
      return response.toString();
    } else {
      System.out.println("POST NOT WORKED");
    }
     return "not found";
  }

    public String GETRequest(String url, HashMap<String, Object> params) throws IOException {
        StringBuilder string = new StringBuilder();
        string.append(url);

        if (Objects.nonNull(params) && params.size() > 0) {
            Set<String> keys = params.keySet();
            string.append("?");
            for (String key : keys) {
                string.append(key).append("=").append(params.get(key)).append("&");
            }
        }

        URL urlForGetRequest = new URL(string.toString());
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        StringBuilder response = new StringBuilder();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String readLine = null;
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            System.out.println("JSON String Result " + response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
        return response.toString();
    }

    public ArrayList<String> GETRequestMsg(String url,HashMap<String, Object> params) throws IOException {
        StringBuilder string = new StringBuilder();
        string.append(url);

        if (Objects.nonNull(params) && params.size() > 0) {
            Set<String> keys = params.keySet();
            string.append("?");
            for (String key : keys) {
                string.append(key).append("=").append(params.get(key)).append("&");
            }
        }
        System.out.println(string.toString());


        URL urlForGetRequest = new URL(string.toString());
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
       ArrayList<String> list = new ArrayList<>();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String readLine = null;
            while ((readLine = in.readLine()) != null) {
                list.add(readLine);
            }
            in.close();
        } else {
            System.out.println("GET NOT WORKED");
        }
        return list;
    }

    public void DELETERequest(Integer id, String host) throws IOException {
      URL url = new URL(host+"?id="+id);
        System.out.println(url.toString());

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");

        int responseCode = connection.getResponseCode();

        System.out.println(responseCode);

        if(responseCode == HttpURLConnection.HTTP_OK){
            System.out.println("GET NOT WORKED");
        }else {

        }
    }

//    public void PUTRequest(String json, String url, int id) throws IOException {
//        URL obj = new URL(url);
//        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
//        postConnection.setRequestMethod("PUT");
//        postConnection.setRequestProperty("Content-Type", "application/json; utf-8");
//        postConnection.setRequestProperty("Accept", "application/json");
//        postConnection.setDoOutput(true);
//
//        OutputStream os = postConnection.getOutputStream();
//        os.write(json.getBytes());
//        os.flush();
//        os.close();
//
//        System.out.println("PUT: "+os.toString());
//    }

}


