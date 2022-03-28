package homework_34.Service;


import homework_34.dto.User;

import java.util.List;

public interface UsersService {
    void create(Integer id, String login);

    List<User> getUsers();

    void deleteById(Integer id);

    void deleteByLogin(String login);
}
