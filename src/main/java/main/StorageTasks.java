package main;

import java.util.ArrayList;
import java.util.List;

public class StorageTasks {

    private List<Task> tasks = new ArrayList<>();
    private int id = 0;


    public void addTask(Task task) {
        id = id + 1;
        task.setId(id);
        tasks.add(task);
        System.out.println("save to tasks");
    }

    public List<Task> getTasks() {
        System.out.println("get all tasks");
        return tasks;
    }
}
