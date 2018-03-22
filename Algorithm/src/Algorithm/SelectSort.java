package Algorithm;

public class SelectSort {
	public static void main(String[] args){
		int[] array = {3,17,5,9,63,24};
		SelectSort sorter = new SelectSort();
		sorter.sort(array);
	}
	public void sort(int[]array){
		int index;
		for(int i =1; i< array.length; i++){
			index = 0;
			for(int j =1; j< array.length -i; j++){
				if(array[j] > array[index]){
					index = j;
				}
			}
			int temp = array[array.length - i];//把第一个元素值放到临时变量中去
			array[array.length - i] = array[index];//把第二个元素值保存到第一个元素单元中去
			array[index] = temp;//把临时变量也就是第一个元素值保持到第二个元素中去
		}
		showArray(array);//输出排序后的数组值
	}
	public void showArray(int[] array){
		for(int i : array){
			System.out.print(i + ";");
		}
	}
	
}
