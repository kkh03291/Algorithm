class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        Move m = new Move(matrix);
        while (true) {
            System.out.println(m.m);
            System.out.println(m.n);
            if (m.isMoveable("")) {
                result.add(m.move());
            }else if (m.checkAndChangeDirection()){
                result.add(m.move());
            }else {
                result.add(m.getCurrentValue());
                break;
            }
        }
        return result;
    }

    class Move {
        int col;
        int row;
        int m;
        int n;
        int[][] matrix;
        String direction;

        public Move(int[][] matrix) {
            this.matrix = matrix;
            this.col = 0;
            this.row = 0;
            this.m = matrix.length;
            this.n = matrix[0].length;
            this.direction = "right";
        }

        public boolean isMoveable(String direction) {
            if(direction.isEmpty()) direction = this.direction;

            switch (direction) {
                case "right":
                    if(row + 1 < n && matrix[col][row + 1] != -101){
                        return true;
                    }
                    break;
                case "left":
                    if(row - 1 >= 0 && matrix[col][row - 1] != -101){
                        return true;
                    }
                    break;
                case "up":
                    if(col - 1 >= 0 && matrix[col - 1][row] != -101){
                        return true;
                    }
                    break;
                case "down":
                    if(col + 1 < m && matrix[col + 1][row] != -101){
                        return true;
                    }
                    break;
                default:
                    break;
            }
            return false;
        }

        public boolean checkAndChangeDirection() {
            if (isMoveable("right")) {
                this.direction = "right";
                return true;
            } else if (isMoveable("down")) {
                this.direction = "down";
                return true;
            } else if (isMoveable("left")) {
                this.direction = "left";
                return true;
            } else if (isMoveable("up")) {
                this.direction = "up";
                return true;
            } else {
                return false;
            }
        }
        public Integer move() {
            Integer num = 0;
            switch (direction) {
                case "right":
                    num = matrix[col][row];
                    matrix[col][row] = -101;
                    row++;
                    break;
                case "left":
                    num = matrix[col][row];
                    matrix[col][row] = -101;
                    row--;
                    break;
                case "up":
                    num = matrix[col][row];
                    matrix[col][row] = -101;
                    col--;
                    break;
                case "down":
                    num = matrix[col][row];
                    matrix[col][row] = -101;
                    col++;
                    break;
                default:
                    break;
            }
            return num;
        }
        public Integer getCurrentValue(){
            return matrix[col][row];
        }

    }
}