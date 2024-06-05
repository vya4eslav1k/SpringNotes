package max.models;

import java.util.Date;

public class Note {
    private Integer id;
    private String title;
    private String content;
    private Date lastUpdate;
    private Integer userId;

    public Note(Integer id, String title, String content, Date lastUpdate, Integer userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.lastUpdate = lastUpdate;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
