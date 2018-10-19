package com.test.classloader;

import java.io.*;
import java.net.URL;
import java.util.Arrays;

public class MyClassLoader extends ClassLoader {

    private String name = "";

    public MyClassLoader(String name) {
        this.name = name;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            makeClassFile(name);

            InputStream is = null;

            String path = name;

            System.out.println(this.name + name.replace(".", "/") + ".class");
            is = new FileInputStream(new File(getRootPath() + name.replace(".", "/") + ".class"));

            byte[] buff = new byte[1024*4];

            int len = -1;


            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            while((len = is.read(buff)) != -1) {

                baos.write(buff,0,len);

            }

            byte[] bytes = baos.toByteArray();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void makeClassFile(String name) throws IOException {

        String[] split = name.split("\\.");
        String s = split[split.length - 1];
        String dir = "";
        for(int i = 0; i < split.length - 1; i++) {
            dir += split[i] + "\\";
        }
        File fileDir = new File(getRootPath() + dir);
        System.out.println(getRootPath() + dir);
        if(!fileDir.exists()) {
            fileDir.mkdirs();
        }
        FileInputStream fis = new FileInputStream(new File(this.name + s + ".class"));
        FileOutputStream fos = new FileOutputStream(new File(getRootPath() + name.replace(".", "/") + ".class"));
        byte[] buff = new byte[1024*4];
        int len = -1;
        while((len = fis.read(buff)) != -1) {
            fos.write(buff,0,len);
        }
    }

    private String getRootPath() {
        return this.name.substring(0, this.name.lastIndexOf("classes")) + "classes\\";
    }

}
