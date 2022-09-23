import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Board {
    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

    interface CellCreatedListener {
        void cellCreated(int x, int y, int number);
    }

    interface CellMovedListener {
        void cellMoved(int fromX, int fromY, int toX, int toY);
    }

    interface CellMergedFromListener {
        void cellMergedFrom(int fromX, int fromY, int toX, int toY, int mergedNumber);
    }

    interface CellMergedToListener {
        void cellMergedTo(int toX, int toY, int fromX, int fromY);
    }

    private static final int DEFAULT_SIZE_OF_BOARD = 4;
    private static final int FIRST_NUMBER = 2;

    private final int[][] cells;
    private int maxNumber;
    private int goal = 2048;

    private final List<CellCreatedListener> cellCreatedListeners =
            new ArrayList<>();
    private final List<CellMovedListener> cellMovedListeners =
            new ArrayList<>();
    private final List<CellMergedFromListener> cellMergedFromListeners =
            new ArrayList<>();
    private final List<CellMergedToListener> cellMergedToListeners =
            new ArrayList<>();

    public Board() {
        this(DEFAULT_SIZE_OF_BOARD);
    }

    public Board(int size) {
        this(new int[size][size]);
        placeNewRandomValues(2);
    }

    public Board(int[][] cells) {
        assert cells.length > 0 && cells.length == cells[0].length;

        maxNumber = cells[0][0];
        for (int y = 0; y < cells.length; y++) {
            for (int x = 0; x < cells[0].length; x++) {
                if (cells[y][x] > maxNumber) {
                    maxNumber = cells[y][x];
                }
            }
        }
        this.cells = cells;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getSize() {
        return cells.length;
    }

    public int getNumber(int x, int y) {
        return cells[y][x];
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public void addCellCreatedListener(CellCreatedListener listener) {
        cellCreatedListeners.add(listener);
    }

    public void addCellMovedListener(CellMovedListener listener) {
        cellMovedListeners.add(listener);
    }

    public void addCellMergedFromListener(CellMergedFromListener listener) {
        cellMergedFromListeners.add(listener);
    }

    public void removeCellMergedToListener(CellMergedToListener listener) {
        cellMergedToListeners.remove(listener);
    }

    public void removeCellCreatedListener(CellCreatedListener listener) {
        cellCreatedListeners.remove(listener);
    }

    public void removeCellMovedListener(CellMovedListener listener) {
        cellMovedListeners.remove(listener);
    }

    public void removeCellMergedFromListener(CellMergedFromListener listener) {
        cellMergedFromListeners.remove(listener);
    }

    public void addCellMergedToListener(CellMergedToListener listener) {
        cellMergedToListeners.add(listener);
    }


    public boolean checkingForTheEnd() {
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                if (getNumber(x, y) == goal) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasMoreEmptySpace() {
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                if (hasMoreMoves()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getScore() {
        int counter = 0;
        int result = 0;
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                counter += getNumber(x, y);
//                result = (int) Math.pow(counter, 2);
            }
        }
        return counter;
    }

    public boolean hasMoreMoves() {
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                int num = getNumber(x, y);

                if (num == 0 ||
                        areCoordsInside(x, y - 1) && getNumber(x, y - 1) == num ||
                        areCoordsInside(x, y + 1) && getNumber(x, y + 1) == num ||
                        areCoordsInside(x - 1, y) && getNumber(x - 1, y) == num ||
                        areCoordsInside(x + 1, y) && getNumber(x + 1, y) == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public void moveUp() {
        moveUp(1);
    }

    public void moveUp(int cellsToGenerate) {
        for (int x = 0; x < getSize(); x++) {
            mergeCellsOnCol(x, -1);
            moveCellsOnCol(x, -1);
        }
        if (cellsToGenerate > 0) {
            placeNewRandomValues(cellsToGenerate);
        }
    }

    public void moveDown() {
        moveDown(1);
    }

    public void moveDown(int cellsToGenerate) {
        for (int x = 0; x < getSize(); x++) {
            mergeCellsOnCol(x, 1);
            moveCellsOnCol(x, 1);
        }
        if (cellsToGenerate > 0) {
            placeNewRandomValues(cellsToGenerate);
        }
    }

    public void moveLeft() {
        moveLeft(1);
    }

    public void moveLeft(int cellsToGenerate) {
        for (int y = 0; y < getSize(); y++) {
            mergeCellsOnRow(y, -1);
            moveCellsOnRow(y, -1);
        }
        if (cellsToGenerate > 0) {
            placeNewRandomValues(cellsToGenerate);
        }
    }

    public void moveRight() {
        moveRight(1);
    }

    public void moveRight(int cellsToGenerate) {
        for (int y = 0; y < getSize(); y++) {
            mergeCellsOnRow(y, 1);
            moveCellsOnRow(y, 1);
        }
        if (cellsToGenerate > 0) {
            placeNewRandomValues(cellsToGenerate);
        }
    }

    @Override
    public String toString() {
        var res = new StringBuilder();

        String format = "%" + String.valueOf(getMaxNumber()).length() + "s ";
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                int num = getNumber(x, y);
                if (num == 0) {
                    res.append(String.format(format, "-"));
                } else {
                    res.append(String.format(format, num));
                }
            }
            res.append("\n");
        }
        return res.toString();
    }

    public String toStringWithoutFormatting() {
        var res = new StringBuilder();

        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                res.append(getNumber(x, y));
                if (x < getSize() - 1) {
                    res.append(' ');
                }
            }
            res.append('\n');
        }
        return res.toString();

    }

    private void setNumber(int x, int y, int number) {
        cells[y][x] = number;
    }

    private void placeNewRandomValues(int amount) {
        var unoccupiedCells = new ArrayList<Point>();
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                if (getNumber(x, y) == 0) {
                    unoccupiedCells.add(new Point(x, y));
                }
            }
        }
        for (int i = 0; i < amount && unoccupiedCells.size() > 0; i++) {
            int randomIndex = (int) (Math.random() * unoccupiedCells.size());
            Point point = unoccupiedCells.get(randomIndex);
            setNumber(point.x, point.y, FIRST_NUMBER);
            if (FIRST_NUMBER > maxNumber) {
                maxNumber = FIRST_NUMBER;
            }
            for (var listener : cellCreatedListeners) {
                listener.cellCreated(point.x, point.y, FIRST_NUMBER);
            }
            unoccupiedCells.remove(randomIndex);
        }

    }

    private void moveCellsOnCol(int x, int dy) {
        if (dy < 0) {
            for (int y = 0; y < getSize(); y++) {
                moveCell(x, y, 0, dy);
            }
        } else {
            for (int y = getSize() - 1; y >= 0; y--) {
                moveCell(x, y, 0, dy);
            }
        }
    }

    private void moveCellsOnRow(int y, int dx) {
        if (dx < 0) {
            for (int x = 0; x < getSize(); x++) {
                moveCell(x, y, dx, 0);
            }
        } else {
            for (int x = getSize() - 1; x >= 0; x--) {
                moveCell(x, y, dx, 0);
            }
        }
    }

    private void mergeCellsOnCol(int x, int dy) {
        int mergeTargetRow = -1;
        if (dy < 0) {
            for (int y = 0; y < getSize(); y++) {
                mergeTargetRow = performedMergeOnRow(x, y, mergeTargetRow);
            }
        } else {
            for (int y = getSize() - 1; y >= 0; y--) {
                mergeTargetRow = performedMergeOnRow(x, y, mergeTargetRow);
            }
        }
    }

    private int performedMergeOnRow(int x, int y, int mergeTargetRow) {
        int num = getNumber(x, y);
        if (num != 0) {
            if (mergeTargetRow == -1 || getNumber(x, mergeTargetRow) != num) {
                mergeTargetRow = y;
            } else {
                int mergeNum = getNumber(x, mergeTargetRow) + num;
                setNumber(x, mergeTargetRow, mergeNum);
                setNumber(x, y, 0);
                if (mergeNum > maxNumber) {
                    maxNumber = mergeNum;
                }
                for (var listener : cellMergedFromListeners) {
                    listener.cellMergedFrom(x, y, x, mergeTargetRow, mergeNum);
                }
                for (var listener : cellMergedToListeners) {
                    listener.cellMergedTo(x, mergeTargetRow, x, y);
                }
                mergeTargetRow = -1;
            }
        }
        return mergeTargetRow;
    }

    private void mergeCellsOnRow(int y, int dx) {
        int mergeTargetCol = -1;
        if (dx < 0) {
            for (int x = 0; x < getSize(); x++) {
                mergeTargetCol = performedMergeOnCol(x, y, mergeTargetCol);
            }
        } else {
            for (int x = getSize() - 1; x >= 0; x--) {
                mergeTargetCol = performedMergeOnCol(x, y, mergeTargetCol);
            }
        }
    }

    private int performedMergeOnCol(int x, int y, int mergeTargetCol) {
        int num = getNumber(x, y);
        if (num != 0) {
            if (mergeTargetCol == -1 || getNumber(mergeTargetCol, y) != num) {
                mergeTargetCol = x;
            } else {
                int mergeNum = getNumber(mergeTargetCol, y) + num;
                setNumber(mergeTargetCol, y, mergeNum);
                setNumber(x, y, 0);
                if (mergeNum > maxNumber) {
                    maxNumber = mergeNum;
                }
                for (var listener : cellMergedFromListeners) {
                    listener.cellMergedFrom(x, y, mergeTargetCol, y, mergeNum);
                }
                for (var listener : cellMergedToListeners) {
                    listener.cellMergedTo(mergeTargetCol, y, x, y);
                }
                mergeTargetCol = -1;
            }
        }
        return mergeTargetCol;
    }

    private void moveCell(int x, int y, int dx, int dy) {
        if (getNumber(x, y) == 0) return;

        int fromX = x;
        int fromY = y;

        int nextX = x + dx;
        int nextY = y + dy;
        while (areCoordsInside(nextX, nextY) && getNumber(nextX, nextY) == 0) {
            setNumber(nextX, nextY, getNumber(x, y));
            setNumber(x, y, 0);
            x = nextX;
            y = nextY;

            nextX += dx;
            nextY += dy;
        }
        if (fromX != x || fromY != y) {
            for (var listener : cellMovedListeners) {
                listener.cellMoved(fromX, fromY, x, y);
            }
        }
    }

    private boolean areCoordsInside(int x, int y) {
        return x >= 0 && x < getSize() &&
                y >= 0 && y < getSize();
    }
}

public class BonusProblem {
    public static void main(String[] args) {
        int[][] cells = new int[4][4];
        Scanner sc = new Scanner(System.in);

        for (int y = 0; y < cells.length; y++) {
            for (int x = 0; x < cells[0].length; x++) {
                cells[y][x] = sc.nextInt();
            }
        }
        Board board = new Board(cells);

        int cellsToGenerate = 0;
        int move = sc.nextInt();
        switch (move) {
            case 0:
                board.moveLeft(cellsToGenerate);
                break;
            case 1:
                board.moveUp(cellsToGenerate);
                break;
            case 2:
                board.moveRight(cellsToGenerate);
                break;
            case 3:
                board.moveDown(cellsToGenerate);
                break;
        }
        System.out.println(board.toStringWithoutFormatting());
    }
}