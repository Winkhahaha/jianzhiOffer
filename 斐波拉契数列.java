package 剑指金钱;

public class 斐波拉契数列 {

	public static void main(String[] args) {
		System.out.println(Fibonacci(3));
	}
	/*
	 * 输入一个整数n，请你输出斐波那契数列的第n项
	 */
	public static int Fibonacci(int n) {
		if(n==1||n==2) {
			return 1;
		}
		if(n > 2) {
			return Fibonacci(n-1)+Fibonacci(n-2);
		}
		return -1;

    }
}
