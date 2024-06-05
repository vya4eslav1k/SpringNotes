package max.dao;

import max.models.User;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDao extends AbstractDao {
    private static final String ADD = "insert into user(login,password) values(?,?)";
    private static final String UPDATE = "update user set login=?,password=? where id=?";
    private static final String DELETE = "delete from user where id=?";
    private static final String SELECT_ONE = "select * from user where id=?";
    private UserDao() {
    }

    public User show(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ONE);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"));
            }
            else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement(ADD);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE);
            ps.setInt(1, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
