package POST_Requests;

public class PostObject {

    private String id;
    private String title;
    private String author;

    public PostObject_info getInfo() {
        return info;
    }

    public void setInfo(PostObject_info info) {
        this.info = info;
    }

    private PostObject_info info;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

}
