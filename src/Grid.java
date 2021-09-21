import java.awt.*;
import java.util.ArrayList;

public class Grid {
    int numRows, numCols;
    Cell [][] grid;

    public Grid (int rows, int cols) {
        numRows = rows;
        numCols = cols;

        grid = new Cell[rows][cols];
        clearGrid();
        seedGrid();
    }


    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public String toString() {
        String grid = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j ++) {
                grid += (" " + getCell(i,j).toString() + " ");
            }
            grid += "\n";
        }
        return grid;
    }

    public int countAliveNeighbors(int r, int c){
        int counter = 0;

        //top left
        if (getCell(subtractRowIndex(r), subtractColIndex(c)).isAlive()) {
            counter++;
        }

        //top middle
        if (getCell(subtractRowIndex(r), c).isAlive()) {
            counter++;
        }

        //top right
        if (getCell(subtractRowIndex(r), addColIndex(c)).isAlive()) {
            counter++;
        }

        //middle left
        if (getCell(r, subtractColIndex(c)).isAlive()) {
            counter++;
        }

        //middle right
        if (getCell(r, addColIndex(c)).isAlive()) {
            counter++;
        }

        //bottom left
        if (getCell(addRowIndex(r), subtractColIndex(c)).isAlive()) {
            counter++;
        }

        //bottom middle
        if (getCell(addRowIndex(r), c).isAlive()) {
            counter++;
        }

        //bottom right
        if (getCell(addRowIndex(r), addColIndex(c)).isAlive()) {
            counter++;
        }

        return counter;
    }

    private int addRowIndex(int n) {
        n = n + 1;
        if (n < numRows) {
            return n;
        } else {
            return 0;
        }
    }

    private int addColIndex(int n) {
        n = n + 1;
        if (n  < numCols) {
            return n;
        } else {
            return 0;
        }
    }

    private int subtractRowIndex(int n) {
        n = n - 1;
        if (n >= 0) {
            return n;
        } else {
            return numRows - 1;
        }
    }

    private int subtractColIndex(int n) {
        n = n -1;
        if (n >= 0) {
            return n;
        } else {
            return numCols - 1;
        }
    }


    private boolean willCellBeAlive (int r, int c) {
        Cell current = getCell(r, c);
        int counter = countAliveNeighbors(r ,c);

        if (current.isAlive()) {
            if (counter == 2 || counter == 3) {
               return true;
            } else if (counter == 0 || counter == 1 || counter >= 4) {
                return false;
            }
        } else {
            if (counter == 3) {
                return true;
            }
        }
        return false;
    }

    public void advance() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j ++) {
                getCell(i, j).setNextGen(willCellBeAlive(i, j));
            }
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j ++) {
                getCell(i, j).advance();
            }
        }
    }

    public void paint(Graphics g, int size) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j ++) {
                if (getCell(i, j).isAlive()) {
                    drawCell(g, size, i, j, Color.pink);
                } else {
                    drawCell(g, size, i, j, Color.gray);
                }
            }
        }
    }

    public void drawCell(Graphics g, int size, int row, int col, Color color) {
        int x = col * size;
        int y = row * size;
        g.setColor(Color.BLACK);
        g.fillRect(x, y, size, size);
        g.setColor(color);
        g.fillRect(x , y  , size-1, size-1 );
    }

    public void clearGrid() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j ++) {
                grid[i][j] = new Cell();
            }
        }
    }
    public void seedGrid() {
        grid[2][3].setCurrentGen(true);
        grid[3][4].setCurrentGen(true);
        grid[4][2].setCurrentGen(true);
        grid[4][3].setCurrentGen(true);
        grid[4][4].setCurrentGen(true);

        grid[9][46].setCurrentGen(true);
        grid[9][47].setCurrentGen(true);
        grid[9][48].setCurrentGen(true);
        grid[9][49].setCurrentGen(true);
        grid[9][50].setCurrentGen(true);
        grid[9][51].setCurrentGen(true);
        grid[9][52].setCurrentGen(true);
        grid[9][53].setCurrentGen(true);

        grid[10][17].setCurrentGen(true);
        grid[11][16].setCurrentGen(true);
        grid[11][17].setCurrentGen(true);
        grid[11][18].setCurrentGen(true);

        grid[15][57].setCurrentGen(true);
        grid[15][56].setCurrentGen(true);
        grid[16][57].setCurrentGen(true);
        grid[16][58].setCurrentGen(true);

        grid[19][6].setCurrentGen(true);
        grid[19][7].setCurrentGen(true);
        grid[19][8].setCurrentGen(true);
        grid[19][9].setCurrentGen(true);
        grid[19][10].setCurrentGen(true);
        grid[19][11].setCurrentGen(true);
        grid[19][12].setCurrentGen(true);
        grid[19][13].setCurrentGen(true);

        grid[37][7].setCurrentGen(true);
        grid[37][8].setCurrentGen(true);
        grid[37][9].setCurrentGen(true);
        grid[38][7].setCurrentGen(true);

        grid[22][43].setCurrentGen(true);
        grid[23][44].setCurrentGen(true);
        grid[24][42].setCurrentGen(true);
        grid[24][43].setCurrentGen(true);
        grid[24][44].setCurrentGen(true);
    }
}
