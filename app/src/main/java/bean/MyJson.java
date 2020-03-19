package bean;

import java.util.List;

/**
 * date:2020/3/17
 * author:师浩洁(shihaojie)
 * function:
 */
public class MyJson {

    private String pic_s192;
    private List<MyContent> content;

    public String getPic_s192() {
        return pic_s192;
    }

    public void setPic_s192(String pic_s192) {
        this.pic_s192 = pic_s192;
    }

    public List<MyContent> getContent() {
        return content;
    }

    public void setContent(List<MyContent> content) {
        this.content = content;
    }

    public MyJson() {
    }

    public MyJson(String pic_s192, List<MyContent> content) {
        this.pic_s192 = pic_s192;
        this.content = content;
    }
}
