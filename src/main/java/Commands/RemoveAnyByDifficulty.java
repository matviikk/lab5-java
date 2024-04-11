package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.Difficulty;
import model.LabWork;
import utility.Parser;

import utility.ScannerManager;
import java.util.TreeSet;

public class RemoveAnyByDifficulty implements Command {
    TreeSet<LabWork> treeSet;
    ScannerManager scannerManager;
    public RemoveAnyByDifficulty(ScannerManager scannerManager, TreeSet<LabWork> treeSet) {
        this.scannerManager = scannerManager;
        this.treeSet = treeSet;
    }
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
    @Override
    public void execute(String... args) throws JsonProcessingException {
        Difficulty difficulty = new Parser(scannerManager).parseDifficulty();
        removeAnyByDifficulty(difficulty);
    }
}
