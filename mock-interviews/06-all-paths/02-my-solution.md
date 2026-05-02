```java

int countTwo = n/2; //2의 최대 갯수
int countOne = n%2; //2가 최대일 때 1의 갯수

// 여기서 수학적으로 사고하지 말고, 컴퓨터공학적으로 사고하라고 코멘트 받음
a(0), a(n) 을 구하는 방법을 a(n-1) 를 어떻게 해서 한다.


n-1
n-2
==0

1,1,2


String seqOne;
String seqTwo;

while(n-1==0){
	seqOne.append(‘1’);
}

//무한루프 해결 되었다고 치고 코드 진행
while(n-2==0){
	seqTwo.append(‘2);
}

```