public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            // int c = a/b;
            devide(a, b);
            String name = "shuvo";
            if (name.equals("shuvo")) {
                throw new MyException("name is shuvo");

            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("this will always execute");
        }
    }

    static int devide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("please do not devide by zero");
        }
        return a / b;
    }
}