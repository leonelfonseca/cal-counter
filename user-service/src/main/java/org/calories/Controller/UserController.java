package org.calories.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

@CrossOrigin(origins = "http://localhost:8008")
public class UserController {

    @GetMapping
    @RequestMapping(value = "/test")
    @ResponseBody
    public ResponseEntity<String> getTestData() {
        return ResponseEntity.ok("Alive and kicking");
    }
}
