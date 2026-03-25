```java
Integer findMinimumTime (List<Integer> startTimes, Integer seconds, Integer cpu) {

// cpu 하나 당 리스트 하나 할당
// 리스트에 task를 추가
// task1을 cpu0 추가 []

Integer S = 6;

List<Integer> cpu0 = [];
List<Integer> cpu1 = [];

for ( startTimes :startTime) {
		if(cpu0.length == 0)
{ cpu0.add(startTime+S); } // cpu0 = [7]
		if { cpu1.length == 0) {
			{cpu1.add(startTime+S); } // cpu1 = [9]
} else {
	// given task 3, starting at 6
      	// cpu0 = [7]
	// cpu1 = [9]
 	// we select cpu0,
	// then update cpu0 to [13]

	if (cpu0[0] - cpu1[0] < 0) { //어떤 cpu에 넣을지 여기서 결정함

				if(cpu0[0] >= startTime){ // 7 >= 6
		cpu0[0](Cpu0[0] + S)
} else { // 7 10 (cpu0[0], startTime) 
	cpu1[0](startTime + S)
}
}
	

}

}

Integer returnValue;

if(cpu0[0] - cpu1[0] >0 ) {
returnValue=cpu0[0];
} else returnValue=cpu1[0];
	
return returnValue; 
		
}














cpu0 : []
cpu1 : []


// task 1
	// .length 0 > element 추가 > cpu0[6]
	cpu0: [7]
             cpu1: []

             // task2 	
	//cpu0 비어 있는지 > 1초에 시작해서 6초가 걸려서 끝나는 시간 > 7초
	//cpu1 비어 있는지 > 3초에 시작해서 6초가 걸려서 끝나는 시간 > 9초
             cpu0: [7]
             cpu1: [9]

	// task3
	// 각 cpu의 종료시간의 값을 확인 7, 9가 6보다 커야 하고, 차가 가장 작은
	// cpu0 기존 종료시간 값에 처리시간을 더해서 업데이트
	// cpu0 [13]
	// cpu1 [9]

	return minimumTime;
}


```