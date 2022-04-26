package P1;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class MagicSquare {
    public static void main(String args[])throws IOException {
        try(Scanner scan =new Scanner(System.in)){
            int n = scan.nextInt();
            generateMagicSquare(n);
        }
        catch (InputMismatchException e){
            System.out.println("输入数据不合法。");
            return;
        }
        String fileName = "src\\P1\\txt\\6.txt";
       isMagicSquare(fileName);
    }
    public static void isMagicSquare(String fileName)throws IOException{
        int i=0,j=-1,sum=0,d=0,N=0;
        try (Scanner sc = new Scanner(new FileReader(fileName))){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                N++;
            }
        }
        int arr[][] =new int[N][N]; String s[];
        System.out.println(N+"a");
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while(sc.hasNextLine()) {
                i=0;j++;
                String line = sc.nextLine();
                s=line.split("\t");
                if(s.length!=N){
                    System.out.println("矩阵格式不规范，行数与列数不相等，或者相邻元素未用制表符隔开（比如用空格隔开）。");
                    return;
                }
                while(i<N){
                    for(d=0;d<s[i].length();d++){
                        char ch = s[i].charAt(d);
                        if(ch<'0'||ch>'9'){
                            System.out.println("矩阵格式不规范，除正整数与制表符、换行符外有其他内容（如正负号）。");
                            return;
                        }
                    }
                    arr[j][i]=Integer.valueOf(s[i]);
                    // System.out.println(arr[j][i]);
                    i++;
                }
            }
            if(i!=N){
                System.out.println("矩阵格式不规范，行数与列数不相等。");
                return;
            }
        }
        for(i=0;i<N;i++)    sum+=arr[i][i];
        for(i=0,d=0;i<N;i++)    d+=arr[i][N-1-i];
        if(d!=sum){
            System.out.println("该矩阵不是魔幻矩阵1。");
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
    public static boolean generateMagicSquare(int n) throws IOException {
        if(n<0||n%2==0){
            System.out.println("输入数据不合法，必须是正奇数才可以。");
            return false;
        }
        int magic[][] = new int[n][n];                      //创建magic二维数组，用于储存magic矩阵
        int row = 0, col = n / 2, i, j, square = n * n;     //根据输入的n来设定常量
        for (i = 1; i <= square; i++) {                     //逐次生成magic矩阵里的所有数值
            magic[row][col] = i;                            //从第0行的中间位置开始生成，从1开始，后一个生成的值比前一个大1
            if (i % n == 0) {                             //生成好相当于一行数目的值之后就在下一行开始赋值，以免重复赋值
                row++;
            }
            else {
                if (row == 0) row = n - 1;                  //如果row对应第一行，就跳转为最后一行
                else    row--;                              //而如果不是，就将row-1，上移一行
                if (col == (n - 1))                         //对于col同理，只不过增减方向相反
                col = 0;
                else    col++;
            } }
        try(FileWriter filewriter = new FileWriter("src\\P1\\txt\\6.txt")){
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++)
                    filewriter.write(magic[i][j] + "\t");
                filewriter.write("\n");
            }
        }

        return true;
    }
}
