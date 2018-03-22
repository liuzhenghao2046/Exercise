package Algorithm;
import java.util.*;
/**
 * 掷骰子，初始序列1,2,3,4,5,6分别代表左，右，前，后，上，下
输入翻转序列，保证只包含L,R,F,B,A,C
L:向左翻转
R:向右翻转
F:向前翻转
B:向后翻转
A:逆时针翻转
C:顺时针翻转
输出最终序列
比如
输入
LA
输出
435621
思路直接开数组模拟，只需要模拟前，左，顺时针三个状态，其他的由这些翻转3次得到.
 * @author zhenghao liu
 *
 */
public class shaizi {
	private static int  state[]={1,2,3,4,5,6};  
    public static void left(){//向左旋转  
        int temp1=state[0];  
        int temp2=state[1];  
        state[0]=state[4];  
        state[1]=state[5];  
        state[4]=temp2;  
        state[5]=temp1;  
    }  
    public static void right(){//向右旋转  
        int temp1=state[0];  
        int temp2=state[1];  
        state[0]=state[5];  
        state[1]=state[4];  
        state[4]=temp1;  
        state[5]=temp2;  
   }  
    public static void f(){//向前翻转  
        int temp1=state[2];  
        int temp2=state[3];  
        state[2]=state[4];  
        state[3]=state[5];  
        state[5]=temp1;  
        state[4]=temp2;  
    }  
    public static void c(){//顺时针旋转  
        int temp1=state[0];  
        int temp2=state[1];  
        state[0]=state[2];  
        state[1]=state[3];  
        state[2]=temp2;  
        state[3]=temp1;  
    }  
    public static void  cal(char s[]){  
        for (int i=0;i<s.length;i++){  
            if (s[i]=='L'){  
                left();  
            }  
            if (s[i]=='R'){  
                right();  
            }  
            if (s[i]=='F'){  
                f();  
            }  
            if (s[i]=='B'){  
                f();  
                f();  
                f();  
            }  
            if (s[i]=='A'){  
                c();  
                c();  
                c();  
            }  
            if (s[i]=='C'){  
                c();  
            }  
        }  
    }  
  public static void main(String[] args) {  
    Scanner cin=new Scanner(System.in);  
    while(cin.hasNext()){  
        state[0]=1;  
        state[1]=2;  
        state[2]=3;  
        state[3]=4;  
        state[4]=5;  
        state[5]=6;  
        String s=cin.next();  
        char c[]=s.toCharArray();  
        cal(c);  
        for (int i=0;i<6;i++)  
        System.out.print(state[i]);  
        System.out.println();  
    }  
    cin.close();  
  }  
}
