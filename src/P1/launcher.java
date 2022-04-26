package P1;

import java.io.*;
import java.util.Scanner;

public class launcher {
    public static void main(String args[])throws IOException{
        int i=0,j=0,sum=0,d=0,N=0;
        String fileName = "src\\P1\\txt\\5.txt";
        try (Scanner sc = new Scanner(new FileReader(fileName))){
            while(sc.hasNextLine()){
                sc.nextLine();
                N++;
            }
        }
        int arr[][] =new int[N][N]; char s[];
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                s=line.toCharArray();
                while(s[i] <= '9' && s[i] >= '0'){
                    arr[j][d]=arr[j][d]*10+s[i]-'0';
                    i++;
                    if(i >= s.length)   break;
                    if(s[i]=='\t'&&i+1<s.length){
                        if(s[i+1]=='\t'){
                            System.out.println("有多余的制表符。");
                            return;
                        }
                        d++;    i++;
                    }
                    if(i >= s.length)   break;
                }
                if(i<s.length && s[i]!='\t'&&(s[i]<'0'||s[i]>'9')) {
                    System.out.println("矩阵格式不规范，除正整数与制表符、换行符外有其他内容（如正负号）。");
                    return;
                }
                else if(d !=N-1) {
                    System.out.println(N+""+d);
                    System.out.println("矩阵格式不规范，行数与列数不相等，或者根本不是矩阵。");
                    return;
                }
                d=0;i=0;j++;
            }
        }
        for(i=0;i<N;i++)    sum+=arr[i][i];
        for(i=0,d=0;i<N;i++)    d+=arr[i][N-1-i];
        if(d!=sum){
            System.out.println("该矩阵不是魔幻矩阵。");
            return;
        }
        d=0;
        for(i=0;i<N;i++){
            for(j=0;j<N;j++) {
                d+=arr[i][j];
            }
            if(d!=sum){
                System.out.println("该矩阵不是魔幻矩阵。");
                return;
            }
            d=0;
        }
        for(i=0,d=0;i<N;i++){
            for(j=0;j<N;j++) {
                d+=arr[j][i];
            }
            if(d!=sum){
                System.out.println("该矩阵不是魔幻矩阵。");
                return;
            }
            d=0;
        }
        System.out.println("该矩阵是魔幻矩阵。");
    }
}


