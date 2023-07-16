import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int[][] array = new int[n][n];
            for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					array[i][j] = sc.nextInt();
				}
			}
            String[][] result = new String[n][3];
        	int[][] turnArray = new int[n][3];
            for (int i = 0; i < 3; i++) {
            	if (i == 0) {
            		turnArray = turn(array, n);	
				}else {
					turnArray = turn(turnArray, n);
				}
				for (int j = 0; j < n; j++) {
					result[j][i] = strArray(turnArray[j], n);
				}
			}
            System.out.println("#"+test_case);
            for (int i = 0; i < result.length; i++) {
            	StringBuilder sb = new StringBuilder();
				for (int j = 0; j < result[0].length; j++) {
					sb.append(result[i][j] + " ");
				}
				System.out.println(sb.toString().trim());
			}
             
		}
	}
	
	static int[][] turn(int[][] array, int n){
    	int[][] temp = new int[n][n];
    	for (int i = 0; i < n; i++) {
    		int idx = 0;
			for (int j = n -1 ; j >= 0; j--) {
				temp[i][idx++] = array[j][i]; 
			}
		}
    	return temp;
	}
	
	static String strArray(int[] array, int n) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
		}
		return sb.toString();
	}
}