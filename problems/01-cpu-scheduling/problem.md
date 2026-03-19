You are given a list of N tasks with each task taking S seconds to execute on a single CPU.  
The ith task can start executing at or after start_times[i].  
Given C CPUs, find the minimum time at which all the tasks will be executed.

**Examples**  
**Input:** start_times = [1, 3, 6], S = 6, C = 2  
**Output:** 13  

**Why?**  
Task 1 can be executed on CPU 0 from t = 1 to t = 7.  
Task 2 can be executed on CPU 1 from t = 3 to t = 9.  
Task 3 can be executed on CPU 1 from t = 7 to t = 13.