package Commands;

import model.LabWork;
import utility.Parser;

import java.util.Objects;
import java.util.TreeSet;
import utility.ScannerManager;

public class Update implements Command {
    ScannerManager scannerManager;
    TreeSet<LabWork> treeSet;

    public Update(ScannerManager scannerManager, TreeSet<LabWork> treeSet) {
        this.scannerManager = scannerManager;
        this.treeSet = treeSet;
    }
    public void update(Integer id, LabWork labWork){
        LabWork temp = null;
        for (LabWork lb: treeSet){
            if (Objects.equals(lb.getId(), id)){
                temp = lb;
            }
        }
        treeSet.remove(temp);
        labWork.setId(id);
        treeSet.add(labWork);
    }
    @Override
    public void execute(String... args) {
        int id = Integer.parseInt(args[0]);
        LabWork element = new Parser(scannerManager).parseLabWork();
        update(id, element);
    }
}
