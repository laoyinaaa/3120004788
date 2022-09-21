package com.example.a3120004788;

import java.io.IOException;

public class main {
    public static void main(String[] args) {
        String text1 = null;
        String text2 = null;
        String path1="D:\\my program of JAVA\\aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\\orig.txt";
        String path2="D:\\my program of JAVA\\aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\\orig_0.8_add.txt";
        try {
            //由上方输入的文件路径获得字符串
            text1 = TextUtils.readFileToString(path1);
            text2 = TextUtils.readFileToString(path2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //算出相似度
        compute compute=new compute();
        double result = compute.GetSimilarity(text1, text2);
        //将结果输出
        System.out.println(result);
    }
}
