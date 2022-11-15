import java.util.UUID;

public class Test {

    public static final UUID BASE_UUID = UUID.fromString("00000000-0000-1000-8000-00805F9B34FB");

    public static void main(String[] args) {
        String baseUuid = BASE_UUID.toString();

        baseUuid = baseUuid.replace("-", "");

        String first = baseUuid.substring(0, 4);
        String last = baseUuid.substring(8);

        System.out.println(first);
        System.out.println(last);
    }
}
