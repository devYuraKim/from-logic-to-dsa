public static void main (args [...]){
    fib(4);
}

// fib(0) = fib(1) = 1
// fib(2) = fib(0) + fib(1) = 2
// fib(3) = fib(1) + fib(2) = 1 + 2 = 3
// fib(4) = fib(2) + fib(3) = 2 + 3 = 5

// fib(n) = fib(n-2) + fib(n-1)
// if(n == 0 || n == 1) fibValue = 1; 
public int fib(int n) {
    
    if(n == 0 || n == 1) return 1;
    
    fib(n) = fib(n-2) + fib(n-1);
    
}

// 잘못한 점: 큰일인데?

// I. main 함수 관련 
//    1. main static인데, fib method는 static이 아님 > incompatible
//    2. main method args... type 지정 왜 저 모양? String[] args
//    3. fib(4); call 하면 조용히 뭐 함? print 해서 결과 봐야지

// II. public 함수 관련
//    4. `fib(n) = fib(n-2) + fib(n-1);` return 해야지 뭐 함?

// III. 클래스 구조 관련
//    5. 클래스 선언 누락: java의 모든 코드는 class 블록 안에 있어야 함. 클래스 선언 없이 메서드만 존재할 수 없음. 
//    6. 파일명-클래스명 불일치: 원래 파일 이름 '03-practice-simple-recursion', 클래스 이름 '없음'(왜냐면 comprehensive class 자체가 없으니까)
//    7. 별개 클래스 사용 미연결: main, fib이 별개 클래스라면
//       7.1. static: 클래스명.fib(4) 처럼 직접 호출
//       7.2. instance: 클래스명 변수명 = new 클래스명(); 후 변수명.fib(4) 호출
//       * 현재 fib(4)는 main 있는 클래스 내부에서만 해당 함수 찾음.