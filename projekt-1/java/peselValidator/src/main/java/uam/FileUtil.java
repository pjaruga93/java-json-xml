package uam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class FileUtil {
    private static final String FILE_NAME = "peselFile_";
    private static final DateFormat dateFormat = new SimpleDateFormat("MM-dd-HH-mm-ss");

    private final String name;
    private List<String> fileContent;

    public FileUtil(String name) {
        this.name = name;
    }

    public void readFile() throws IOException {
        Path newFilePath = Paths.get(name);
        if (!Files.exists(newFilePath)) {
            Files.createFile(newFilePath);
        }

        fileContent = new ArrayList<>(Files.readAllLines(newFilePath, StandardCharsets.UTF_8));
    }

    public void update(String town, String firstName, String lastName, String pesel) throws IOException {
        var lineIndex = containsPesel(pesel);
        var line = String.join(",", town, firstName, lastName, pesel);
        if (lineIndex.isPresent()) {
            fileContent.set(lineIndex.get(), line);
        } else {
            fileContent.add(line);
        }
        Files.write(Paths.get(name), fileContent, StandardCharsets.UTF_8);
    }

    public Optional<Integer> containsPesel(String pesel) {
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).contains(pesel)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public static String generateName() {
        return FILE_NAME + dateFormat.format(new Date()) + ".txt";
    }
}
