package App.Service;


import App.Application.dto.User;

import java.util.List;

public interface UsersService {
    void create(Integer id, String login);

    List<User> getUsers();

    void deleteById(Integer id);

    void deleteByLogin(String login);
}
