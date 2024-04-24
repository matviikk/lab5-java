package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.Difficulty;
import model.LabWork;
import utility.Parser;

import utility.ScannerManager;
import java.util.TreeSet;
/**
 * Команда для удаления из коллекции одного элемента с заданной сложностью.
 */
public class RemoveAnyByDifficulty extends AbstractCommand {
    private final TreeSet<LabWork> treeSet;
    ScannerManager scannerManager;
    /**
     * Конструктор класса RemoveAnyByDifficulty.
     * @param scannerManager Менеджер сканера для ввода данных.
     * @param treeSet Коллекция лабораторных работ, из которой будет удаляться элемент.
     */
    public RemoveAnyByDifficulty(ScannerManager scannerManager, TreeSet<LabWork> treeSet) {
        super("remove_any_by_difficulty difficulty", "удалить из коллекции один элемент, значение поля difficulty которого эквивалентно заданному");
        this.scannerManager = scannerManager;
        this.treeSet = treeSet;
    }
    /**
     * Удаляет из коллекции первый найденный элемент с заданной сложностью.
     * @param difficulty Сложность элемента, который необходимо удалить.
     */
    public void removeAnyByDifficulty(Difficulty difficulty){
        LabWork temp = null;
        for (LabWork lb: treeSet){
            if (lb.getDifficulty().equals(difficulty)){
                temp = lb;
            }
        }
        if (temp != null){
            treeSet.remove(temp);
        }
    }
    /**
     * Выполняет команду удаления элемента по сложности.
     * @param args Аргументы команды (не используются).
     * @throws JsonProcessingException Если в процессе выполнения команды произойдет ошибка обработки JSON.
     */
    @Override
    public void execute(String... args) throws JsonProcessingException {
        Difficulty difficulty = new Parser(scannerManager).parseDifficulty();
        removeAnyByDifficulty(difficulty);
    }
}
