package max.dao;

import max.models.Note;

public class NoteDao extends AbstractDao {
    private NoteDao() {
    }

    private static NoteDao instance;

    public static NoteDao getInstance() {
        if (instance == null) {
            instance = new NoteDao();
        }
        return instance;
    }

    public Note index(int id) {
        return null; //TODO note
    }

    public Note[] getNotesByUserId(int id) {
        return null; //TODO note[]
    }

    public void add(Note note) {
        //TODO add note
    }

    public void delete(Note note) {
        //TODO delete note
    }

    public void update(Note note) {
        //TODO update note
    }
}
