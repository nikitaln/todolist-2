package main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "tasks")
public class TaskController {


    private StorageTasks storageTasks = new StorageTasks();


    @GetMapping(value = "/")
    public String getTasks(Model model) {
        System.out.println("get tasks controller");
        model.addAttribute("task", new Task());
        model.addAttribute("tasks", storageTasks.getTasks());
        return "index";
    }


    @PostMapping(value = "/save")
    public String saveTask(Task task) {
        System.out.println("save controller");
        storageTasks.addTask(task);
        return "redirect:/tasks/";
    }
}
