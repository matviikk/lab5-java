package Commands;

import model.LabWork;

import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class RemoveById implements Command {
    Scanner scanner;
    TreeSet<LabWork> treeSet;

    public RemoveById(Scanner scanner, TreeSet<LabWork> treeSet) {
        this.scanner = scanner;
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
