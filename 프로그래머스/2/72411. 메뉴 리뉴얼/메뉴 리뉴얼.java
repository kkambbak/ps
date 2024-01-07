import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> li = new ArrayList<>();

		for(int r: course){
			//combi를 저장할 맵
			Map<Set<String>, Integer> map = new HashMap<>();

			//max 조합 저장
			List<Set<String>> temp = new ArrayList<>();
            
            //가장 많은 주문수
			int maxnum = 2;

			for(String s: orders) {

				if(s.length() >= r) {
					List<Set<String>> combinationList = combination(s, r);

					//콤비를 돌며 주문수 세기
					for(Set<String> set: combinationList){
						Integer count = map.getOrDefault(set, 0);
						map.put(set, ++count);
                        
                        //최소 2명 이상의 손님으로부터 받은 주문만 temp에 저장
						if(count >= 2){
							if(maxnum < count){
								temp.clear();
								temp.add(set);
								maxnum = count;
							} else if(maxnum == count){
								temp.add(set);
							}
						}
					}
				}
			}
            //Set -> String
			for(Set<String> set: temp){
				StringBuilder sb = new StringBuilder();
                List<String> sortedList = new ArrayList<>(set);
                Collections.sort(sortedList);
                for(String el: sortedList){
                    sb.append(el);
                }
                li.add(sb.toString());
			}
		}
        
        Collections.sort(li);
		String[] answer = li.toArray(new String[0]);
        return answer;
    }
    
    public static List<Set<String>> combination(String s, int r) {
		String[] elements = s.split("");
		int[] indexes = new int[r];
		int n = elements.length;
		List<Set<String>> result = new ArrayList<>();

		if (r <= n) {
			for (int i = 0; i < r; i++) {
				indexes[i] = i;
			}
			do {
				Set<String> combination = new HashSet<>();
				for (int i = 0; i < r; i++) {
					combination.add(elements[indexes[i]]);
				}
				result.add(combination);
			} while (nextCombination(indexes, n, r));
		}
		return result;
	}

	private static boolean nextCombination(int[] indexes, int n, int r) {
		int i = r;
		while (--i >= 0) {
			if (indexes[i] != n - r + i) break;
		}
		if (i < 0) return false;
		indexes[i]++;
		for (int j = i; ++j < r;) {
			indexes[j] = indexes[i] + j - i;
		}
		return true;
	}
}