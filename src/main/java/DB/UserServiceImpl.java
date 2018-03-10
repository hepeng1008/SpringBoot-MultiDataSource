package DB;

import DB.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void DeleteAllUsers() {
        jdbcTemplate.update("delete from USER ");
    }

    @Override
    public int getUserCount() {
        return jdbcTemplate.queryForObject("select count(1) from user",Integer.class);
    }

    @Override
    public List getAllUsers() {
        return jdbcTemplate.query("select * from user", new RowMapper<User>(){

            @Nullable
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                u.setAge(age);
                u.setName(name);
                return u;
            }
        });
    }

    @Override
    public void create(String name, int age) {
        jdbcTemplate.update("insert INTO user(name,age) VALUES (?,?)",name,age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from user where name=?",name);
    }
}
