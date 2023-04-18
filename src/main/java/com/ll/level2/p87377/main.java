package com.ll.level2.p87377;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        new Solution().solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}});
    }
}
class Solution {
    public String[] solution(int[][] line) {
        long xMax = Long.MIN_VALUE;
        long xMin = Long.MAX_VALUE;
        long yMax = Long.MIN_VALUE;
        long yMin = Long.MAX_VALUE;

        Points points = new Points(new ArrayList<>());

        //교점구하기
        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
                long[] xy = CalXY(line[i], line[j]);
                if(xy[0]!= Long.MAX_VALUE){
                    xMax = Math.max(xMax,xy[0]);
                    xMin = Math.min(xMin,xy[0]);
                    yMax = Math.max(yMax,xy[1]);
                    yMin = Math.min(yMin,xy[1]);

                    points.add(xy);
                }
            }
        }
        points.convertToMatrix(xMin,yMax);

        //좌표계 만들기
        long xGap = xMax - xMin;
        long yGap = yMax - yMin;

        char[][] stars = new char[(int)yGap+1][(int)xGap+1];
        for (int i = 0; i <= yGap; i++) {
            Arrays.fill(stars[i],'.');
        }

        for (int i = 0; i < points.size(); i++) {
            stars[ points.getY(i) ][ points.getX(i) ] = '*';
        }

        String[] answer = new String[(int)yGap+1];
        //별그리기
        for (int i = 0; i <= (int)yGap; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= (int)xGap; j++) {
                sb.append(stars[i][j]);
            }
            answer[i] = sb.toString();
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
    private long[] CalXY(int[] s1, int[]s2){
        long divideBy = ((long)s1[0]*(long)s2[1] - (long)s1[1]*(long)s2[0]);
        if (divideBy == 0) return new long[]{Long.MAX_VALUE,Long.MAX_VALUE};

        long xBoonja = (long)s1[1]*(long)s2[2]- (long)s1[2]*(long)s2[1];
        long yBoonja = (long)s1[2]*(long)s2[0] - (long)s1[0]*(long)s2[2];

        long x = xBoonja / divideBy;
        long y = yBoonja / divideBy;

        if(xBoonja % divideBy == 0 && yBoonja%divideBy == 0){
            return new long[]{x, y};
        }
        return new long[]{Long.MAX_VALUE,Long.MAX_VALUE};
    }

    private class Points {
        private List<long[]> points;
        public Points(List<long[]> points) {
            this.points = points;
        }

        private void add(long[] point) {
            points.add(point);
        }

        private void convertToMatrix(long finalXMin, long finalYMax) {
            points = points.stream().map(i -> new long[]{i[0]- finalXMin, finalYMax-i[1]}).collect(Collectors.toList());
        }

        private int size() {
            return points.size();
        }

        private long[] get(int i) {
            return points.get(i);
        }

        private int getY(int i) {
            return (int)points.get(i)[1];
        }

        public int getX(int i) {
            return (int)points.get(i)[0];
        }
    }
}