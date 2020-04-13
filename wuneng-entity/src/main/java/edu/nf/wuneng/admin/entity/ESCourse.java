package edu.nf.wuneng.admin.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author YXD
 * @date 2020/4/13
 */
@Document(indexName = "escourse")
public class ESCourse {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private Integer num;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String type;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Text)
    private String introduct;
    @Field(type = FieldType.Text)
    private String img;

    public ESCourse() {
    }

    public ESCourse(String id, Integer num, String type, String name, String introduct, String img) {
        this.id = id;
        this.num = num;
        this.type = type;
        this.name = name;
        this.introduct = introduct;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduct() {
        return introduct;
    }

    public void setIntroduct(String introduct) {
        this.introduct = introduct;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}