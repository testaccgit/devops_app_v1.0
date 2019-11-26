package rs.gecko.devopstest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.StringUtils;

@RestController
public class HelloController {

  @RequestMapping({"/hello/{name}","/hello/","/hello"})
  public ResponseEntity<?> getMessage(@PathVariable(name = "name", required = false)  String name) {

    String value = StringUtils.isEmpty(name) ? "stranger" : name;

    if ("TEAPOT".equalsIgnoreCase(value)) {
      return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
    String message = String.format("Hello %s, welcome!", value);

    return new ResponseEntity<>(message, HttpStatus.OK);
  }
}