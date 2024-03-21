package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFile {
    private String filePath;

    public OutputFile(String filePath) {
        this.filePath = filePath;
    }

    public void writeContent(String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(content);
        writer.close();
    }
}