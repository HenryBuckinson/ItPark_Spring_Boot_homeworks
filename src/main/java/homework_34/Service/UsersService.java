package homework_34.Service;

import homework_34.dto.User;

public interface UsersService {
    void create(User user);

    UsersService create(Integer id, String login);
}
