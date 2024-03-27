package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.Difficulty;
import model.LabWork;
import org.example.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class RemoveAnyByDifficulty implements Command {
    TreeSet<LabWork> treeSet;
    Scanner scanner;
    public RemoveAnyByDifficulty(Scanner scanner, TreeSet<LabWork> treeSet) {
        this.scanner = scanner;
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
    public void execute() throws JsonProcessingException {
        Difficulty difficulty = Main.parseDifficulty(scanner);
        removeAnyByDifficulty(difficulty);
    }
}
