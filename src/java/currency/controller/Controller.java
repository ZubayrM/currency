package currency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Controller {

    @GetMapping("ol")
    public String getTime(){
        return "00";
    }
}
