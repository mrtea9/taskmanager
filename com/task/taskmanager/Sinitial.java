package com.task.taskmanager;
import java.util.*;
import java.io.*;

public class Sinitial implements Serializable {
    private final String fname;
    private final String lname;
    private final HashMap<String,String> tasks;
    private int count;
    transient Scanner scanner = new Scanner(System.in);
    @Serial
    private static final long serialVersionUID = -1670834558346248929L;

    public Sinitial() {
        System.out.print("Enter first name: ");
        this.fname = scanner.nextLine();
        System.out.print("Enter last name: ");
        this.lname = scanner.nextLine();
        count = 0;
        tasks= new HashMap<>();
    }
    public void addTask(String user) {
            if(tasks.get(user) == null){
               tasks.put(user,new Tasks(user) + "");
            } else {
               tasks.put(user,new Tasks(user) + tasks.get(user));
            }
            count++;
            serialize(tasks);
    }
    public void showTasks() {
        for (String i : tasks.keySet()) {
            System.out.println(tasks.get(i));
        }
    }
    static void serialize(HashMap<String, String> empObj) {
        try {
            FileOutputStream myFileOutStream
                    = new FileOutputStream(
                    "C:\\Users\\User\\IdeaProjects\\stefaniniintern\\src\\tas.ser");
            ObjectOutputStream myObjectOutStream
                    = new ObjectOutputStream(myFileOutStream);
            myObjectOutStream.writeObject(empObj);
            myObjectOutStream.close();
            myFileOutStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String toString() {
        return this.fname + " " + this.lname + " " + this.count;
    }

}
