package homework_34.controller;

import homework_34.Service.UsersService;
import homework_34.dto.User;
import homework_34.dto.Users;
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
    @PostMapping(value = "/createUsers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user) {
        usersService.create(user.getId(), user.getLogin());
        return new User();
    }

    @GetMapping("/Users")
    public Users getUsers() {
        return new Users(usersService.getUsers().size(), usersService.getUsers());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/byId/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        usersService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/byLogin/{login}")
    public void deleteUserByLogin(@PathVariable String login) {
        usersService.deleteByLogin(login);
    }

}
