package utility;

import Commands.*;
import model.LabWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
/**
 * Менеджер команд, управляющий выполнением всех доступных команд.
 * Хранит множество лабораторных работ и обеспечивает управление ими через консоль.
 */
public class CommandManager {
    public TreeSet<LabWork> treeSet;
    public ScannerManager scannerManager;
    public Map<String, Command> map = new HashMap<String, Command>();
    /**
     * Конструктор инициализирует CommandManager с заданным набором работ, сканером и путем для сохранения.
     *
     * @param treeSet Набор лабораторных работ.
     * @param scannerManager Менеджер для обработки пользовательского ввода.
     * @param path Путь для сохранения данных.
     */
    public CommandManager(TreeSet<LabWork> treeSet, ScannerManager scannerManager, String path) {
        this.treeSet = treeSet;
        this.scannerManager = scannerManager;
        // инициализация команд с их соответствующими обработчиками
        map.put("help", new Help(this));
        map.put("info", new Info(treeSet));
        map.put("show", new Show(treeSet));
        map.put("add", new Add(scannerManager, treeSet));
        map.put("update", new Update(scannerManager, treeSet));
        map.put("remove_by_id", new RemoveById(treeSet));
        map.put("clear", new Clear(treeSet));
        map.put("save", new Save(treeSet, path));
        map.put("exit", new Exit());
        map.put("remove_greater", new RemoveGreater(scannerManager, treeSet));
        map.put("remove_lower", new RemoveLower(scannerManager, treeSet));
        map.put("history", new History());
        map.put("remove_any_by_difficulty", new RemoveAnyByDifficulty(scannerManager, treeSet));
        map.put("average_of_average_point", new AverageOfAveragePoint(treeSet));
        map.put("print_descending", new PrintDescending(treeSet));
        map.put("execute_script", new ExecuteScript(scannerManager));
    }
    /**
     * Возвращает карту всех доступных команд.
     *
     * @return Карта команд.
     */
    public Map<String, Command> getCommands() {
        return map;
    }
}
