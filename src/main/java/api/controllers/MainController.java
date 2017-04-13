package api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin(origin = "*")
public class MainController {


    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }


}
