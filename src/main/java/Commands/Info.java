package Commands;

import model.LabWork;

import java.util.Date;
import java.util.TreeSet;

public class Info implements Command {
    Date date = new Date();
    TreeSet<LabWork> treeSet;

    public Info(TreeSet<LabWork> treeSet) {
        this.treeSet = treeSet;
    }

    @Override
    public void execute(String... args) {
        System.out.println("date: " + date + " | collection size: " + treeSet.size());
    }
}
