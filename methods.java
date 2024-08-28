public class methods {
    static void printTheDetail(String name, int age) {
        System.out.println("Name: ".concat(name) + ", Age: " + age + '.');
    }

    // 方法重載
    static int plusMethod(int x, int y) {
        return x + y;
    }
    static double plusMethod(double x, double y) {
        return x + y;
    }

    // 遞迴
    // public static int sum(int k) {
    //     if (k > 0) {
    //         return k + sum(k - 1);
    //     } else {
    //         return 0;
    //     }
    // }
    public static int sum(int start, int end) {
        if (end > start) {
            return start + sum(start, end - 1);
        } else {
            return end;
        }
    }

    public static void main(String[] args) {
        printTheDetail("Lan", 24);
        printTheDetail("John", 31);
        int n1 = plusMethod(10, 50);
        double b1 = plusMethod(3.1, 3.2);
        System.out.println(n1);
        System.out.println(b1);
        int result = sum(5, 10);
        System.out.println(result);
    }
}
