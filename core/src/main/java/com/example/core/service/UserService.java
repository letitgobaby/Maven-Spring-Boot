package com.example.core.service;

import java.util.ArrayList;

import org.hibernate.Session;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  
  public void userInfo() {
    System.out.println("userInfo");
  }

  public JSONObject logIn(JSONObject jobj) {
    JSONObject jsonObj = new JSONObject();

    ArrayList<String> roles = new ArrayList<String>();
    roles.add("USER");
    
    String name = jobj.get("username").toString();
    String passwd = jobj.get("password").toString();

    if (name.equals("admin") && passwd.equals("admin")) {
      roles.add("ADMIN");
      jsonObj.put("roles", roles);
      jsonObj.put("name", name);
      jsonObj.put("token", name.concat(passwd));

    } else if (name.equals("any") && passwd.equals("any")) {
      jsonObj.put("roles", roles);
      jsonObj.put("name", name);
      jsonObj.put("token", name.concat(passwd));
    }
    
    return jsonObj;
  }

  // public @ResponseBody void logOut() {
  //   System.out.println("logOut");
  // }


}
