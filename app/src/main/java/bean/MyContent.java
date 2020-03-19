package bean;

/**
 * date:2020/3/17
 * author:师浩洁(shihaojie)
 * function:
 */
public class MyContent {

    private String pic_big;
    private String title;
    private String author;
    private String fabulous;

    public String getPic_big() {
        return pic_big;
    }

    public void setPic_big(String pic_big) {
        this.pic_big = pic_big;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFabulous() {
        return fabulous;
    }

    public void setFabulous(String fabulous) {
        this.fabulous = fabulous;
    }

    public MyContent() {
    }

    public MyContent(String pic_big, String title, String author, String fabulous) {
        this.pic_big = pic_big;
        this.title = title;
        this.author = author;
        this.fabulous = fabulous;
    }
}
