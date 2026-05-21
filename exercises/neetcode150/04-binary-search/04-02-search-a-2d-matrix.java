// Fri May 22 2026
// 07'36''
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int total = rowCount * colCount;
        // no need for long becuase 1 <= m, n <= 100

        int left = 0;
        int right = total-1;

        while(left<=right){
            int mid = (left+right)/2;
            //row index: number/colCount 몫
            //col index: number%colCount 나머지

            int rowIndex = mid/colCount;
            int colIndex = mid%colCount;

            if(matrix[rowIndex][colIndex] < target){
                left=mid+1;
            }else if(matrix[rowIndex][colIndex] > target){
                right=mid-1;
            }else{
                return true;
            }
        }

        return false;
    }
}
