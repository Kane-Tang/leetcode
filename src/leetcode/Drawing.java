package leetcode;

import java.util.Scanner;

public class Drawing {
	public static void main(String[] args) {
//		画家小Q又开始他的艺术创作。小Q拿出了一块有NxM像素格的画板, 画板初始状态是空白的,用'X'表示。
//		小Q有他独特的绘画技巧,每次小Q会选择一条斜线, 如果斜线的方向形如'/',即斜率为1,小Q会选择这条斜线中的一段格子,都涂画为蓝色,用'B'表示;如果对角线的方向形如'\',即斜率为-1,小Q会选择这条斜线中的一段格子,都涂画为黄色,用'Y'表示。
//		如果一个格子既被蓝色涂画过又被黄色涂画过,那么这个格子就会变成绿色,用'G'表示。
//		小Q已经有想画出的作品的样子, 请你帮他计算一下他最少需要多少次操作完成这幅画。
		Scanner scanner = new Scanner(System.in);
		String tem = scanner.nextLine();
		int n = Integer.valueOf(tem.split(" ")[0]);
		int m = Integer.valueOf(tem.split(" ")[1]);
		char color[][] = new char[n][m];
		for (int i = 0; i < n; i++) {
			tem = scanner.nextLine();
			for (int j = 0; j < tem.length(); j++) {
				color[i][j] = tem.charAt(j);
			}
		}

		//get the least steps
		getMinStep(n, m, color);

		scanner.close();

	}

	/**
	 *
	 * @param n
	 * @param m
	 * @param color
	 */
	private static void getMinStep(int n, int m, char color[][]) {

		int step = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (color[i][j] == 'Y') {
					dfs_y(i, j, n, m, color); // draw y
					step++;
				} else if (color[i][j] == 'B') {
					dfs_b(i, j, n, m, color); // draw b
					step++;
				} else if (color[i][j] == 'G') {
					dfs_y(i, j, n, m, color); // draw y first
					step++;
					dfs_b(i, j, n, m, color); // then draw b
					step++;
				}
			}
		}

		System.out.println(step);
	}

	/**
	 *
	 * @param x
	 * @param y
	 */
	private static void dfs_y(int x, int y, int n, int m, char color[][]) {
		if (x >= 0 && x < n && y >= 0 && y < m && (color[x][y] == 'Y' || color[x][y] == 'G')) {
			if (color[x][y] == 'G') {
				color[x][y] = 'B'; 
			} else {
				color[x][y] = 'X'; 
			}

			dfs_y(x - 1, y - 1, n, m, color);
			dfs_y(x + 1, y + 1, n, m, color);

		}

	}

	/**
	 *
	 * @param x
	 * @param y
	 */
	private static void dfs_b(int x, int y, int n, int m, char color[][]) {
		if (x >= 0 && x < n && y >= 0 && y < m && (color[x][y] == 'B' || color[x][y] == 'G')) {
			if (color[x][y] == 'G') {
				color[x][y] = 'Y'; 
			} else {
				color[x][y] = 'X'; 
			}
			dfs_b(x + 1, y - 1, n, m, color);
			dfs_b(x - 1, y + 1, n, m, color);

		}
	}
}
