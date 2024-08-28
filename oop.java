public class oop {
    int x;
    final int y = 10; // final: 不可複寫此屬性數值

    // 建構函數，用於初始化物件
    public oop(int newX) {
        x = newX;
    }

    // Static method
    static void myStaticMethod() {
        System.out.println("Static methods can be called without creating objects");
    }

    // Public method
    public void myPublicMethod() {
        System.out.println("Public methods must be called by creating objects");
    }
    
    public static void main(String[] args) {
        oop myObj = new oop(10);
        System.out.println(myObj.x);

        // public 方法無法像static方法能夠直接存取，只能透過物件存取
        myStaticMethod();
        // myPublicMethod(); // bad
        myObj.myPublicMethod(); // good
    }
}
