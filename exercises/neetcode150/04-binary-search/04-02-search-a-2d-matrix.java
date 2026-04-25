// Sat Apr 25
// 1:16:02

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // (r,c) = (m,n)
        // (0,0) (0,1) (0,2) (0,3)
        // (1,0) (1,1) (1,2) (1,3)
        // (2,0) (2,1) (2,2) (2,3)
        // (0,0) - (m-1, n-1)

        // 이렇게 하지 말고
        // up, down
        // left, right
        // 이렇게 하면 어떨까
        // 하는 생각이 14:36에 들었음

        // 아니면
        // up, down
        // left, right을
        // 각각 binary search로 하는 건 어떨까
        // 하는 생각이 24:58에 들었음


        // int row = -1;
        // //row 선택
        // for(int i = 0; i < matrix.length; i++){
        //     if(matrix[i][0] < target) {
        //         continue;
        //     }else if(matrix[i][0] = target){
        //         return true;
        //     }else{
        //         row = i-1;
        //         break;
        //     }
        // }
        // // column 선택



        // int down = 0;
        // int up = matrix.length - 1;

        // int right = 0;
        // int left = matrix[0].length - 1;

        // while(down <= up){
        //    if(matrix[down][0] < target){
        //     down++;
        //    }

        //    if(matix[up][0] > target){
        //     up--;
        //    }
        // }



        //row binary
        // int startRow = 0;
        // int endRow = matrix.length - 1;

        // 그런데 이렇게 하면 범위를 좁힐 수가 없는데...?
        // int halfRow = ( 0 + matrix.length-1 )/2;
        // if(matrix[halfRow][0] > target){

        // }else if(matrix[row/2][0] == target){
        //     return true;
        // }else{

        // }

        // (0) 1
        // (1) 10 11 12 13 14
        // (2) 15
        // (3) 22
        // (4) 30
        // (5) 45
        // (6) 56 57 58 59 60
        // (7) 62
        // (8) 78

        // target == 58
        // halfRow -> 4 (30) < 58
        // endRow 고정, startRow = halfRow+1 (5+8)/2 = 6
        // halfRow -> 6 (56) < 58
        // endRow 고정, startRow = halfRow+1 (7+8)/2 = 7
        // halfRow -> 7 (62) > 58
        // FLAG: 6과 7 사이이므로 row 6에서 검색

        // target == 13
        // halfRow -> 4 (30)
        // startRow 고정, endRow = halfRow-1 (0+3)/2 = 1
        // halfRow -> 1 (10) < 13
        // endRow 고정 3, startRow = halfRow+1 (3+2) = 2
        // halfRow -> 2 (15) > 13
        // FLAG: 1과 2 사이이므로 row 1에서 검색

        // flag를 isReversed로 관리, 바뀌는 지점에서 row 확정
        // AI들의 도움을 받음. 굳이 그렇게 안 해도 된다고 함.

        // int startRow = 0;
        // int endRow = matrix.length - 1;

        // int halfRow = (startRow + endRow)/2;
        // int endCol = matrix[0].length - 1;

        // while(matrix[halfRow][0] <= target && matrix[halfRow][endCol] >= target){
        //     if(matrix[halfRow][0] > target){

        //     }
        // }

        int start = 0;
        int end = matrix.length - 1;
        int endCol = matrix[0].length-1;
        int targetRow = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[mid][0] <= target && target <= matrix[mid][endCol]) {
                targetRow = mid; // 찾았다!
                break;
            } else if (matrix[mid][0] > target) {
                end = mid - 1; // 너무 아래 행이다, 위로 가자
            } else {
                start = mid + 1; // 너무 위 행이다, 아래로 가자
            }
        }

        if (targetRow == -1) return false; // 어떤 행에도 포함될 수 없음

        int left = 0;
        int right = matrix[targetRow].length - 1;

        while (left <= right){
            int mid = left + (right-left)/2;

            if(matrix[targetRow][mid] == target){
                return true;
            }else if(matrix[targetRow][mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return false;

    }
}