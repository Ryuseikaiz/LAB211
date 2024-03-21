package common;

import java.io.File;

public class Algorithm {

    Validation validation = new Validation();

    public void checkInputPath() {
        System.out.print("Please input Path: ");
        String inputPath = validation.checkInputString();
        File file = new File(inputPath);
        if (file.exists() && file.isFile()) {
            System.out.println("Disk: " + getDisk(inputPath));
            System.out.println("Extention: " + getExtension(inputPath));
            System.out.println("File Name: " + getFileName(inputPath));
            System.out.println("Path: " + getPath(inputPath));
            System.out.println("Folders: " + getFolder(inputPath));
        } else {
            System.err.println("Path not a folder.");
        }
    }

    private String getPath(String inputPath) {

        int fromDisk = inputPath.indexOf("\\");
        if (fromDisk == -1) {
            return "";
        }
        int toNameFile = inputPath.lastIndexOf("\\");
        if (toNameFile < fromDisk) {
            return "";
        }
        return inputPath.substring(fromDisk + 1, toNameFile);
    }

    private String getFileName(String inputPath) {
        int positionFrom = inputPath.lastIndexOf("\\");
        int positionTo = inputPath.lastIndexOf(".");
        return inputPath.substring(positionFrom + 1, positionTo);
    }

    private String getExtension(String inputPath) {
        int positionDot = inputPath.lastIndexOf(".");
        return inputPath.substring(positionDot, inputPath.length());
    }

    private String getDisk(String inputPath) {
        int positionColon = inputPath.indexOf("\\");
        return inputPath.substring(0, positionColon + 1);
    }

    private String getFolder(String path) {
        int positionColon = path.indexOf("\\");
        int positionDot = path.lastIndexOf("\\");
        path = path.substring(positionColon, positionDot);
        String[] splitFile = path.split("\\\\");
        return splitFile[splitFile.length - 1];
    }

}
