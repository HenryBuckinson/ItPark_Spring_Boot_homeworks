package homework_34.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework_34.dto.User;
import homework_34.mapper.Response;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

@Service
@NoArgsConstructor
public class UsersServiceImpl implements UsersService {

    List<User> users = new LinkedList<>();

    @Override
    @SneakyThrows
    public UsersService create(Integer id, String login) {
        URL currencyUrl = new URL("http://localhost:8080/api/home/create");
        try (InputStream is = currencyUrl.openStream()) {
            ObjectMapper mapper = new ObjectMapper();
            Response response = mapper.readValue(is, Response.class);
            Integer id1 = response.getId();
            String login1 = response.getLogin();
            users.add(new User(id1,login1));
        }
        return null;
    }

    @Override
    @SneakyThrows
    public void create(User user) {
        URL currencyUrl = new URL("http://localhost:8080/api/home/create");
        try (InputStream is = currencyUrl.openStream()) {
            ObjectMapper mapper = new ObjectMapper();
            Response response = mapper.readValue(is, Response.class);
            Integer id = response.getId();
            String login = response.getLogin();
            users.add(new User(id,login));
        }
    }
}
