//public interface Displayable {
//    String getDisplayText();
//}
public interface Displayable {
    default String getDisplayText() {
        return toString();
    }
}