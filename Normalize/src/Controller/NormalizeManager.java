package Controller;

import Model.NormalizeModel;
import View.Menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NormalizeManager extends Menu {

    static String[] menu = {"Input", "Normalize", "Output", "Print the text", "Exit"};
    private NormalizeModel normalizeModel;
    private String content;

    public NormalizeManager() {
        super("Normalize program", menu);
        this.normalizeModel = new NormalizeModel();
    }

    public void execute(int n) {
        switch (n) {
            case 1:
                input();
                break;
            case 2:
                normalize();
                break;
            case 3:
                output();
                break;
            case 4:
                printText();
                break;
            case 5:
                exit();
        }
    }

    private void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input file name: ");
        String fileName = scanner.nextLine();

        try {
            content = normalizeModel.readInputFile(fileName);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private void normalize() {
        // 1 dấu cách giữa các từ 
        content = content.replaceAll("\\s+", " ");

        // 1 dấu cách sau dấu ,
        content = content.replaceAll("\\s*([.,:])\\s*", "$1 ");

        // Xóa khoảng cách trước và sau dấu " "
        content = content.replaceAll("\"\\s+", "\"");
        content = content.replaceAll("\\s+\"", "\"");

        // Viết hoa chữ cái đầu của đoạn
        if (content.length() > 0) {
            content = Character.toUpperCase(content.charAt(0)) + content.substring(1);
        }

        // Viết hoa chữ cái đầu sau dấu chấm
        Pattern pattern = Pattern.compile("(\\.\\s*)([a-z])");
        Matcher matcher = pattern.matcher(content);
        StringBuilder sb = new StringBuilder();
        int lastAppendPosition = 0;
        while (matcher.find()) {
            sb.append(content, lastAppendPosition, matcher.start());
            sb.append(matcher.group(1));
            sb.append(Character.toUpperCase(matcher.group(2).charAt(0)));
            lastAppendPosition = matcher.end();
        }
        sb.append(content.substring(lastAppendPosition));
        content = sb.toString();

        // Xóa dòng trống
        content = content.replaceAll("(?m)^[ \t]*\r?\n", "");

        // Kiểm tra dấu chấm cuối đoạn
        if (!content.trim().endsWith(".")) {
            content = content.trim() + ".";
        }
    }

    private void output() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter output file name: ");
        String fileName = scanner.nextLine();

        try {
            normalizeModel.writeOutputFile(fileName, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printText() {
        System.out.println(content);
    }

    private void exit() {
        System.exit(0);
    }
}
