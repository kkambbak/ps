package com.ll.boj.simul.p12100;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

	static List<Integer> li = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();

		repeat(board, 0);
		int max = li.stream().max(Comparator.naturalOrder()).get();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}

	private static void repeat(int[][] board, int depth) {
		if(depth == 5){
			li.add(findMax(board));
			return;
		}
		repeat(down(board), depth+1);
		repeat(up(board), depth+1);
		repeat(right(board), depth+1);
		repeat(left(board), depth+1);
	}

	private static int findMax(int[][] board) {
		return Arrays.stream(board).flatMapToInt(Arrays::stream).max().orElseThrow();
	}

	private static int[][] down(int[][] b) {
		int[][] board = copy(b);
		int n = board.length;
		for (int i = 0; i < n; i++) {
			List<Integer> li = new ArrayList<>();
			List<Integer> newLi = new ArrayList<>();
			for (int j = n-1; j >= 0; j--) {
				if(board[j][i] != 0){
					li.add(board[j][i]);
				}
			}

			// 같으면 합치기
			int idx = 0;
			while (idx < li.size()) {
				if(idx < li.size()-1 && Objects.equals(li.get(idx), li.get(idx + 1))){
					newLi.add(li.get(idx)*2);
					idx +=2;
				} else{
					newLi.add(li.get(idx));
					idx++;
				}
			}

			//board에 채우기
			for (int j = 0; j < newLi.size(); j++) {
				board[n - 1 - j][i] = newLi.get(j);
			}
			for (int j = newLi.size(); j < n; j++) {
				board[n - 1 - j][i] = 0;
			}
		}
		return board;
	}

	private static int[][] up(int[][] b) {
		int[][] board = copy(b);
		int n = board.length;
		for (int i = 0; i < n; i++) {
			List<Integer> li = new ArrayList<>();
			List<Integer> newLi = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if(board[j][i] != 0){
					li.add(board[j][i]);
				}
			}

			// 같으면 합치기
			int idx = 0;
			while (idx < li.size()) {
				if(idx < li.size()-1 && Objects.equals(li.get(idx), li.get(idx + 1))){
					newLi.add(li.get(idx)*2);
					idx +=2;
				} else{
					newLi.add(li.get(idx));
					idx++;
				}
			}

			//board에 채우기
			for (int j = 0; j < newLi.size(); j++) {
				board[j][i] = newLi.get(j);
			}
			for (int j = newLi.size(); j < n; j++) {
				board[j][i] = 0;
			}
		}
		return board;
	}

	private static int[][] right(int[][] b) {
		int[][] board = copy(b);
		int n = board.length;
		for (int i = 0; i < n; i++) {
			List<Integer> li = new ArrayList<>();
			List<Integer> newLi = new ArrayList<>();
			for (int j = n-1; j >= 0; j--) {
				if(board[i][j] != 0){
					li.add(board[i][j]);
				}
			}

			// 같으면 합치기
			int idx = 0;
			while (idx < li.size()) {
				if(idx < li.size()-1 && Objects.equals(li.get(idx), li.get(idx + 1))){
					newLi.add(li.get(idx)*2);
					idx +=2;
				} else{
					newLi.add(li.get(idx));
					idx++;
				}
			}

			//board에 채우기
			for (int j = 0; j < newLi.size(); j++) {
				board[i][n - 1 - j] = newLi.get(j);
			}
			for (int j = newLi.size(); j < n; j++) {
				board[i][n - 1 - j] = 0;
			}
		}
		return board;
	}

	private static int[][] copy(int[][] board) {
		int n = board.length;
		int[][] newBoard = new int[n][n];
		for (int i = 0; i < n; i++) {
			newBoard[i] = Arrays.copyOf(board[i], n);
		}
		return newBoard;
	}

	private static int[][] left(int[][] b) {
		int[][] board = copy(b);
		int n = board.length;
		for (int i = 0; i < n; i++) {
			List<Integer> li = new ArrayList<>();
			List<Integer> newLi = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if(board[i][j] != 0){
					li.add(board[i][j]);
				}
			}

			// 같으면 합치기
			int idx = 0;
			while (idx < li.size()) {
				if(idx < li.size()-1 && Objects.equals(li.get(idx), li.get(idx + 1))){
					newLi.add(li.get(idx)*2);
					idx +=2;
				} else{
					newLi.add(li.get(idx));
					idx++;
				}
			}

			//board에 채우기
			for (int j = 0; j < newLi.size(); j++) {
				board[i][j] = newLi.get(j);
			}
			for (int j = newLi.size(); j < n; j++) {
				board[i][j] = 0;
			}
		}
		return board;
	}

	static void print(int[][] board){
		System.out.println("----------------------");
		for (int[] i : board) {
			System.out.println(Arrays.toString(i));
		}
	}
}