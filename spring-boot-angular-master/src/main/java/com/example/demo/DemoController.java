package com.example.demo;

import java.security.Principal;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller

@CrossOrigin
public class DemoController {
	@GetMapping("/resource")
	  @ResponseBody
	  public Map<String, Object> home() {
	    Map<String, Object> model = new HashMap<String, Object>();
	    model.put("id", UUID.randomUUID().toString());
	    model.put("content", "Hello World");
	    return model;
	  }

	/*  @GetMapping(value = "/{path:[^\\.]*}")
	  public String redirect() {
	    return "forward:/";
	  }*/
	  

	    @RequestMapping("/login")
	    public boolean login(@RequestBody User user) {
	        return
	          user.getUserName().equals("user") && user.getPassword().equals("password");
	    }
	     
	    @RequestMapping("/user")
	    public Principal user(HttpServletRequest request) {
	        String authToken = request.getHeader("Authorization")
	          .substring("Basic".length()).trim();
	        return () ->  new String(Base64.getDecoder()
	          .decode(authToken)).split(":")[0];
	    }
}
