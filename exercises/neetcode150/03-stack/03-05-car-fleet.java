// Thu May 21 2026
// 19'43''
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int carCount = position.length;
        int[][] cars = new int[carCount][2];

        int fleet = carCount;

        for(int i=0; i<carCount; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Check Java Syntax
        // Arrays.sort(cars[][0], b-a);
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        double[] timeArray = new double[carCount];

        for(int j=0; j<carCount; j++){
            double time = (double) (target-cars[j][0])/cars[j][1];
            timeArray[j] = time;
        }

        double maxTime = timeArray[0];
        for(int k=1; k<carCount; k++){
            if(timeArray[k] <= maxTime){
                fleet--;
            }
            if(timeArray[k] > maxTime){
                maxTime = timeArray[k];
            }
        }

        return fleet;

    }
}

// int[][] = [ [position, speed], [], [], [], [] ]

// tartget 10
// position [4, 2, 0]
// speed.   [1, 3, 2]
// time.    [6, 2. 5]

// target
// position [7, 4, 1, 0]
// speed    [1, 2, 2, 1]
// remaining[3, 6, 9, 10]
// time     [3, 3, 4.5, 10]

// position [4,1]
// speed.   [2,3]
// time.    [3,3]

