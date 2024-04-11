package utility;

import java.util.Scanner;

public class ScannerManager {
    Scanner scanner = new Scanner(System.in);
    boolean isReadingFile;
    Scanner fileScanner;

    public String nextLine() {
        if (isReadingFile) {
            return fileScanner.nextLine();
        } else {
            return scanner.nextLine();
        }
    }
    public boolean hasNext() {
        if (isReadingFile) {
            return fileScanner.hasNext();
        } else {
            return scanner.hasNext();
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }


    public boolean isReadingFile() {
        return isReadingFile;
    }

    public void setReadingFile(boolean readingFile) {
        isReadingFile = readingFile;
    }

    public Scanner getFileScanner() {
        return fileScanner;
    }

    public void setFileScanner(Scanner fileScanner) {
        this.fileScanner = fileScanner;
    }
}
