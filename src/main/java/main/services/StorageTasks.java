package main.services;

import main.dto.Task;
import main.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StorageTasks {

    private List<Task> tasks = new ArrayList<>();
    private int id = 0;

    private TaskRepository taskRepository;

    @Autowired
    public StorageTasks(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public void addTask(Task task) {
        id = id + 1;
        task.setId(id);
        LocalDateTime startDate = LocalDateTime.now();
        int daysCount = task.getDeadline();
        LocalDateTime finishDate = startDate.plusDays(daysCount);

        System.out.println("start time: " + startDate);
        System.out.println("finish time: " + finishDate);

        task.setStartDateTime(LocalDateTime.now());
        task.setFinishDateTime(finishDate);
        tasks.add(task);

        taskRepository.save(task);

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
