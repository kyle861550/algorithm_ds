package oop.singleton;

import oop.singleton.serializable.TestClass;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        makeFile();

        readFile();
    }

    private static void readFile() {
        File in = new File("/home/alienpan/IdeaProjects/algorithm_ds/src/main/java/oop/singleton/serializable/SerialFile");

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(in))) {

            System.out.println("readFile: " + objectInputStream.readObject().hashCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void makeFile() {
        File out = new File("/home/alienpan/IdeaProjects/algorithm_ds/src/main/java/oop/singleton/serializable/SerialFile");

        if(out.exists() && out.delete()) {
            System.out.println("Delete file");
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(out))) {

            TestClass test = TestClass.getInstance();

            objectOutputStream.writeObject(test);
            objectOutputStream.flush();

            System.out.println("makeFile: " + test.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
