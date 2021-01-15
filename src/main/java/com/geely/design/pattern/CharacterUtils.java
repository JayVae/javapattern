package com.geely.design.pattern;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class CharacterUtils {

    public static void main(String[] args) {
        String grades = "26\t36\t44\t34\t30\t35\t23\t30\t41\t40\t32\t32\t44\t33\t29\t40\t35\t40\t27\t31\t38\t33\t27\t36";
        String outputPath = "H:\\workspace_idea\\javapattern\\src\\main\\java\\com\\geely\\design\\pattern\\";
        new CharacterUtils().match2(grades, outputPath+"origin.txt", outputPath);
    }



    public void match2(String grades, String originPath, String outputPath){
        String[] grds = grades.split("\t");
        gradeObj[] gradeObjs = new gradeObj[grds.length];

        int i = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(originPath)));
            String s = null;
            while((s = br.readLine())!= null){//使用readLine方法，一次读一行
                if (s.matches("^\\d+.*") == true){
                    gradeObjs[i] = new gradeObj(Integer.parseInt(grds[i]), s);
                    i++;
//                    System.out.printf("第%d次输出："+s+"\n", i);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Arrays.sort(gradeObjs);
        String fileName =new SimpleDateFormat("yyyyMMdd").format(new Date())+"-2.txt";
        File file = null;
        FileWriter fw = null;
        try {
            file = new File(outputPath + fileName);
            if ( !file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            fw.write("要写入的内容......"+"\n");
            for (int j = 0; j < gradeObjs.length; j++) {
                fw.write(gradeObjs[j].getGrade()+"       :"+gradeObjs[j].getColumn()+"\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void match(String grades, String originPath, String outputPath){
        Map<Integer, String> map = new TreeMap();
        String[] grds = grades.split("\t");
        System.out.println("length: "+ grds.length);
//        for (int i = 0; i < grds.length; i++) {
//            System.out.println(grds[i]);
//        }

        String[] origins = new String[grds.length];
        int i = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(originPath)));
            String s = null;
            while((s = br.readLine())!= null){//使用readLine方法，一次读一行
                if (s.matches("^\\d+.*") == true){
                    origins[i] = s;
                    map.put(Integer.parseInt(grds[i]), s);
                    i++;
//                    System.out.printf("第%d次输出："+s+"\n", i);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("map长度"+map.size());
        for (Map.Entry<Integer, String> entry :
                map.entrySet()) {
            System.out.println(entry.getKey() + "：     " + entry.getValue());
        }

        String fileName =new SimpleDateFormat("yyyyMMdd").format(new Date())+".txt";
        File file = null;
        FileWriter fw = null;
        try {
            file = new File(originPath + fileName);
            if ( !file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            fw.write("要写入的内容......"+"\n");
            for (Map.Entry<Integer, String> entry :
                    map.entrySet()) {
                fw.write(entry.getKey() + "：     " + entry.getValue()+"\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
