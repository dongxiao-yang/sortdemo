package com.youku.data.sortdemo;

public class LCString {
	public static int lengthofLCString(String X, String Y) {
		/*
		 * 构造二维数组c[][]记录X[i]和Y[j]的LCS长度 (i,j)是前缀 c[i][j]=0; 当 i = j = 0;
		 * c[i][j]=c[i-1][j-1]+1; 当 i = j > 0; Xi == Y[i] c[i][j]=0; 当 i = j >
		 * 0; Xi != Y[i] 需要计算 m*n 个子问题的长度 即 任意c[i][j]的长度 -- 填表过程
		 */
		int[][] c = new int[X.length() + 1][Y.length() + 1];
		int maxlen = 0;
		int maxindex = 0;
		for (int i = 1; i <= X.length(); i++) {
			for (int j = 1; j <= Y.length(); j++) {
				if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					c[i][j] = c[i - 1][j - 1] + 1;
					if (c[i][j] > maxlen) {
						maxlen = c[i][j];
						maxindex = i + 1 - maxlen;
					}
				}
			}
		}
		
		
	     for(int i=0;i<=X.length();i++){
	           for (int j=0;j<=Y.length();j++){
	              // System.out.print("["+i+"]"+"["+j+"]"+" "+c[i][j]+" ");
	               System.out.print(c[i][j]+" ");
	           }
	           System.out.println();
	       }
		return maxlen;
	}

	public static void main(String[] args) {
		String X = "acbac";
		String Y = "acaccbabb";
		System.out.println(lengthofLCString(X, Y));
	}
}
