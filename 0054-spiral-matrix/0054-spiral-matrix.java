import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix.length == 0)
            return result;

        int m = matrix.length;       // number of rows
        int n = matrix[0].length;    // number of columns
        
        int top = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        int id = 0;  // id is used to control the direction of traversal
        // 0 -> left  to right
        // 1 -> top   to down
        // 2 -> right to left
        // 3 -> down  to top

        while (top <= down && left <= right) {
            // left to right
            if (id == 0) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            }

            // top to down
            else if (id == 1) {
                for (int i = top; i <= down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            }

            // right to left
            else if (id == 2) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            }

            // down to top
            else if (id == 3) {
                for (int i = down; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }

            id = (id + 1) % 4;  // change direction
        }

        return result;
    }
}
