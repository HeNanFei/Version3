package com.zjt.manager.util;

import java.lang.reflect.Method;
import java.util.List;

public class StringUtil {

    public static String transform(String type){
        String strings = "";
        String[] split = type.split(",");
        for(int i = 0;i<split.length;i++){
            if (split[i].equals("7") ){
                strings += "管理员"+",";
            }else
            if (split[i].equals ("1")){
                strings += "语文老师"+",";
            }else
            if (split[i].equals("2")){
                strings += "数学老师"+",";
            }else
            if (split[i].equals ("3")){
                strings += "英语老师"+",";
            }else
            if (split[i].equals ("4")){
                strings += "化学老师"+",";
            }else
            if (split[i].equals ("5")){
                strings += "物理老师"+",";
            }else
            if (split[i].equals ("6")){
                strings += "生物老师"+",";
            }else{
                strings = type;
            }

            System.out.println(strings+"+++++++++++++++++++++++++++++++++++++++++");
        }


        return strings;

    }

}
