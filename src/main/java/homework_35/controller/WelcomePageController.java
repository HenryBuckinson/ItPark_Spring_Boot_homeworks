package homework_35.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notebook")
public class WelcomePageController {

    @GetMapping
    public String index() {
        return "welcome";
    }
}
