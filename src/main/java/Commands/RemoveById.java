package Commands;

import model.LabWork;

import java.util.Objects;
import java.util.TreeSet;
import utility.ScannerManager;

public class RemoveById implements Command {
    ScannerManager scannerManager;
    TreeSet<LabWork> treeSet;

    public RemoveById(ScannerManager scannerManager, TreeSet<LabWork> treeSet) {
        this.scannerManager = scannerManager;
        this.treeSet = treeSet;
    }
    public void removeById(Integer id){
        LabWork temp = null;
        for (LabWork lb: treeSet){
            if (Objects.equals(lb.getId(), id)){
                temp = lb;
            }
        }
        treeSet.remove(temp);
    }

    @Override
    public void execute(String... args) {
        int id = Integer.parseInt(args[0]);
        removeById(id);
    }
}
