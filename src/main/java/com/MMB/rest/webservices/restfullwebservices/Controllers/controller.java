package com.MMB.rest.webservices.restfullwebservices.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://muhammadmb.github.io"})

public class controller {

    @GetMapping("/")
    public String Greating (){
        return "Hi";
    }
    @GetMapping("/{name}")
    public Helper Help (@PathVariable String name){
        if(name.equals("MuhammadMB")){
            throw new RuntimeException("Not Valid");
        }
        return new Helper(String.format("%s says hello",name));
    }
}
