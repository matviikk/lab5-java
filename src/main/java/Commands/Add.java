package Commands;

import model.LabWork;

import java.util.Scanner;
import java.util.TreeSet;
import utility.Parser;
import utility.ScannerManager;
/**
 * Команда для добавления новой лабораторной работы в коллекцию.
 */
public class Add implements Command {
    ScannerManager scannerManager; // Менеджер для обработки ввода пользователя
    TreeSet<LabWork> treeSet; // Коллекция для хранения лабораторных работ
    /**
     * Конструктор класса Add.
     * @param scannerManager Менеджер сканера, предоставляющий методы для чтения ввода пользователя.
     * @param treeSet Коллекция, в которую будет добавлена новая лабораторная работа.
     */
    public Add(ScannerManager scannerManager, TreeSet<LabWork> treeSet) {
        this.scannerManager = scannerManager;
        this.treeSet = treeSet;
    }
    /**
     * Добавляет лабораторную работу в коллекцию.
     * @param labWork Лабораторная работа для добавления.
     */
    public void add(LabWork labWork){
        treeSet.add(labWork);
    }
    /**
     * Выполняет команду добавления лабораторной работы, парся данные ввода пользователя.
     * @param args Аргументы команды (не используются).
     */
    @Override
    public void execute(String... args) {
        LabWork labWork = new Parser(scannerManager).parseLabWork();
        add(labWork);
    }
}
