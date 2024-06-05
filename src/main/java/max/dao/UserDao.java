package max.dao;

import max.models.Note;
import max.models.User;

public class UserDao extends AbstractDao {
    private UserDao() {
    }

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public User index(int id) {
        return null; //TODO user
    }

    public void add(User user) {
        //TODO add user
    }

    public void delete(User user) {
        //TODO delete user
    }

    public void update(User user) {
        //TODO update user
    }
}
