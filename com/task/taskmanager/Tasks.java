package com.task.taskmanager;

import java.io.*;
import java.util.*;


public class Tasks implements Serializable {
    @Serial
    private static final long serialVersionUID = -1670834558346248929L;
    public String uname;
    private final String taskn;
    private final String taskd;
    transient Scanner scanner = new Scanner(System.in);

    public Tasks(String user){
        this.uname=user;
        System.out.print("Enter Task Title: ");
        this.taskn = scanner.nextLine();
        System.out.print("Enter Task Description: ");
        this.taskd = scanner.nextLine();
    }


    public String toString() {
        return this.uname + " Task: " + this.taskn + " Description: " + this.taskd + "\n";
    }
}
