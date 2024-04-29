package utility;

import Commands.Save;
import model.LabWork;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeSet;

public class Runner {
    /**
     * ����� ���� ������������ �����, ������������� �� �� ���������� ���������������.
     */
    private final TreeSet<LabWork> treeSet;
    /**
     * ������� ��������� ������.
     */
    private final Deque<String> history = new ArrayDeque<>();
    /**
     * �������� ��� ��������� ����� �� ������������.
     */
    private final ScannerManager scannerManager;
    /**
     * ����, ����������� �� ��, ������������ �� ���������� ���������.
     */
    private boolean isRunning = true;
    /**
     * �������� ������, ���������� �� ���������� ��������� ������.
     */
    private final CommandManager commandManager;
    private final String path;

    public Runner(TreeSet<LabWork> treeSet, String path) {
        this.treeSet = treeSet;
        this.scannerManager = new ScannerManager();
        this.commandManager = new CommandManager(treeSet, scannerManager, path, this);
        this.path = path;
    }

    public void run(){
        if (!scannerManager.isReadingFile) {
            System.out.println("������� \"help\" ��� ������� �� ��������.");
        }
        while (isRunning) {
            System.out.print("$ ");
            try {
                if (!scannerManager.hasNextLine()) {
                    saveAndExit(); // ����� �������� ���������� � ����� ��� EOF (Ctrl+D)
                }
                String string = scannerManager.nextLine();
                if (string.equals("^C") || string.equals("^Z")){
                    saveAndExit();
                }
                history.addFirst(string);
                if (history.size() > 9) {
                    history.removeLast();
                }
                commandManager.executeCommand(string);
            } catch (Exception e) {
                System.out.println("\u001B[31mError: ������ �����. \u001B[0m");
                System.out.println("\u001B[31mError: ���������� ���������� ���������... \u001B[0m");
                return;
            }
        }
    }
    /**
     * ��������� ���������� � ����� �� ���������, ��� ������ ����������.
     */
    public void saveAndExit() {
        new Save(treeSet, path).save();
        System.out.println("Data saved successfully. Exiting program...");
        System.exit(0);
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Deque<String> getHistory() {
        return history;
    }
}
