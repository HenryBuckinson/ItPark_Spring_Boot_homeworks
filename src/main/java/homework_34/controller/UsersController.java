package homework_34.controller;

import homework_34.Service.UsersService;
import homework_34.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user) {
        usersService.create(user.getId(), user.getLogin());
        return new User(user.getId(), user.getLogin());
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return usersService.getUsers();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/by-id/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        usersService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/by-login/{login}")
    public void deleteUserByLogin(@PathVariable String login) {
        usersService.deleteByLogin(login);
    }

}
