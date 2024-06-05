package max.models;

import java.util.Date;

public class Note {
    private int id;
    private String title;
    private String content;
    private Date lastUpdate;
    private int userId;

    public Note(int id, String title, String content, Date lastUpdate, int userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.lastUpdate = lastUpdate;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
