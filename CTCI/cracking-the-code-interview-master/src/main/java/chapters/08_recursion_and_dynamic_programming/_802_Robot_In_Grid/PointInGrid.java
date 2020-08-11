package _802_Robot_In_Grid;

import java.util.Objects;

public class PointInGrid {

    public int row;
    public int column;


    public PointInGrid(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointInGrid that = (PointInGrid) o;
        return row == that.row &&
                column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "PointInGrid{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
