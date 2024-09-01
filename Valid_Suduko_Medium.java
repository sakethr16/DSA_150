
/*
36. Valid Sudoku

Topics
Companies
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 */


class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashMap<Integer, HashSet<Character>> rowm = new HashMap<>();
        HashMap<Integer, HashSet<Character>> colm = new HashMap<>();
        HashMap<Integer, HashSet<Character>> diam = new HashMap<>();

        int m = board.length;
        int n = board[0].length;

        for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                char val = board[i][j];
                if(val != '.'){
                    if(rowm.getOrDefault(i, new HashSet<>()).contains(val)){
                        return false;
                    }
                    rowm.putIfAbsent(i, new HashSet<>());
                    rowm.get(i).add(val);
                

                    if(colm.getOrDefault(j, new HashSet<>()).contains(val)){
                        return false;
                    }
                    colm.putIfAbsent(j, new HashSet<>());
                    colm.get(j).add(val);

                    int x = i / 3;
                    int y = j / 3;
                    int box = x*3 + y;
                    if(diam.getOrDefault(box, new HashSet<>()).contains(val)){
                        return false;
                    }
                    diam.putIfAbsent(box, new HashSet<>());
                    diam.get(box).add(val);
                }
    
            }
        }
        return true;


    }
}