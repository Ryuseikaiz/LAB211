package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputFile {
    private String filePath;

    public InputFile(String filePath) {
        this.filePath = filePath;
    }

    public String readContent() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        reader.close();
        return content.toString();
    }
}