package com.example.zlx;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//需要开启一个线性池子读取数据
public class countSurname {

    @Test
    void  countFile(){
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String str = "";
        Map<String,Integer> mapSurname = new HashMap();
        try {
            fis = new FileInputStream("E:\\Surnamel.txt");
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            while ((str = br.readLine()) != null) {
                if (mapSurname.containsKey(getSurname(str))){//包含指定姓氏key
                    mapSurname.put(getSurname(str),mapSurname.get(getSurname(str)).intValue()+1);
                }else{
                    mapSurname.put(getSurname(str),1);
                }
            }

            for(String key : mapSurname.keySet()){	//只能遍历key
                System.out.println("姓名:"+key+",次数:"+mapSurname.get(key));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    String getSurname(String name){
        return name.substring(0,name.indexOf(" "));
    }

}
