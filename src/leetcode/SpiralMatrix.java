package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList();
		int rows = matrix.length;
		if(rows==0) {
			return list;
		}
		int columns = matrix[0].length;
		int i = 0;
		int j = 0;
		boolean[][] seen = new boolean[rows][columns];
		int direction = 0;//right
		//1 left
		//2 up
		//3 down
		while (i < rows && j < columns) {
			list.add(matrix[i][j]);
			seen[i][j] = true;
			if(direction ==0) {
				if (j + 1 >= columns || seen[i][j + 1] == true) {
					direction = 3;
					if(i+1>=rows || seen[i+1][j] == true) {
						break;
					}
				}
			}
			if(direction == 1) {
				if (j - 1 < 0 || seen[i][j - 1] == true) {
					direction = 2;
					if(i-1<0 || seen[i-1][j] == true) {
						break;
					}
				}
			}
			if(direction == 2) {
				if(i-1<0 || seen[i-1][j] == true) {
					direction = 0;
					if (j + 1 >= columns || seen[i][j + 1] == true) {
						break;
					}
				}
			}
			if(direction ==3) {
				if(i+1>=rows || seen[i+1][j] == true) {
					direction = 1;
					if (j - 1 < 0 || seen[i][j - 1] == true) {
						break;
					}
				}
			}
			if(direction == 0) {
				j++;
			}else if(direction == 1) {
				j--;
			}else if(direction == 2) {
				i--;
			}else {
				i++;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> list = sm.spiralOrder(matrix);
		int length = list.size();
		for (int i = 0; i < length; i++) {
			System.out.println(list.get(i));
		}
	}
}
