package com.Util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProUtil {


    public Properties pro;

    public ProUtil(String filePath) throws IOException {
        pro = readProperties(filePath);
    }



    public Properties readProperties(String filePath) throws IOException {
        Properties properties=new Properties();

        FileInputStream fileInputStream=new FileInputStream(filePath);
        BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
        properties.load(bufferedInputStream);

        return properties;
    }

    public String getPro(String key){
        String value;
        if (pro.containsKey(key)){
            value=pro.getProperty(key);
            return  value;
        }else {
            return "properties中无此key!";
        }
    }

    public int getLines(){
        return  pro.size();
    }


    public static void main (String[] args) throws IOException {

        ProUtil proUtil=new ProUtil("src/main/resources/element.properties");
        String aaa=proUtil.getPro("userName");
        System.out.println(aaa);
    }


}
