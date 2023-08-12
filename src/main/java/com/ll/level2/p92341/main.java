package com.ll.level2.p92341;

import java.util.*;
import java.util.stream.Collectors;

public class main {
}
class Solution {
	public int[] solution(int[] fees, String[] records) {

		String[] carIn = new String[10000]; //입차 기록용
		int[] carTime = new int[10000]; //차량번호별 누적시간
		ArrayList<Integer> carNums = new ArrayList<>(); // 입출차한 차량
		Set<Integer> checkOut = new HashSet<>(); // 출차 확인용

		//parse records
		for(String record: records){
			String[] item = record.split(" ");
			String time = item[0];
			int carNum = Integer.valueOf(item[1]);
			String inOut = item[2];

			if(inOut.equals("IN")){
				carNums.add(carNum);
				carIn[carNum] = time;
				checkOut.add(carNum);
			}
			else {
				carTime[carNum] += calcTime(carIn[carNum], time);
				checkOut.remove(carNum);
			}
		}

		//parse fees
		int baseTime = fees[0];
		int baseFee = fees[1];
		int unitTime = fees[2];
		int unitFee = fees[3];

		// get result
		// carNums에서 소팅하고, distinct
		List<Integer> sortedAndDistinct = carNums.stream()
			.distinct()
			.sorted()
			.collect(Collectors.toList());

		int[] answer = new int[sortedAndDistinct.size()];
		int idx = 0;

		for(int carNum: sortedAndDistinct){
			// 1. 출차기록이 없는 차량인지 확인, 없으면 out시간을 23:59로 적용해서 계산하기
			if(checkOut.contains(carNum)){
				carTime[carNum] += calcTime(carIn[carNum],"23:59");
			}

			//요금 계산
			int accTime = carTime[carNum];
			int totalFee = baseFee;

			//기본시간 초과
			if(accTime > baseTime){
				totalFee += Math.ceil((float)(accTime - baseTime)/unitTime) * unitFee;
			}

			answer[idx++] = totalFee;
		}

		return answer;
	}
	public int calcTime(String inTime, String outTime){
		int out = Integer.valueOf(outTime.substring(3,5)) + 60 * Integer.valueOf(outTime.substring(0,2));
		int in = Integer.valueOf(inTime.substring(3,5)) + 60 * Integer.valueOf(inTime.substring(0,2));
		return out - in;
	}

}