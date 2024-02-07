import java.io.FileOutputStream;
import java.io.IOException;

public class Fields {

    private static int combine(int[] field) {
        int combined = 0;
        for (int value : field) {
            combined = (combined << 2) | value;
        }
        return combined;
    }

    public static void setFields() {
        int[] field = {2, 0, 1, 3, 2, 0, 1, 2, 1};
        int combined = combine(field);

        try (FileOutputStream file = new FileOutputStream("field.bin")) {
            file.write((combined >> 16) & 0xFF);
            file.write((combined >> 8) & 0xFF);
            file.write(combined & 0xFF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
