package Commands;

import model.LabWork;
import org.example.Main;

import java.util.Scanner;
import java.util.TreeSet;

public class Add implements Command {
    Scanner scanner;
    TreeSet<LabWork> treeSet;

    public Add(Scanner scanner, TreeSet<LabWork> treeSet) {
        this.scanner = scanner;
        this.treeSet = treeSet;
    }
    public void add(LabWork labWork){
        treeSet.add(labWork);
    }
    @Override
    public void execute() {
        LabWork labWork = Main.parseLabWork(scanner);
        add(labWork);
    }
}
