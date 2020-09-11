package currency.controller;

import currency.Curs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @Autowired
    private Curs curs;

    @GetMapping("/")
    public String init(Model model){

        model.addAttribute("dol", curs.getDollar());
        model.addAttribute("eur", curs.getEuro());
        model.addAttribute("rub", 1.00);

        return "index";
    }

}
