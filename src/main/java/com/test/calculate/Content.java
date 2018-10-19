package com.test.calculate;

public class Content implements Comparable<Content> {

    private Integer index;
    private Integer num;

    public Content(Integer index, Integer num) {
        this.index = index;
        this.num = num;
    }

    @Override
    public int compareTo(Content content) {
        if (this.num > content.num) {
            return -1;
        } else if (this.num < content.num) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Content{" +
                "index=" + index +
                ", num=" + num +
                '}';
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
