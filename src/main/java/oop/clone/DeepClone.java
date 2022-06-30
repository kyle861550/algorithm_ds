package oop.clone;

import java.util.ArrayList;
import java.util.List;

public class DeepClone implements Cloneable {

    String name;
    String describe;

    List<Integer> number = new ArrayList<>();

    @Override
    public DeepClone clone() {
        System.out.println("DeepClone Use clone");

        try {
            DeepClone clone = (DeepClone) super.clone();

            clone.name = clone.describe = "";
            clone.number = new ArrayList<>(this.number);

            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    DeepClone() {
        //"1. " 原先建構函數
        System.out.println("Make DeepClone Store");

        name = "Java";
        describe = "Basic";
        number.add(1111);
    }

    public void print() {
        System.out.println(
                "This hashCode: " +  hashCode() +
                        "\nName: " + name + ", " + name.hashCode() +
                        "\nDescribe: " + describe + ", " + describe.hashCode() +
                        "\nNumber: " + number.toString()
                );
    }
}

class DeepMain {

    public static void main(String[] args) {
        System.out.println("\nOriginal----------------Create original Object:");
        DeepClone original = new DeepClone();
        original.print();

        System.out.println("\nClone----------------Start clone:");
        DeepClone clone = original.clone();
        clone.print();

        System.out.println("\nClone----------------Change clone member:");
        clone.name = "Android";
        clone.describe = "OOP";
        clone.number.add(9999);
        clone.print();

        System.out.println("\nOriginal----------------After clone change, original Object:");
        original.print();
    }
}