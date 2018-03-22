package Algorithm;
import java.util.*;
/**
 * 当出差遇上大雾
给定距离矩阵，大雾城市（既不能到达，也不能离开），目的地，输出最短路径和路径.
迪杰斯特拉结合path数组记录路径，path在迪杰斯特拉更新dis距离数组时更新.
大雾城市就是将距离矩阵变为1000
无法到达输出-1
 * @author zhenghao liu
 *
 */
public class chuchaidawu {
	private static int [][]s=new int[6][6];  
	   public static void init(){  
	     s[0][0]=0;  
	     s[0][1]=2;  
	     s[0][2]=10;  
	     s[0][3]=5;  
	     s[0][4]=3;  
	     s[0][5]=1000;  
	     s[1][0]=1000;  
	     s[1][1]=0;  
	     s[1][2]=12;  
	     s[1][3]=1000;  
	     s[1][4]=1000;  
	     s[1][5]=10;  
	     s[2][0]=1000;  
	     s[2][1]=1000;  
	     s[2][2]=0;  
	     s[2][3]=1000;  
	     s[2][4]=7;  
	     s[2][5]=1000;  
	     s[3][0]=2;  
	     s[3][1]=1000;  
	     s[3][2]=1000;  
	     s[3][3]=0;  
	     s[3][4]=2;  
	     s[3][5]=1000;  
	     s[4][0]=4;  
	     s[4][1]=1000;  
	     s[4][2]=1000;  
	     s[4][3]=1;  
	     s[4][4]=0;  
	     s[4][5]=1000;  
	     s[5][0]=3;  
	     s[5][1]=1000;  
	     s[5][2]=1;  
	     s[5][3]=1000;  
	     s[5][4]=2;  
	     s[5][5]=0;  
	   }  
	   public static void main(String[] args) {  
	    Scanner cin=new Scanner(System.in);  
	    while(cin.hasNextInt()){  
	        init();  
	        int end=cin.nextInt();//终点城市  
	        int a=cin.nextInt();//大雾城市  
	        if (a!=0){//处理距离矩阵  
	         for (int i=0;i<6;i++)  
	          s[i][a-1]=1000;  
	         for (int i=0;i<6;i++)  
	          s[a-1][i]=1000;  
	        }  
	        int dis[]=new int[6];  
	        for (int i=0;i<6;i++)  
	        dis[i]=s[0][i];  
	        int book[]=new int[6];  
	        book[0]=1;  
	        int k=-1;  
	        int path[]=new int[6];  
	        path[0]=-1;  
	        for (int i=1;i<6;i++)  
	            if (dis[i]==1000)  
	                path[i]=-1;  
	            else  
	                path[i]=0;  
	        for (int i=0;i<5;i++){  
	            int min=1000;  
	            for (int j=0;j<6;j++){  
	                if ((book[j]==0)&&min>dis[j]&&dis[j]!=1000){  
	                    min=dis[j];  
	                    k=j;  
	                }  
	            }  
	         book[k]=1;  
	         if (k!=-1){  
	                for (int j=0;j<6;j++)  
	                    if (dis[j]>dis[k]+s[k][j]){  
	                        dis[j]=dis[k]+s[k][j];  
	                        path[j]=k;  
	                    }  
	            }  
	          
	        }  
	        if (dis[end-1]==1000){  
	            System.out.println(1000);  
	            System.out.println("[]");  
	            continue;  
	        }  
	        else{  
	            System.out.println(dis[end-1]);  
	            k=end-1;  
	            int temp[]=new int[6];  
	            int num=0;  
	            while(k!=-1){  
	                temp[num++]=k;  
	                k=path[k];  
	            }  
	            System.out.print("[");  
	            for (int i=num-1;i>=1;i--)  
	                System.out.print(temp[i]+1+" ");  
	            System.out.print(temp[0]+1+"]");  
	            System.out.println();  
	        }  
	    }  
	    cin.close();  
	}  

}
