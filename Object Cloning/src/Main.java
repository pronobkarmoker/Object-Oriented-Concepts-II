public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human s = new Human(20, "Shuvo karmakar");
        //Human twin = new Human(s);

        Human twin = (Human) s.Clone();
        System.out.println(twin.age + " " + twin.name);
    }
}