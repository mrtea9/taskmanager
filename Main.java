import com.task.taskmanager.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Sinitial> persons = new HashMap<>();
        boolean c = true;
        while (c) {
            System.out.println("For adding persons push 1, for adding tasks push 2, for view people push 3, for view tasks push 4, for break push 5");
            int a = Integer.parseInt(scanner.nextLine());
            switch (a) {
                case 1 -> {
                    System.out.print("Enter username: ");
                    String uname = scanner.nextLine();
                    while (persons.containsKey(uname)) {
                        System.out.print("Enter another username, this is taken: ");
                        uname = scanner.nextLine();
                    }
                    persons.put(uname, new Sinitial());
                    serialize(persons);
                }
                case 2 -> {
                    System.out.print("Enter username: ");
                    String user = scanner.nextLine();
                    while (!persons.containsKey(user)) {
                        System.out.println("Not valid username, insert another: ");
                        user = scanner.nextLine();
                    }
                    persons.get(user).addTask(user);
                }
                case 3 -> {
                    System.out.println("Persons: ");
                    HashMap<String, Sinitial> deserialisedPersons = deserialize();
                    for (Sinitial person : deserialisedPersons.values()) {
                        System.out.println(person);
                    }
                }
                case 4 -> {
                    for (String i : persons.keySet()) {
                        persons.get(i).showTasks();
                    }
                }
                case 5 -> c = false;
                default -> System.out.println("Enter another value: ");
            }
        }
    }

    static void serialize(HashMap<String, Sinitial> empObj)  {
        try {
            FileOutputStream myFileOutStream
                    = new FileOutputStream(
                    "C:\\Users\\User\\IdeaProjects\\stefaniniintern\\src\\write.ser");
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

    static HashMap<String, Sinitial> deserialize()  {
        HashMap<String, Sinitial> newHashMap = null;
        try {
            FileInputStream fileInput = new FileInputStream(
                    "C:\\Users\\User\\IdeaProjects\\stefaniniintern\\src\\write.ser");
            ObjectInputStream objectInput
                    = new ObjectInputStream(fileInput);
            newHashMap = (HashMap)objectInput.readObject();
            objectInput.close();
            fileInput.close();
        }

        catch (IOException obj1) {
            obj1.printStackTrace();
        }
        catch (ClassNotFoundException obj2) {
            System.out.println("Class not found");
            obj2.printStackTrace();
        }
        return newHashMap;
    }
}
