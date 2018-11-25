package com.test.extend;

import java.util.ArrayList;
import java.util.List;

public class Father {

    List<String> list = new ArrayList<String>();

    public void add(String str) {
        list.add(str);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
