public class FamilyCensus {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandpa = new Human("Barsik",true, 95);
        Human grandma = new Human("Nika", false, 85);
        Human grandpa2 = new Human("Varsik", true, 90);
        Human grandma2 = new Human("Vika", false, 80);

        Human papa = new Human("Nik", true, 65, grandpa, grandma);
        Human mama = new Human("Tika", false, 55, grandpa2, grandma2);
        Human son = new Human("Kolya", true, 35, papa, mama);
        Human doughter = new Human("Taika", false, 30, papa, mama);
        Human grandson = new Human("Nike", true, 5, son, doughter);

        System.out.println(grandpa);
        System.out.println(grandma);
        System.out.println(grandpa2);
        System.out.println(grandma2);

        System.out.println(papa);
        System.out.println(mama);
        System.out.println(son);
        System.out.println(doughter);
        System.out.println(grandson);

    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father, mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}
