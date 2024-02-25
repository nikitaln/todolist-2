package main.controller;

import main.repositories.TaskRepository;
import main.repositories.UserRepository;
import main.services.StorageTasks;
import main.dto.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;


@Controller
@RequestMapping(value = "tasks")
public class TaskController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    private StorageTasks storageTasks = new StorageTasks();

    private int id = 0;

    @GetMapping()
    public String getTasks(Model model) {
        System.out.println("get tasks controller");
        model.addAttribute("task", new Task());
        model.addAttribute("tasks", taskRepository.findAll());
        model.addAttribute("tasksCount", taskRepository.count());
        model.addAttribute("usersFromDb", userRepository.findAll());
        return "main_page";
    }


    @PostMapping(value = "/save")
    public String saveTask(Task task) {
        System.out.println("save controller task and userId " + task.getUser().getId() + " userName " + task.getUser().getName());


//        id = id + 1;
//        task.setId(id);
        LocalDateTime startDate = LocalDateTime.now();
        int daysCount = task.getDeadline();
        LocalDateTime finishDate = startDate.plusDays(daysCount);
        task.setStartDateTime(LocalDateTime.now());
        task.setFinishDateTime(finishDate);

        taskRepository.save(task);
        System.out.println("save to DB");
        storageTasks.addTask(task);
        System.out.println("save to List");
        return "redirect:/tasks";
    }


    @PostMapping(value = "/delete")
    public String deleteTask(@RequestParam(name = "btn-remove") int taskIdToRemove) {
        System.out.println("delete controller " + taskIdToRemove);
        if (storageTasks.deleteTask(taskIdToRemove)) {
            //return "redirect:/tasks";
        } else {
            //return "main_page";
        }

        if (taskRepository.existsById(taskIdToRemove)) {
            taskRepository.deleteById(taskIdToRemove);
            System.out.println("delete from DB");
            return "redirect:/tasks";
        } else {
            System.out.println("not exist");
            return "main_page";
        }
    }
}
