package max.dao;

import max.models.Note;
import max.models.User;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class NoteDao extends AbstractDao {
    private static final String ADD = "insert into note(content,title,userId,lastUpdate) values(?,?,?,now());";
    private static final String UPDATE = "update note set content=?,title=?,lastUpdate=NOW() where id=?;";
    private static final String DELETE = "delete from note where id=?;";
    private static final String SELECT_ONE = "select * from note where id=?;";
    private static final String SELECT_BY_USERID = "select * from note where userId=?;";
    private static final String SELECT_ALL = "select * from note;";

    private NoteDao() {
    }

    public Note show(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ONE);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Note(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getDate("lastUpdate"),
                        rs.getInt("userId"));
            }
            else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Note> index() {
        try {
            ArrayList<Note> list = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Note(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getDate("lastUpdate"),
                        rs.getInt("userId")));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Note> getByUserId(int userId) {
        try {
            ArrayList<Note> list = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(SELECT_BY_USERID);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Note(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getDate("lastUpdate"),
                        rs.getInt("userId")));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Note note) {
        try {
            PreparedStatement ps = connection.prepareStatement(ADD);
            ps.setString(1, note.getContent());
            ps.setString(2, note.getTitle());
            ps.setInt(3, note.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Note note) {
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE);
            ps.setInt(1, note.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Note note) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setString(1, note.getContent());
            ps.setString(2, note.getTitle());
            ps.setInt(3, note.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
