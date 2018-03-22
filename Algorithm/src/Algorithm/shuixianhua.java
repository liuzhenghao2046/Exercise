package Algorithm;
/**
 * 
题目描述：水仙花数是指一个n位数（n≥3）,它的每个位上的数字的n次幂之和等于它本身。
（例如：1³+5³+3³=153），要求：输出1000范围内所有水仙花数及水仙花数之和。

输入描述：无

输出描述：1000以内所有水仙花数及总和。

输出例子：

第1个水仙花数：xxx

第2个水仙花数：xxx

第3个水仙花数：xxx

...

水仙花数总和为：xxx
 * @author zhenghao liu
 *
 */
public class shuixianhua {
	public static void main(String[] args){
		int count = 0;
		int sum = 100 ;
		for(int i = 100; i<1000; i++){
			 if(judge(i))  
	            {  
	                System.out.println("第"+(++count)+"个水仙花数："+i);  
	                sum=sum+i;  
	            }         
	        }  
	        System.out.println("水仙花数总和为："+sum);  
		}
		public static boolean judge(int x){
			int cpx = x;
			int n =("" + x).length();		//将数字转化为字符串，方便计算数字的长度
			int s =0;
			while(x>0){		//注意while和if不能混淆使用，if只计算1次，while不满足条件才跳出循环
				int m=x%10;               //取余：获取末位数  
	            s+=(int)Math.pow(m, n);  //Math.pow是double类型的，需要进行类型转换，转换成int类型  
	            x=x/10;                 //丢掉末位数        
			}
			return cpx == x;
	}

	
}
