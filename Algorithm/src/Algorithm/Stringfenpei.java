package Algorithm;
import java.util.*;
/**
 * 问题描述 
1，输入M个字符串，按指定长度N拆分每个字符串，输出新的字符串，长度不是N的整数倍的字符串请在后面补数字0 
2，格式如下： 
输入：输入整数M，N，以逗号隔开
每行一个字符串，共M个字符串，每行字符串小于50个字符
输出：按指定长度N拆分字符串，输出拆分后的字符串
输入：

2,8

abc

123456789
输出：

abc00000

12345678

90000000
 * @author zhenghao liu
 *
 */

public class Stringfenpei {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int M,N;
		String []str1;
        String []str2;
        String s;
        s=scan.nextLine();
        str1=s.split(",");  //去掉逗号
        M=Integer.valueOf(str1[0]);  //M表示字符串个数
        N=Integer.valueOf(str1[1]); //N表示指定长度
        str2=new String[M];
        for(int i=0;i<M;i++)
        {
            str2[i]=scan.nextLine();  //输入字符串
        }
        for(int i=0;i<M;i++)
        {
            if(str2[i].length()<N)
            {
                StringBuffer sb=new StringBuffer();
                sb.append(str2[i]);
                int n=N-str2[i].length();
                for(int j=0;j<n;j++)
                {
                    sb.append(0);//长度不足N的在后面添加0
                }

                System.out.println(sb.toString());
            }
            else
            {
                int a=str2[i].length()/N;  //取整数
                int b=str2[i].length()%N;  //取余数
                int c=N-b;

                if(b==0)//当余数为0时
                {
                    for (int j = 0; j < a; j++) {
                        StringBuffer sb=new StringBuffer();
                        sb.append(str2[i].substring(j*N,(j+1)*N));
                        System.out.println(sb.toString());
                    }
                }
                else  //当余数不为0时
                {
                    for (int j = 0; j < a; j++) {
                        StringBuffer sb=new StringBuffer();
                        sb.append(str2[i].substring(j*N,(j+1)*N));
                        System.out.println(sb.toString());
                    }
                    StringBuffer sb=new StringBuffer();
                    sb.append(str2[i].substring(a*N,str2[i].length()));
                    for(int j=0;j<c;j++)
                    {
                        sb.append(0);
                    }
                    System.out.println(sb.toString());
                }
            }
        }
    }
}
	


