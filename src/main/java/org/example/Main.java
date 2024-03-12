package org.example;

import model.LabWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class Main {
    public static TreeSet<LabWork> treeSet = new TreeSet<>();
    public static void main(String[] args) {
        LabWork labwork = new LabWork();
        LabWork labwork1 = new LabWork();
        LabWork labwork2 = new LabWork();
        LabWork labwork3 = new LabWork();

        treeSet.add(labwork);
        treeSet.add(labwork3);
        treeSet.add(labwork2);
        treeSet.add(labwork1);
        update(1, labwork1);

        System.out.println(treeSet);
    }

    public static void show(){
        System.out.println(treeSet);
    }
    public static void add(LabWork labWork){
        treeSet.add(labWork);
    }
    public static void update(Integer id, LabWork labWork){
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
    public static void removeById(Integer id){
        LabWork temp = null;
        for (LabWork lb: treeSet){
            if (Objects.equals(lb.getId(), id)){
                temp = lb;
            }
        }
        treeSet.remove(temp);
    }
    public static void clear(){
        treeSet = new TreeSet<>();
    }
    public static void removeGreater(LabWork labWork){
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
    public static void removeLower(LabWork labWork){
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
}