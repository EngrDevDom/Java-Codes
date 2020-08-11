public class Circle3 {
    public Color3 color;

    public static void main(String[] args) {
        Circle3 circle = new Circle3();
        circle.color.setDescription("Red");
        System.out.println(circle.color.getDescription());
    }

    public Circle3() {
        color = new Color3();

    }

    public class Color3 {
        String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
