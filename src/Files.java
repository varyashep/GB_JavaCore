import java.io.File;
public class Files {

    public static void addPrefixToFiles(String prefix, String files) {
        String[] filenames = files.split(" ");
        for (String filename : filenames) {
            File file = new File(filename);
            if (file.exists()) {
                String newFilename = prefix + filename;
                File newFile = new File(newFilename);
                file.renameTo(newFile);
            }
            else {
                System.out.println("Файл не существует");
            }
        }
    }

}
