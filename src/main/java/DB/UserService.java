package DB;

import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public void DeleteAllUsers();

    public int getUserCount();

    public List getAllUsers();

    public void create(String name,int age);

    public void deleteByName(String name);
}
