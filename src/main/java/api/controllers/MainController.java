package api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    @CrossOrigin
    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }


}
