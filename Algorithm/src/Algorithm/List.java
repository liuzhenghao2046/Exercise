package Algorithm;
//输入字符串，打印出该字符串中字符的所有排列
//例如输入数组【123】，输出：123,132,213,231,321
import java.util.Scanner;

public class List {
	public static void main(String[]args){
		String str = "";
		Scanner scan = new Scanner(System.in);
		str = scan.nextLine();
		permutation(str.toCharArray(),0);
	}
	
	public static void permutation(char[]str, int i){
		if(i >= str.length)
			return;
		if(i == str.length -1){
			System.out.println(String.valueOf(str));
		}else{
			for(int j = i; j< str.length; j++){
				char temp = str[j];
				str[j] = str[i];
				str[i] = temp;
				
				permutation(str, i + 1);
				
				temp = str[j];
				str[j] = str[i];
				str[i] = temp;
			}
		}
	}

}
