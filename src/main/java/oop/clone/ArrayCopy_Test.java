package oop.clone;

import java.util.Arrays;

public class ArrayCopy_Test {

    public static void main(String[] args) {
        Info[] info = {new Info(9999), new Info(6666)};
        Info[] copyInfo = Arrays.copyOf(info, info.length);

        System.out.println("Origin ---------------------------");
        showInfo(copyInfo);

        // 直接修改 copyOf 後的物件
        copyInfo[0].mId = 3333;

        System.out.println("Clone ---------------------------");
        showInfo(copyInfo);

        System.out.println("Origin --------------------------- After clone change");
        showInfo(info);
    }

    private static void showInfo(Info...infos) {
        for(int i = 0; i < infos.length; i++) {
            if(infos[i] == null) {
                System.out.println("null");
                continue;
            }
            System.out.println(infos[i].toString());
        }
        System.out.println();
    }
}


class Info {

    static class Stamp {
        String signature;
    }

    long mId;
    Stamp stamp;

    Info(long id) {
        mId = id;
    }

    public Info createStamp(String s) {
        stamp = new Stamp();
        stamp.signature = s;
        return this;
    }


    @Override
    public String toString() {
        String base = "id = " + mId;
        if(stamp != null) {
            base += (", Stamp = " + stamp.signature);
        }

        return base;
    }
}
