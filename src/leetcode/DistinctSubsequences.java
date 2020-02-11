package leetcode;

public class DistinctSubsequences {

	public DistinctSubsequences() {
		// TODO Auto-generated constructor stub
	}
	public int numDistinct(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        int[][] mem = new int[l1+1][l2+1];
        for(int i=0;i<=l2;i++) {//when s=""
        	mem[0][i] = 0;
        }
        
        for(int i=0;i<=l1;i++) {//when t=""
        	mem[i][0] = 1;
        }
        
        for(int j=0;j<l2;j++) {
        	for(int i=0;i<l1;i++) {
        		if(s.charAt(i) == t.charAt(j)) {
        			mem[i+1][j+1] = mem[i][j] + mem[i][j+1];
        		}else {
        			mem[i+1][j+1] = mem[i][j+1];
        		}
        	}
        }
        
        return mem[l1][l2];
	}
}
