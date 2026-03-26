```java
input: List<Array> nums
output: Boolean True/False

// 총합으로 접근하겠다
// (면접관 포인트) int + int -> long
// 음수가 가능한지 확인할 필요 있는가? (로직 자체에는 상관이 없다)

// array element loop -> total sum -> divide by 2 -> value
// subset sum value -> original array value 하나씩 빼기

(1+5+11+5) / 2 = 11
11 - 1 = 10
10 - 5 = 5
5 - 11 = -6 // issue!
5 - 5 = 0 //
check if 11 (the of the rest) 11 // 성공

(1 + 2+ 3+ 5 ) / 2 = 11/2 = 5.5
// check point 1)  total sum / 2 => integer 구조적으로 불가능하다

e.g. 3)
Input: nums = [1, 6, 5, 5, 5]
Output: true
why? [1, 5, 5], [5, 6]

11 - 1 = 10
10 - 6 = 4
4 - 5 = -1 // issue

// 순서가 아니라 조합이 중요
// ** 루프로는 불가능함



// 면접관이 갑분 피보나치 수열 해보자

Integer fib(Interger n) {     //3

	Integer value;
	Integer sum = 0;

for ( int i=0; int i < n; i++){   // i가 0일 때, 2 < 3 그만 두세요   // i=0, n=3 > i=1, n=3 > i=2, n=3

	if ( i = 0 | i = 1 ) {
value = 1; // i=0 -> value = 1, i=1 value = 1
} else {
	value = sum;
	// fib(n + 2) = fib(n + 1) + fib(n)
}

 , value = sum
	sum = sum + value; // 0+1 -> 1, 1+1 = 2
}

}
```
