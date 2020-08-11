public class ParentOfClassSTO {
    public static void main(String[] args) {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public static interface Businessman {
        public void workHard();
    }

    public static class Programmer {
        public void workHard() {}
    }

    public static class CTO extends Programmer implements Businessman {

    }
}
