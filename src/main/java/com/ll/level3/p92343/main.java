package com.ll.level3.p92343;

import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;

        return answer;
    }
}
class PathCalculator{
    private final int[] info;
    private final int[][] edges;
    private final boolean[][] tree;
    private Path maxSheepCountPath;

    public PathCalculator(int[] info, int[][] edges){
        this.info = info;
        this.edges = edges;

        tree = new boolean[info.length][info.length];

        for(int[] edge : edges){
            tree[edge[0]][edge[1]] = true;
            tree[edge[1]][edge[0]] = true;
        }
    }

    public Path getMaxSheepCountPath(){
        return maxSheepCountPath;
    }

    public List<Integer> getNextNodes(int currentNode){
        List<Integer> nextNodes = new ArrayList<>();

        for (int i = 0; i < tree[currentNode].length; i++){
            if (tree[currentNode][i]){
                nextNodes.add(i);
            }
        }

        return nextNodes;
    }

    public List<Integer> getNextNodes(int currentNode, List<Integer> history){
        return getNextNodes(currentNode, history, new ArrayList<>());
    }

    private List<Integer> getNextNodes(int currentNode, List<Integer> history, List<Integer> prevent) {
        prevent.add(currentNode);

        //최종데이터
        List<Integer> nextNodes = new ArrayList<>();

        List<Integer> _nextNodes = getNextNodes(currentNode);

        for(int nextNode : _nextNodes){
            if (prevent.contains(nextNode)) {
                continue;
            }
            // 이미 방문한 곳이면
            if (history.contains(nextNode)) {
                // 그곳을 기준으로 새로 탐색
                nextNodes.addAll(getNextNodes(nextNode, history, prevent));
            } else {
                // 방문할 리스트에 넣는다.
                nextNodes.add(nextNode);
            }
        }
        return nextNodes;
    }

    public Path wholePath() {
        Path path = new Path(null, 0, true);
        maxSheepCountPath = path;
        for (int nextNode : getNextNodes(0)) {
            findPath(path, nextNode);
        }
        return path;
    }

    private void findPath(Path parentPath, int node) {

        Path path = parentPath.addChildPath(node, info[node] == 0);

        if (path.getSheepCount() == 0) return;

        if (maxSheepCountPath.getSheepCount() < path.getSheepCount()) {
            maxSheepCountPath = path;
        }
        for (int nextNode : getNextNodes(node, path.history())) {
            findPath(path, nextNode);
        }

    }
}

class Path{

}


public class main {
    public static void main(String[] args) {
        new Solution().solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, new int[][]{{0,1},{1,2},{0,3}});
    }
}
