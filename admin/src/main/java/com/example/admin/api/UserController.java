package com.example.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.core.service.UserService;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {

  @Autowired
  UserService userService;
    
  @GetMapping(value = "/api/user")
  public @ResponseBody JSONObject userInfo(HttpServletRequest request) {
    HttpSession session = request.getSession();
    JSONObject result = (JSONObject) session.getAttribute("USER");

    return result;
  }

  @PostMapping(value = "/api/user/login")
  public @ResponseBody JSONObject logIn(@RequestBody JSONObject jobj, HttpServletRequest request) {
    HttpSession session = request.getSession();
    JSONObject result = userService.logIn(jobj);

    System.out.println("hello");

    if (result.get("name") != null) {
      session.setAttribute("USER", result);
    }
    return result;
  }

  @PostMapping(value = "/api/user/logout")
  public @ResponseBody void logOut(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.removeAttribute("USER");
  }

}
