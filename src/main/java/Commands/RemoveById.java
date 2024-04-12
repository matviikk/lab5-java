package Commands;

import model.LabWork;

import java.util.Objects;
import java.util.TreeSet;
import utility.ScannerManager;
/**
 * Команда для удаления элемента из коллекции по его идентификатору (ID).
 */
public class RemoveById implements Command {
    ScannerManager scannerManager;
    TreeSet<LabWork> treeSet;
    /**
     * Конструктор класса RemoveById.
     * @param scannerManager Менеджер сканера для обработки ввода.
     * @param treeSet Коллекция лабораторных работ, из которой будет удален элемент.
     */
    public RemoveById(ScannerManager scannerManager, TreeSet<LabWork> treeSet) {
        this.scannerManager = scannerManager;
        this.treeSet = treeSet;
    }
    /**
     * Удаляет элемент из коллекции по заданному ID.
     * @param id Идентификатор лабораторной работы, которую нужно удалить.
     */
    public void removeById(Integer id){
        LabWork temp = null;
        for (LabWork lb: treeSet){
            if (Objects.equals(lb.getId(), id)){
                temp = lb;
            }
        }
        treeSet.remove(temp);
    }
    /**
     * Выполняет команду удаления элемента по ID.
     * @param args Аргументы команды, где args[0] - ID элемента для удаления.
     */
    @Override
    public void execute(String... args) {
        int id = Integer.parseInt(args[0]);
        removeById(id);
    }
}
