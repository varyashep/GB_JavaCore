import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class BackupFiles {

    public static void backupFiles(String path) {
        File directory = new File(path);
        File backupDirectory = new File("./backup");

        if (!backupDirectory.exists()) {
            if (!backupDirectory.mkdir()) {
                System.out.println("Не удалось создать директорию");
                return;
            }
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Не удалось получить список файлов");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                Path source = Paths.get(file.getPath());
                Path destination = Paths.get(backupDirectory.getPath(), file.getName());
                try {
                    Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);

                } catch (IOException e) {
                    System.out.println("Ошибка");
                }
            }
        }
    }

}
