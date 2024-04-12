package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.LabWork;
import utility.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import utility.ScannerManager;

/**
 * Команда для удаления из коллекции всех элементов, которые меньше заданного элемента.
 */
public class RemoveLower implements Command {
    TreeSet<LabWork> treeSet;
    ScannerManager scannerManager;
    /**
     * Конструктор класса RemoveLower.
     * @param scannerManager Менеджер сканера, предоставляющий методы для чтения ввода пользователя.
     * @param treeSet Коллекция лабораторных работ, из которой будут удаляться элементы.
     */
    public RemoveLower(ScannerManager scannerManager, TreeSet<LabWork> treeSet) {
        this.scannerManager = scannerManager;
        this.treeSet = treeSet;
    }
    /**
     * Удаляет все элементы коллекции, которые меньше заданного элемента.
     * @param labWork Элемент, с которым сравниваются элементы коллекции.
     */
    public void removeLower(LabWork labWork){
        List<LabWork> temp = new ArrayList<>();
        for (LabWork lb: treeSet){
            if (labWork.compareTo(lb) < 0){
                temp.add(lb);
            }
        }
        for (LabWork lb: temp){
            treeSet.remove(lb);
        }
    }
    /**
     * Выполняет команду удаления всех элементов коллекции, меньших заданного элемента.
     * @param args Аргументы команды (не используются).
     * @throws JsonProcessingException Если происходит ошибка обработки данных при парсинге элемента.
     */
    @Override
    public void execute(String... args) throws JsonProcessingException {
        LabWork labWork = new Parser(scannerManager).parseLabWork();
        removeLower(labWork);
    }
}
