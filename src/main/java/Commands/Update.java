package Commands;

import model.LabWork;
import utility.Parser;

import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class Update implements Command {
    Scanner scanner;
    TreeSet<LabWork> treeSet;

    public Update(Scanner scanner, TreeSet<LabWork> treeSet) {
        this.scanner = scanner;
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
        LabWork element = new Parser(scanner).parseLabWork();
        update(id, element);
    }
}
