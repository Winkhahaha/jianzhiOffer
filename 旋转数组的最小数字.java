package 剑指金钱;

public class 旋转数组的最小数字 {

	public static void main(String[] args) {
		int[] arr = {-1,1,2,3};
		System.out.println(minNumberInRotateArray(arr));

	}
	
	/*
	 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
	输入一个非递减(递增)排序的数组的一个旋转，输出旋转数组的最小元素。
	例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
	NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
	说白了就是找数组最小值.......弄得花里胡哨的
	 */
	
	 public static int minNumberInRotateArray(int [] array) {
		 if(array.length == 0) {
			 return 0;
		 }
		 int min = array[0];
		 for (int i = 1; i < array.length; i++) {
			if(array[i]<min) {
				min=array[i];
			}
		}
		return min;
		    
	    }

}
