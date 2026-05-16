// Sun May 17 2026
class Solution {
    public boolean isValidSudoku(char[][] board) {

        // 1. 한 row에서 1-9 하나씩 있는지 확인
        // 2. 한 col에서 1-9 하나씩 있는지 확인
        // 3. 한 3*3 block에서 1-9 하나씩 있는지 확인
        //    block definition: row(0, 3, 6)
        //                      col(0, 3, 6)

        Set<Character> rowSet = new HashSet<>();
        for(int i=0; i<9; i++){
            rowSet.clear();
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    if(!rowSet.add(board[i][j])){
                        return false;
                    }
                }
            }
        }

        Set<Character> colSet = new HashSet<>();
        for(int i=0; i<9; i++){
            colSet.clear();
            for(int j=0; j<9; j++){
                if(board[j][i]!='.'){
                    if(!colSet.add(board[j][i])){
                        return false;
                    }
                }
            }
        }

        // Set<Character> blockSet = new HashSet<>();
        // for(int i=0; i<3; i++){
        //     blockSet.clear();
        //     for(int j=0; j<3; j++){
        //         if(board[i][j]!='.'){
        //             if(!blockSet.add(board[i][j])){
        //                 return false;
        //             }
        //         }
        //     }
        // }
        // 여기에서 i,j를 3씩 어떻게 키우지?

        Set<Character> blockSet = new HashSet<>();
        for(int row = 0; row < 9; row += 3){
            for(int col = 0; col < 9; col += 3){
                blockSet.clear();
                for(int i = row; i < row + 3; i++){
                    for(int j = col; j < col + 3; j++){
                        if(board[i][j] != '.'){
                            if(!blockSet.add(board[i][j])){
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
