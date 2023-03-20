package com.ll.level0.p120861;

public class main {
    public static void main(String[] args) {
        String[] keyinput = {"left", "right", "up", "right", "right"};
        int[] board = {11, 11};
        int[] pos = {0,0};
        for(String s: keyinput){
            if(s.equals("right")&&pos[0]+board[0]>0){
                pos[0]+=1;
            } else if (s.equals("left")&&pos[0]-board[0]<0) {
                pos[0]-=1;
            } else if (s.equals("up")&&pos[1]+board[1]>0) {
                pos[1]+=1;
            } else if (s.equals("down")&&pos[1]-board[1]<0) {
                pos[1]-=1;
            }
        }
        //return pos;
    }
}
