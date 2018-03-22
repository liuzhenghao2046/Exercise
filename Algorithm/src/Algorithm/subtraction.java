package Algorithm;
import java.util.Scanner;
import java.util.ArrayList;  
import java.util.Iterator; 
/**
 * 描述:给出一个整数（负数使用其绝对值），输出这个整数中的两种递减数
 * （1.最大递减数；2.递减数中各位数之和最大的数）之和。
 * 
*递减数：一个数字的递减数是指相邻的数位从大到小排列的数字，不包含相邻的数位大小相同的情况。
*最大递减数：所输入整数的所有递减数中值最大的一个。如： 75345323，递减数有：75,753,53,53,532,32。那么最大的递减数为753。
 
各位数字之和最大的递减数: 如75345323中的各递减数：75各位数之和=12(7+5=12),
753各位数之和=15(7+5+3=15),
53各位数之和=8(5+3=8),
532各位数之和=10(5+3+2=10),
32各位数之和=5(3+2=5)。
那么各位数字之和最大的递减数为753。
 
输出结果=最大递减数+各位数之和最大的递减数。(1506=753+753)
运行时间限制:        无限制
内存限制:        无限制
输入:        一个int型整数。如：75345323
输出:        一个int型整数。如：1506
样例输入:        75345323
样例输出:        1506
 * @author zhenghao liu
 *
 */
public class subtraction {
	public static void main(String[] args)  
    {  
        Scanner scan =new Scanner(System.in);  
        String str =scan.nextLine();  
        diJianShu(str);  
              
    }  
    static void diJianShu(String str)  
    {  
        char[] arr=str.toCharArray();  
        ArrayList<Integer> la=new ArrayList<Integer>();     //用来存放递减数  
        for(int i=0;i<arr.length-1;i++)      //寻找递减数  
        {  
            if(arr[i]>arr[i+1])  
            {  
                String s=""+arr[i]+arr[i+1];  
                la.add(Integer.parseInt(s));  
                for(int j=i+1;j<arr.length-2;j++)  
                {  
                    if(arr[j]>arr[j+1])  
                        {  
                        s=s+arr[j+1];  
                        la.add(Integer.parseInt(s));  
                        break;             //防止角标继续往下比  
                        }  
                    break;                //防止角标继续往下比  
                }  
                s=null;  
            }     
        }  
//      Iterator<Integer> it=la.iterator();  
//      while(it.hasNext()){  
//          System.out.print(it.next()+" ");  
//      }  
        String[] a=new String[la.size()];//将集合里的元素转化成字符串，再转化成字符数组，方便下面求递减数各位数之和  
        int max=0;                      //记录最大递减数  
        for(int i=0;i<la.size();i++)  
        {  
            if(la.get(i)>max)  
            {  
                max=la.get(i);            //找到最大递减数  
            }  
            a[i]=la.get(i).toString();   // 将集合里的元素转化成字符串  
        }  
        String ss=null;  
        int max2=0;                     //记录最大递减数之和  
        for(String string :a)  
        {                               //字符串转化为字符数组，方便下面求递减数各位数之和  
            if(string!=null)  
            {  
                char[] ch=string.toCharArray();  
                int num=0;  
                for(int i=0;i<ch.length;i++)  
                {  
                    num=num+ch[i]-48;  
                }  
                if(num>max2)  
                {  
                    max2=num;           //找到最大递减数之和  
                    ss=string;         //记录下最大递减数之和的字符串；  
                }  
            }   
              
        }  
        int sum=max+Integer.parseInt(ss);  
        System.out.println(sum);      
    }  
}  


