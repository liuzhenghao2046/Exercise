package Algorithm;

public class BubbleSort {
	public static void main(String[] args){
		int [] array = {0, 4, 24, 1, 3, 15};
		BubbleSort sorter = new BubbleSort();
		sorter.sort(array);
	}

	public void sort(int[] array) {
		// TODO Auto-generated method stub
		for(int i = 1 ; i < array.length; i ++){
			for(int j = 1; j < array.length - i; j++ ){
				if(array[j] > array[j+1]){ //比较大小
					int temp = array[j];  //将第一个元素值放到临时变量里面去
					array[j] = array[j+1];//将第二个元素值放到第一个元素值单元中去
					array[j+1] = temp; //将临时变量也就是第一个元素值放到第二个元素中，形成换位
				}
			}
		}
		
		ShowArray(array);//输出冒泡排序中数组所有元素
		
	}
	public void ShowArray(int[]array){
		for(int i : array){//foreach格式遍历数组
			System.out.print(i +";" );//输出每个数组的元素值
			
		}
	}

}
