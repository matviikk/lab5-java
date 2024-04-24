package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.LabWork;

import java.util.Iterator;
import java.util.TreeSet;
/**
 * Команда для вывода элементов коллекции в порядке убывания.
 */
public class PrintDescending extends AbstractCommand {
    private final TreeSet<LabWork> treeSet;
    /**
     * Конструктор класса PrintDescending.
     * @param treeSet Коллекция лабораторных работ, элементы которой будут выводиться.
     */
    public PrintDescending(TreeSet<LabWork> treeSet) {
        super("print_descending", "вывести элементы коллекции в порядке убывания");
        this.treeSet = treeSet;
    }
    /**
     * Выводит элементы коллекции в порядке убывания.
     */
    public void printDescending() {
        Iterator<LabWork> iterator = treeSet.iterator();
        recursion(iterator);
    }
    /**
     * Рекурсивно выводит элементы коллекции начиная с последнего до первого.
     * @param iterator итератор для коллекции лабораторных работ.
     */
    public void recursion(Iterator<LabWork> iterator) {
        if (iterator.hasNext()) {
            LabWork lb = iterator.next();
            recursion(iterator);
            System.out.println(lb);
        }
    }
    /**
     * Выполняет команду вывода всех элементов коллекции в порядке убывания.
     * @param args Аргументы команды (не используются в этой команде).
     * @throws JsonProcessingException Если происходит ошибка обработки JSON в процессе выполнения команды.
     */
    @Override
    public void execute(String... args) throws JsonProcessingException {
        printDescending();
    }
}
