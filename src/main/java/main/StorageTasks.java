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


    public boolean deleteTask(int taskIdToRemove) {
        for (Task task : getTasks()) {
            if (task.getId() == taskIdToRemove) {
                tasks.remove(task);
                System.out.println("delete task");
                return true;
            }
        }
        System.out.println("no delete such task");
        return false;
    }
}
