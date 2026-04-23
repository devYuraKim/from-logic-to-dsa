```java
double converterToNumeric(String s, int p){

    String output;

    bool dot_found = false;
    for(int i = 0; i < s.length(); i++) {
        // check if the current i is the integer part or decimal part.
        if(s.charAt(i) == ’.’){
            dot_found = true; // if (dot_found) => there is ‘.’ before i
            output.append(s.charAt(i));
        }else if( dot_found && p > 0 ) {
            output.append(s.charAt(i));
            p–;
        }else if( dot_found  && p <= 0 ){
            break;
        }

        if(s.charAt(i) == ‘,’){
            output.append(s.charAt(i));
        } else if ( p > 0 ) {
            output.append(s.charAt(i));
            p-–; //0
        } //, 후 . 이전까지는 0


    }
}

}

// p==0인 거 어디서 확인?
// p==0 확인해서 그 다음 step?

        (0, 1, 2, 3)
        [7   .   2  9]
        2

```