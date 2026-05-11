// Mon May 11 2026
// 44:36

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int left = 1;
        int right = rowCount * colCount;

        // 각 칸의 좌표 어떻게 구하지?
        // (0,0) (0,1) (0,2) (0,3)
        // (1,0) (1,1) (1,2) (1,3)


        // int midRow = (0+rowCount-1)/2;
        // int midCol = (0+colCount-1)/2;

        // if(target == matrix[midRow][midCol]){ //matrix[1][1]
        //     return true;
        //     // 6번째라면 
        //     // 6/colCount = 몫 = row
        //     // 6/colCount = 나머지 > 1 때는 -1, 아닐 때는 마지막 column = col
        // }else if(target > matrix[midRow][midCol]){
        //     midRow = (midRow+rowCount-1)/2;
        // }


        // cellNumber -> matrix[r][c]
        // (1) row: cellNumber / colCount;
        // (2) col: cellNumber % colCount;
        //          if(cellNumber%colCount==0) col=matrix[0].length-1;
        //          else col=cellNumber%colCount-1;


        while(left <= right){
            int half = (left+right) / 2;

            int row = half % colCount == 0 ? half/colCount - 1 : half / colCount;
            int col = half % colCount == 0 ? colCount-1 : half % colCount -1;

            if(target == matrix[row][col]){
                return true;
            }else if(target > matrix[row][col]){
                left = half+1;
                // half = (left+right)/2;
            }else {
                right = half-1;
                // half = (left+right)/2;
            }
        }

        return false;

    }
}

// m * n = r * c