package api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
public class MainController {


    @RequestMapping("/")
    @CrossOrigin(origins = "*")
    public String index() {
        return "Hello World";
    }


}
