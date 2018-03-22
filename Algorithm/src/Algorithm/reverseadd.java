package Algorithm;
import java.util.Scanner; 
/**
 题目1:
   编写一个reverseadd函数，实现两个数倒置后再求和的功能，比如输入123，456就是求321+654，输出975
   注意输入100,200输出3,（自动去除开头的0）,超过范围输出-1
   思路：
   输入数据带空格，先切割出整数，然后用stringbuidler翻转，转成数字自动去除0，求和，全程自带的函数.
 * @author zhenghao liu
 *
 */
public class reverseadd {
	 public static int reversedAdd(int a,int b){  
	      if ((a<1)||(a>700000)||(b<1)||(b>700000))  
	          return -1;  
	      String A=Integer.toString(a);  
	      String B=Integer.toString(b);  
	      StringBuilder c=new StringBuilder(A);  
	      StringBuilder d=new StringBuilder(B);  
	      c=c.reverse();  
	      d=d.reverse();  
	      int e=Integer.valueOf(c.toString());  
	      int f=Integer.valueOf(d.toString());  
	      return e+f;  
	  }  
	  public static void main(String[] args) {  
	        Scanner cin=new Scanner(System.in);  
	        while(cin.hasNext()){  
	            String s=cin.next();  
	            String c[]=s.split(",");  
	            //System.out.println(c[0]);  
	            System.out.println(reversedAdd(Integer.valueOf(c[0]),Integer.valueOf(c[1])));  
	        }  
	        cin.close();  
	    }  
	}  

	


