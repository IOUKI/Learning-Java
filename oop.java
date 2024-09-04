import mypack.m1.MyPackageClass; // 依照套件位址來引入
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;

// 繼承
class InheritMyPackClass extends MyPackageClass {
  private int y = 15;
  public void xPlusY() {
    System.out.println(this.y + this.x);
  }
}

// 內部類別
class OuterClass {
  int x = 10;

  class InnerClass {
    int y = 5;

    public int myInnerMethod() {
      return x;
    }
  }

  static class StaticInnerClass {
    int z = 3;
  }
}

// 抽象類別
// 要存取抽象類，必須從另一個類別繼承它
abstract class Animal {
  public abstract void animalSound();
  public void sleep() {
    System.out.println("Zzz");
  }
}
class Pig extends Animal { // 繼承動物的抽象類別
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
}

// 介面
interface MyInterface {
  public void myMethod(); // interface 宣告的方法不需要內容
}
interface SecondInterface {
  public void secondMethod();
}

class MyInterfaceClass implements MyInterface {
  public void myMethod() {
    System.out.println("MyInterfaceClass");
  }
}
// 多種介面
class MultipleInterfaceClass implements MyInterface, SecondInterface {
  public void myMethod() {
    System.out.println("myMethod");
  }
  public void secondMethod() {
    System.out.println("secondMethod");
  }
}

// 執行緒
class MyThread extends Thread {
  public void run() {
    System.out.println("執行緒 output: printSomething");
  }
}

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
  /*
   * Public 為存取修飾詞，表示此方法可以被任何物件存取
   */
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
    
    // 使用引入的套件
    MyPackageClass m1 = new MyPackageClass();
    System.out.print("引入套件 output: ");
    m1.printX();

    // 繼承
    InheritMyPackClass m2 = new InheritMyPackClass();
    System.out.print("繼承 output: ");
    m2.xPlusY();

    // 內部類別
    OuterClass myOuter = new OuterClass();
    OuterClass.InnerClass myInner = myOuter.new InnerClass();
    System.out.println("內部類別 output: " + (myInner.y + myOuter.x));
    OuterClass.StaticInnerClass myStaticInner = new OuterClass.StaticInnerClass();
    System.out.println("靜態內部類別 output: " + (myInner.y + myOuter.x + myStaticInner.z));
    System.out.println("內部類別存取外部類別 output: " + myInner.myInnerMethod());

    // 抽象類別
    Pig myPig = new Pig();
    System.out.print("抽象類別 output: ");
    myPig.animalSound();
    System.out.print("抽象類別 output: ");
    myPig.sleep();

    // 介面
    MyInterfaceClass mif = new MyInterfaceClass();
    System.out.print("介面 output: ");
    mif.myMethod();
    MultipleInterfaceClass mic = new MultipleInterfaceClass();
    System.out.print("多種介面 output: ");
    mic.myMethod();
    System.out.print("多種介面 output: ");
    mic.secondMethod();

    // 枚舉(Enums)
    // enum是一個特殊的類別，代表一組常數(不可改的變量)
    enum Level {
      LOW,
      MEDIUM,
      HIGH
    }
    Level myVar = Level.MEDIUM;
    System.out.println("枚舉(Enums) output: " + myVar);
    switch (myVar) {
      case LOW:
        System.out.println("枚舉(Enums) output: LOW level");
        break;
      case MEDIUM:
        System.out.println("枚舉(Enums) output: MEDIUM level");
        break;
      case HIGH:
        System.out.println("枚舉(Enums) output: HIGH level");
        break;
    }

    // 日期時間
    LocalDate localDateObj = LocalDate.now();
    System.out.println("日期 output: " + localDateObj);
    LocalTime localTimeObj = LocalTime.now();
    System.out.println("時間 output: " + localTimeObj);
    LocalDateTime localDatetimeObj = LocalDateTime.now();
    System.out.println("日期時間 output: " + localDatetimeObj);

    // 陣列列表(ArrayList)
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add(0, "Mazda"); // 指定加入陣列位址
    System.out.println("陣列列表 output: " + cars.size());
    System.out.println("陣列列表 output: " + cars);
    System.out.println("陣列列表 output: " + cars.get(0));
    cars.set(0, "Opel");
    System.out.println("陣列列表 output: " + cars.get(0));
    cars.remove(0);
    System.out.println("陣列列表 output: " + cars);
    Collections.sort(cars);
    System.out.println("陣列列表 output: " + cars);
    // cars.clear();
    // System.out.println("陣列列表 output: " + cars);

    // 鍊表(LinkedList)
    LinkedList<String> animals = new LinkedList<String>();
    animals.add("dog");
    animals.add("pig");
    animals.add("cat");
    System.out.println("鍊表 output: " + animals);

    // 哈希映射(hash map)
    HashMap<String, String> myHashMap = new HashMap<String, String>();
    // Add keys and values (Country, City)
    myHashMap.put("England", "London");
    myHashMap.put("Germany", "Berlin");
    myHashMap.put("Norway", "Oslo");
    myHashMap.put("USA", "Washington DC");
    System.out.println("哈希映射 output: " + myHashMap);
    for (String i : myHashMap.keySet()) {
      System.out.println("哈希映射 output: " + i + "=" + myHashMap.get(i));
    }

    // 哈希集(hash set)
    HashSet<String> myHashSet = new HashSet<String>();
    myHashSet.add("dog");
    myHashSet.add("pig");
    myHashSet.add("cat");
    System.out.println("哈希集 output: " + myHashSet);
    System.out.println("哈希集 檢查項目有無存在 output: " + myHashSet.contains("cat"));

    // 迭代器
    Iterator<String> it = cars.iterator();
    System.out.println("迭代器 output: " + it.next());
    while (it.hasNext()) {
      System.out.println("迭代器 output: " + it.next());
    }

    // 包裝類
    Integer myInt = 5;
    Double myDouble = 5.99;
    Character myChar = 'A';
    System.out.println("包裝類 output: " + myInt.intValue());
    System.out.println("包裝類 output: " + myDouble.doubleValue());
    System.out.println("包裝類 output: " + myChar.charValue());

    // 異常
    int[] myNumbers = {1, 2, 3};
    try {
      System.out.println(myNumbers[10]);
    } catch (Exception e) {
      System.out.println("異常 output: " + e);
    } finally {
      System.out.println("異常 output: finally");
    }

    // 執行緒
    MyThread mt = new MyThread();
    mt.start();

    // Lambda
    ArrayList<Integer> nums = new ArrayList<>();
    nums.add(5);
    nums.add(6);
    nums.add(7);
    nums.add(8);
    nums.add(9);
    Consumer<Integer> method = (n) -> { System.out.println("Lambda output: " + n); };
    nums.forEach(method);
  }
}
