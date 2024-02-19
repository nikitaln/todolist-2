package main.services;

import main.dto.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StorageTasks {

    private List<Task> tasks = new ArrayList<>();
    private int id = 0;


    public void addTask(Task task) {
        id = id + 1;
        task.setId(id);
        LocalDate startDate = LocalDate.now();
        int daysCount = task.getDeadline();
        LocalDate finishDate = startDate.plusDays(daysCount);

        System.out.println("start time: " + startDate);
        System.out.println("finish time: " + finishDate);

        task.setStartDate(LocalDate.now());
        task.setFinishDate(finishDate);
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


    public int size() {
        System.out.println("count tasks: " + tasks.size());
        return tasks.size();
    }
}
