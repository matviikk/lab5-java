package Commands;

import model.LabWork;

import java.util.Scanner;
import java.util.TreeSet;
import utility.Parser;
import utility.ScannerManager;

public class Add implements Command {
    ScannerManager scannerManager;
    TreeSet<LabWork> treeSet;
    public Add(ScannerManager scannerManager, TreeSet<LabWork> treeSet) {
        this.scannerManager = scannerManager;
        this.treeSet = treeSet;
    }
    public void add(LabWork labWork){
        treeSet.add(labWork);
    }
    @Override
    public void execute(String... args) {
        LabWork labWork = new Parser(scannerManager).parseLabWork();
        add(labWork);
    }
}
