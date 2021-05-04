package core.basesyntax.service.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFile(String data) {
        try {
            return Files.readAllLines(Paths.get(data));
        } catch (IOException e) {
            throw new RuntimeException("Can not read from file " + data, e);
        }
    }

    @Override
    public void writeToFile(String data, String file) {
        try {
            Files.writeString(Path.of(file), data);
        } catch (IOException e) {
            throw new RuntimeException("Can not write data to file " + file, e);
        }
    }
}
