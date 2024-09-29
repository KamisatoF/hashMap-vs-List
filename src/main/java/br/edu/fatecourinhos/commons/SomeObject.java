package br.edu.fatecourinhos.commons;

import java.util.Objects;

public class SomeObject {

    public SomeObject() {
    }

    public SomeObject(Integer filed1, String field2, String field3, String field4, String field5) {
        this.filed1 = filed1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
    }

    private Integer filed1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;

    @Override
    public String toString() {
        return "SomeObject{" +
                "filed1=" + filed1 +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeObject that = (SomeObject) o;
        return Objects.equals(filed1, that.filed1) && Objects.equals(field2, that.field2) && Objects.equals(field3, that.field3) && Objects.equals(field4, that.field4) && Objects.equals(field5, that.field5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filed1, field2, field3, field4, field5);
    }

    public void setFiled1(Integer filed1) {
        this.filed1 = filed1;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }
}
