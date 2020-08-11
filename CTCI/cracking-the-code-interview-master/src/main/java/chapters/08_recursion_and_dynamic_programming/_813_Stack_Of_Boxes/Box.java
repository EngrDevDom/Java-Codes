package _813_Stack_Of_Boxes;

public class Box {

    private int height;
    private int width;
    private int depth;

    public Box(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public boolean boxCanBeAbove(Box otherBox){
        return (otherBox == null) || (this.width < otherBox.width && this.height < otherBox.height && this.depth < otherBox.depth);
    }

    @Override
    public String toString() {
        return "Box{" +
                "height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                '}';
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
