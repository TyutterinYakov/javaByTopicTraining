package com.simple;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://vk.com/yasha20053");
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }

    }
}
