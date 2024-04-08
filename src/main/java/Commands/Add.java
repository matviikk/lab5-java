package Commands;

import model.LabWork;

import java.util.Scanner;
import java.util.TreeSet;
import utility.Parser;

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
    public void execute(String... args) {
        LabWork labWork = new Parser(scanner).parseLabWork();
        add(labWork);
    }
}
