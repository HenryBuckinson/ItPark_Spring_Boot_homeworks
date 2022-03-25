package homework_34.controller;

import homework_34.Service.UsersService;
import homework_34.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home")
@RequiredArgsConstructor
public class Input {

    private final UsersService usersService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user) {
        usersService.create(user.getId(), user.getLogin());
        return new User();
    }

}
