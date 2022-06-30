package oop.clone;

public class ShallowClone implements Cloneable {

    String name;
    String describe;

    @Override
    public ShallowClone clone() {
        System.out.println("ShallowClone Use clone");
        try {
            // clone 是淺拷貝
            return (ShallowClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    ShallowClone() {
        //"1. " 原先建構函數
        System.out.println("Make ShallowClone Store");

        name = "Java";
        describe = "Basic";
    }

    public void print() {
        System.out.println(
                "This hashCode: " +  hashCode() +
                "\nName: " + name + ", " + name.hashCode() +
                "\nDescribe:" + describe + ", " + describe.hashCode());
    }
}



class ShallowMain {

    public static void main(String[] args) {
        System.out.println("\nOriginal----------------Create original Object:");
        ShallowClone original = new ShallowClone();
        original.print();

        System.out.println("\nClone----------------Start clone:");
        ShallowClone clone = original.clone();
        clone.print();

        System.out.println("\nClone----------------Change clone member:");
        original.name = "Android";
        original.describe = "OOP";
        clone.print();

        System.out.println("\nOriginal----------------After clone change, original Object:");
        original.print();
    }
}