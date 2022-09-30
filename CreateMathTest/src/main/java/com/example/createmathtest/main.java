package com.example.createmathtest;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static String Answers="0";
    public static void main(String args[]){
        System.out.print("输入要生成题目数量：");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print("输入数字大小范围：");
        int r= sc.nextInt();
        File file = 清空题目文件();
        File file2 = 清空答案文件();
        for(int i=0;i<n;i++){
            String test=createtest(r);
            System.out.println(test+Answers);
            写入题目(file, test);
            写入答案(file2);
        }
        System.out.println("1开始校对答案,2退出");
        int choose1=sc.nextInt();
        if(choose1==1) {
            try {
                FileReader fr=new FileReader("D:\\my program of JAVA\\CreateMathTest\\src\\main\\java\\com\\example\\createmathtest\\Answers.txt");
                BufferedReader br=new BufferedReader(fr);
                String line="";
                String[] arrs=null;
                int n1=0;
                while ((line=br.readLine())!=null) {
                    arrs=line.split(",");
//            System.out.println(arrs[0] + " : " + arrs[1] + " : " + arrs[2]);
//                    System.out.println(Arrays.asList(arrs).toString());
                    System.out.println(arrs[n1]);
                    n1++;
                }
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static File 清空答案文件() {
        File file2;
        file2=new File("D:\\my program of JAVA\\CreateMathTest\\src\\main\\java\\com\\example\\createmathtest\\Answers.txt");
        FileWriter fileWriter2 = null;
        try {
            fileWriter2 = new FileWriter(file2);
            // 往文件重写内容
            fileWriter2.write("");// 清空
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file2;
    }

    private static File 清空题目文件() {
        File file;
        file=new File("D:\\my program of JAVA\\CreateMathTest\\src\\main\\java\\com\\example\\createmathtest\\Exercises.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            // 往文件重写内容
            fileWriter.write("");// 清空
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private static void 写入答案(File file2) {
        FileWriter fw2 = null;
        try {
            fw2 = new FileWriter(file2,true);
            BufferedWriter writer = new BufferedWriter(fw2);
            writer.write(Answers);
            writer.flush();
            writer.newLine();
            writer.close();
            fw2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void 写入题目(File file, String test) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file,true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(test);
            writer.flush();
            writer.newLine();
            writer.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String createtest(int r){
        int zeroone=new Random().nextInt(2);
        if(zeroone==0)
            return 整数运算(r);
        if(zeroone==1){
            return 分数运算(r);
        }
        return null;
    }

    private static String 分数运算(int r) {
        char[] fuhao=new char[4];
        fuhao[0]='+';
        fuhao[1]='-';
        fuhao[2]='*';
        fuhao[3]='÷';
        int fh=new Random().nextInt(4);
        int z1=1;
        int m1=new Random().nextInt(r);
        int z2=1;
        int m2=new Random().nextInt(r);
        int x=0;
        int y=0;
        for(;m1==0||m2==0;){
            m1=new Random().nextInt(r);
            m2=new Random().nextInt(r);
        }
        if(fh==1){
            for(;m1>m2;){
                m2=new Random().nextInt(r);
            }
        }
        if(fh==0){
            x=z1*m1+z2*m2;
            y=m1*m2;
        }
        if (fh==1){
            x=z2*m2-z1*m1;
            y=m1*m2;
        }
        if (fh==2){
            x=z1*z2;
            y=m1*m2;
        }
        if (fh==3){
            x=z1*m2;
            y=m1*z2;
        }
        Answers=gcd(x,y);
        return String.valueOf(z1)+'/'+m1+' '+fuhao[fh]+' '+z2+'/'+m2+" = ";
    }

    public static String gcd(int m,int n) {
        int r;
        int t;
        int u;
        int w;
        //t和w用来存储分子和分母的初始数据
        t = m;
        w = n;
        //求最大公因数
        while (n != 0) {
            r = m % n;
            m = n;
            n = r;
        }
        //循环结束后此时m即为最大公因数
        //放个u = m看着方便
        u = m;
        //分子分母分别除以最大公因数
        t = t / u;
        w = w / u;
        //判断+输出
        //分子分母都为1 直接输出1
        if(t == 1 && w == 1){
            return "1";
        }
        //分子为0 分母不为0 直接输出0
        else if(t == 0 && w != 0){
            return "0";
        }
        //分子分母都不为0且不为1 直接输出
        else {
            return t + "/" + w;
        }
    }

    private static String 整数运算(int r) {
        char[] fuhao=new char[4];
        fuhao[0]='+';
        fuhao[1]='-';
        fuhao[2]='*';
        fuhao[3]='÷';
        int num1=new Random().nextInt(r);
        int num2=new Random().nextInt(r);
        int fh=new Random().nextInt(4);
        if(fh==1){
            for(;num1<num2;)
                num2=new Random().nextInt(r);
        }
        if(fh==3){
            for(;num2==0;){
                num2=new Random().nextInt(r);
            }
        }
        int answer=0;
        if(fh==0){
            answer=num1+num2;
        }
        if(fh==1){
            answer=num1-num2;
        }
        if(fh==2){
            answer=num1*num2;
        }
        if(fh==3){
            answer=num1/num2;
            if(answer==0&&num1!=0){/*数1小于数2，由于整型，结果错误，为0*/
                Answers= String.valueOf(num1)+'/'+num2;
                return String.valueOf(num1)+' '+fuhao[fh]+' '+num2+" = ";
            }
            else{
                if(num1%num2!=0) {/*数1大于数2，由于整型，结果错误，需处理为分数*/
                    int fenzi = num1-(num1/num2)*num2;
                    int fenmu = num2;
                    int fentou = num1 / num2;
                    Answers= String.valueOf(fentou) + "'" + fenzi + '/' + fenmu;
                    return String.valueOf(num1)+' ' + fuhao[fh]+' ' + num2 + " = ";
                }
            }
        }
        Answers= String.valueOf(answer);
        return String.valueOf(num1)+' ' +fuhao[fh]+' '+num2+" = ";
    }
}
