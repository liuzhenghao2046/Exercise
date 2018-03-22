package Algorithm;
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.HashSet;  
import java.util.Scanner;  
import java.util.Set;
/**
 * 题目描述：小明负责公司年会，想出一个趣味游戏：屏幕给出1~9中任意3个不重复的数字，大家以最快时间给出这几个数字可拼成的数字从小到大排列位于第N位置的数字，其中N为给出的数字中最大的（如果不到这么多个数字则给出最后一个即可），谁最快给出谁得奖。

注意：

（1）屏幕如果给出的是“2”，大家可把它当作“2”，也可把它当作“5”来拼接数字；同理，如果屏幕给的是“5”，大家可把它当作“5”，也可以把它当作“2”来拼接数字，但屏幕不能同时给出“2”和“5”。

（2）屏幕如果给出的是“6”，大家可把它当作“6”，也可把它当作“9”来拼接数字；同理，如果屏幕给的是“9”，大家可把它当作“9”，也可以把它当作“6”来拼接数字，但屏幕不能同时给出“6”和“9”。

现在需要编写一个小程序，根据给出的数字计算出能组合的所有2数字以及最终的正确答案。

如：给出：1，4，8，则可以拼成的数字为：

1，4，8，14，18，41，48，81，84，148，184，418，481，814，841

那么最第N（即8）个的数字为81.

输入描述：以逗号为分隔，描述3个int类型整数的字符串。

输出描述：这几个数字可拼成的数字从小到大排列位于第N（N为输入数字中最大的数字）位置的数字，如果输入的数字为负数或者不是合法的字符串或者有重复，返回-1。

输入例子：1，4，8

输出例子：81
 * @author zhenghao liu
 *
 */
public class quanpailie {
	 public static void addThreeNumbers(ArrayList<Integer> lst, int a, int b, int c) {  
	        lst.add(a);  
	        lst.add(b);  
	        lst.add(c);  
	        lst.add(a * 10 + b);  
	        lst.add(a * 10 + c);  
	        lst.add(b * 10 + a);  
	        lst.add(b * 10 + c);  
	        lst.add(c * 10 + a);  
	        lst.add(c * 10 + b);  
	          
	        lst.add(a * 100 + b * 10 + c);  
	        lst.add(a * 100 + c * 10 + b);  
	        lst.add(b * 100 + a * 10 + c);  
	        lst.add(b * 100 + c * 10 + a);  
	        lst.add(c * 100 + b * 10 + a);  
	        lst.add(c * 100 + a * 10 + b);  
	    }  
	      
	    public static void remove(ArrayList<Integer> lst) {     //去除重复数字  
	        Set<Integer> set = new HashSet<Integer>();  
	        for(Integer x : lst)  
	            set.add(x);  
	        lst.removeAll(lst);  
	        for(Integer x : set)  
	            lst.add(x);  
	    }  
	      
	    public static boolean check(String line) {        //判断输入的字符是否为合法的字符：只能为数字和，  
	        for(int i = 0; i < line.length(); i++) {  
	            char ch = line.charAt(i);  
	            if(!(Character.isDigit(ch) || ch == ','))  
	                return false;  
	        }  
	        return true;  
	    }  
	      
	    public static void main(String[] args) {  
	        Scanner scan = new Scanner(System.in);  
	          
	        String line = scan.nextLine();  
	        String[] numbers = line.split(",");  
	        if(!check(line) || numbers.length != 3) {  
	            System.out.println(-1);  
	            return;  
	        }  
	        int a = 0, b = 0, c = 0;  
	        try{  
	            a = Integer.parseInt(numbers[0]);  
	            b = Integer.parseInt(numbers[1]);  
	            c = Integer.parseInt(numbers[2]);  
	        } catch(Exception ex) {  
	            System.out.println(-1);  
	            return;  
	        }  
	          
	        if(a <= 0 || a > 9 || b <= 0 || b > 9 || c <= 0 || c > 9) {  
	            System.out.println(-1);  
	            return;  
	        }  
	          
	        if(a == b || a == c || b == c) {       //判断是否有相同数字的情况  
	            System.out.println(-1);  
	            return;  
	        }  
	          
	        Set<Integer> s = new HashSet<Integer>();    //判断是否有同时存在2和5、6和9的情况  
	        s.add(a); s.add(b); s.add(c);  
	        if((s.contains(2) && s.contains(5)) || (s.contains(6) && s.contains(9))) {  
	            System.out.println(-1);  
	            return;  
	        }  
//	      int m = -1;  
//	      if(s.contains(2))  
//	          m = 5;  
//	      if(s.contains(6))  
//	          m = 9;  
	          
	        int max = Math.max(a, Math.max(c, b));  
	          
	        ArrayList<Integer> lst = new ArrayList<Integer>();  
	          
	        addThreeNumbers(lst, a, b, c);          // 对2和5、6和9的转换  
	        if(a == 2 || a == 5)  
	            addThreeNumbers(lst, 7 - a, b, c);  
	        if(b == 2 || b == 5)  
	            addThreeNumbers(lst, a, 7 - b, c);  
	        if(c == 2 || c == 5)  
	            addThreeNumbers(lst, a, b, 7 - c);  
	          
	        if(a == 6 || a == 9)  
	            addThreeNumbers(lst, 15 - a, b, c);  
	        if(b == 6 || b == 9)  
	            addThreeNumbers(lst, a, 15 - b, c);  
	        if(c == 6 || c == 9)  
	            addThreeNumbers(lst, a, b, 15 - c);  
	          
	        //考虑2和6、9或者5和6、9同时存在的情况  
	        if((s.contains(2) || s.contains(5)) && (s.contains(6) || s.contains(9))) {  
	            int x = s.contains(2)? 2 : 5;  
	            int y = s.contains(6)? 6 : 9;  
	            int z = a + b + c - x - y;  
	            addThreeNumbers(lst, 7 - x, 15 - y, z);  
	        }  
	          
	        remove(lst);  
	          
	        Collections.sort(lst);  
//	      System.out.println(lst);  
	        System.out.println(lst.get(max - 1));  
	    }  
	}  


