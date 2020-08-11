import java.awt.*;

public class OneMethodInClass {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        Color getColor();
        String getName();
        Integer getAge();
    }

    public abstract static class Fox implements Animal {
        @Override
        public String getName() {
            return "Fox";
        }
    }
}
