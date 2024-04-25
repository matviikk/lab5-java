package Commands;

import model.LabWork;

import java.util.Date;
import java.util.TreeSet;
/**
 * Команда для вывода информации о коллекции лабораторных работ.
 */
public class Info extends AbstractCommand {
    private final TreeSet<LabWork> treeSet;
    /**
     * Конструктор команды Info.
     * @param treeSet Коллекция лабораторных работ, для которой будет выводиться информация.
     */

    public Info(TreeSet<LabWork> treeSet) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.treeSet = treeSet;
    }
    /**
     * Выполняет команду, выводя информацию о коллекции.
     * @param args Аргументы команды (не используются в этой команде).
     */
    @Override
    public void execute(String... args) {
        //System.out.println("date: " + date + " | collection size: " + treeSet.size());
        System.out.println("Collection type: " + treeSet.getClass().getName());
        System.out.println("Initialization date: " + new Date()); // или другая дата инициализации
        System.out.println("Collection size: " + treeSet.size());
        System.out.println("Last save dates of items:");
        for (LabWork labWork : treeSet) {
            System.out.println("ID: " + labWork.getId() + ", Last Save Time: " + labWork.getLastSaveTime());
        }
    }
}
