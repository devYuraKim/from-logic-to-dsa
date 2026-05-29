### 1. `left<right` vs `left<=right`

```java
nums = [5]
target = 5
```

```java
int left = 0; 
int right = 0;

// left<right
while (left<right){
    // while 들어가지도 않고 return -1
}
return -1;

// left<=right
while(left<=right){
    int mid = left+(right-left)/2;
    //mid=0

    if(nums[mid]==target){
        return mid;
        //return 0
    }
}
```