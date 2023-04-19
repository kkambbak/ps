package com.ll.level3.p64064;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        //new Solution().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"});
        new Solution().solution(new String[]{"frodo"}, new String[]{"*rodo"});
    }
}

class Solution {
    public int solution(String[] user_id, String[] banned_id) {

        ArrayList<String>[] bannedCases = findBannedId(user_id, banned_id);
        return findNumberOfCases(bannedCases, banned_id.length);

    }

    private ArrayList<String>[] findBannedId(String[] user_id, String[] banned_id) {
        ArrayList<String>[] bannedCases = new ArrayList[banned_id.length];
        int i = 0;
        for (String bannedId : banned_id) {
            bannedCases[i++] = (matchUserIds(bannedId, user_id));
        }

        return bannedCases;
    }

    private int findNumberOfCases(ArrayList<String>[] bannedCases, int len_banned_id) {
        int[] visitedLength = new int[len_banned_id];

        int idx = 0;
        for (ArrayList<String> matchedIds: bannedCases) {
            visitedLength[idx++] = matchedIds.size();
        }

        Set<Set<String>> EntireSet = new HashSet<>();

        for (int i = 0; i < visitedLength[0]; i++) {
            Set<String> set = new HashSet<>();
            EntireSet = visitArrays(EntireSet, set, 0, i, bannedCases, visitedLength);
        }
        return EntireSet.size();
    }

    private Set<Set<String>> visitArrays(Set<Set<String>> EntireSet, Set<String> set, int index, int listIndex,  ArrayList<String>[] bannedCases, int[] visitedLength) {
        Set<String> newSet = new HashSet<>(set);
        newSet.add(bannedCases[index].get(listIndex));

        //종료조건
        if (index == visitedLength.length-1) {
            if (newSet.size() == visitedLength.length) {
                EntireSet.add(newSet);
            }
            return EntireSet;
        }
        //점화식
        index++;
        int idx = 0;
        while(idx < visitedLength[index]){
            visitArrays(EntireSet, newSet, index, idx, bannedCases, visitedLength);
            idx++;
        }
        return EntireSet;
    }

    private ArrayList<String> matchUserIds(String bannedId, String[] user_id) {
        ArrayList<String> matched = new ArrayList<>();

        for (String userId : user_id) {
            if (matchString(bannedId, userId)) {
                matched.add(userId);
            }
        }

        return matched;
    }

    private boolean matchString(String bannedId, String userId) {
        if (bannedId.length() != userId.length())
            return false;

        char[] b = bannedId.toCharArray();
        char[] u = userId.toCharArray();

        for (int i = 0; i < b.length; i++) {
            if (b[i] == '*') {
                continue;
            }
            if (b[i] != u[i]) {
                return false;
            }
        }
        return true;
    }
}