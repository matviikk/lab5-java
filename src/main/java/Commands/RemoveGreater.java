package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.LabWork;
import utility.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class RemoveGreater implements Command {
    TreeSet<LabWork> treeSet;
    Scanner scanner;
    public RemoveGreater(Scanner scanner, TreeSet<LabWork> treeSet) {
        this.scanner = scanner;
        this.treeSet = treeSet;
    }
    public void removeGreater(LabWork labWork){
        List<LabWork> temp = new ArrayList<>();
        for (LabWork lb: treeSet){
            if (labWork.compareTo(lb) > 0){
                temp.add(lb);
            }
        }
        for (LabWork lb: temp){
            treeSet.remove(lb);
        }
    }
    @Override
    public void execute(String... args) throws JsonProcessingException {
        LabWork labWork = new Parser(scanner).parseLabWork();
        removeGreater(labWork);
    }
}
