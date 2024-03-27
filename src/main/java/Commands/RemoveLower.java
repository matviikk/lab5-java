package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.LabWork;
import org.example.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class RemoveLower implements Command {
    TreeSet<LabWork> treeSet;
    Scanner scanner;
    public RemoveLower(Scanner scanner, TreeSet<LabWork> treeSet) {
        this.scanner = scanner;
        this.treeSet = treeSet;
    }
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
    @Override
    public void execute() throws JsonProcessingException {
        LabWork labWork = Main.parseLabWork(scanner);
        removeLower(labWork);
    }
}
