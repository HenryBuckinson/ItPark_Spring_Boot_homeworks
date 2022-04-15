package App.Service;

import App.Service.UsersService;
import App.Application.dto.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@NoArgsConstructor
@Data
public class UsersServiceImpl implements UsersService {

    private List<User> users = new LinkedList<>();

    @Override
    @SneakyThrows
    public void create(Integer id, String login) {
        users.add(new User(id, login));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void deleteById(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public void deleteByLogin(String login) {
        users.removeIf(user -> user.getLogin().equals(login));
    }
}
