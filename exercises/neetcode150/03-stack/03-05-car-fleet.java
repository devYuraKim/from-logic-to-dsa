// Sun May 17
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int carCount = position.length;

        int[][] cars = new int[carCount][2];
        for(int i=0; i<carCount; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        //Arrays.sort(cars);
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        // 만약 뒷차의 time이 앞차의 prevTime보다 작거나 같으면, 기존 fleet에 포함
        double prevTime = 0;
        int fleet = 0;
        for(int j=0; j<carCount; j++){
            double time = (double)(target - cars[j][0]) / cars[j][1];

            if(time > prevTime){
                prevTime = time;
                fleet++;
            }

            // prevTime = time;
        }

        return fleet;

    }
}