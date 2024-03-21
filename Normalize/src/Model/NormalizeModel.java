package Model;

import java.io.IOException;

public class NormalizeModel {

    public String readInputFile(String filePath) throws IOException {
        InputFile inputFile = new InputFile(filePath);
        return inputFile.readContent();
    }

    public void writeOutputFile(String filePath, String content) throws IOException {
        OutputFile outputFile = new OutputFile(filePath);
        outputFile.writeContent(content);
    }
}