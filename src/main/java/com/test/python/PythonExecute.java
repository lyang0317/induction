package com.test.python;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonExecute {

    public static void main(String[] args) {
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("python D:\\software\\Profession\\IDEA\\JetBrains\\IdeaProjects\\strategy1\\joinquant_roe_pb\\src\\test\\httptest.py");
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "GBK"));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
