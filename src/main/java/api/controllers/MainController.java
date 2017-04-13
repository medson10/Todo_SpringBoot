package api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(options = "*" maxAge = 3600)
@RestController
public class MainController {


    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }


}
