package Commands;

import model.LabWork;

import java.util.TreeSet;

public class Clear implements Command {
    TreeSet<LabWork> treeSet;

    public Clear(TreeSet<LabWork> treeSet) {
        this.treeSet = treeSet;
    }
    public void clear(){
        treeSet = new TreeSet<>();
    }
    @Override
    public void execute(String... args) {
        clear();
    }
}
