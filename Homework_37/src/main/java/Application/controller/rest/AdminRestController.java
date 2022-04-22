package Application.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access/admin")
@RequiredArgsConstructor
public class AdminRestController {

    @GetMapping("/info")
    public String info(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
