package leetcode;

public class TicTacToe {

	/** Initialize your data structure here. */
	private int[][] map;
    public TicTacToe(int n) {
        map = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        map[row][col] = player;
        if(win(player)) {
        	return player;
        }else {
        	return 0;
        }
    }
    
    public boolean win(int player) {
    	//check map
    	
    	//check each row
    	boolean flag = true;
    	for(int i=0;i<map.length;i++) {
    		flag = true;
    		for(int j=0;j<map[0].length;j++) {
    			if(map[i][j] != player) {
    				flag = false;
    				break;
    			}
    		}
    		if(flag == true) {
    			break;
    		}
    	}
    	if(flag == true) {
    		return true;
    	}
    	
    	//check each column
    	for(int j=0;j<map[0].length;j++) {
    		flag = true;
    		for(int i=0;i<map.length;i++) {
    			if(map[i][j] != player) {
    				flag = false;
    				break;
    			}
    		}
    		if(flag == true) {
    			break;
    		}
    	}
    	if(flag == true) {
    		return true;
    	}
    	
    	//check by diagonal
    	int i=0;
    	int j=0;
    	flag = true;
    	while(i<map.length && j<map[0].length) {
    		if(map[i][j]!=player) {
    			flag = false;
    			break;
    		}
    		i++;
    		j++;
    	}
    	if(flag == true) {
    		return true;
    	}
    	
    	i=map.length-1;
    	j=0;
    	flag = true;
    	while(i>=0 && j<map[0].length) {
    		if(map[i][j] != player) {
    			flag = false;
    			break;
    		}
    		i--;
    		j++;
    	}
    	if(flag == true) {
    		return true;
    	}
    	return false;
    }
}
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */