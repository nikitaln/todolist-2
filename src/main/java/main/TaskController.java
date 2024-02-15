package main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "tasks")
public class TaskController {


    private StorageTasks storageTasks = new StorageTasks();


    @GetMapping(value = "/")
    public String getTasks(Model model) {
        System.out.println("get tasks controller");
        model.addAttribute("task", new Task());
        model.addAttribute("tasks", storageTasks.getTasks());
        model.addAttribute("tasksCount", storageTasks.size());
        return "index";
    }


    @PostMapping(value = "/save")
    public String saveTask(Task task) {
        System.out.println("save controller");
        storageTasks.addTask(task);
        return "redirect:/tasks/";
    }


    @PostMapping(value = "/delete")
    public String deleteTask(@RequestParam(name = "btn-remove") int taskIdToRemove) {
        System.out.println("delete controller " + taskIdToRemove);
        if (storageTasks.deleteTask(taskIdToRemove)) {
            return "redirect:/tasks/";
        } else {
            return "index";
        }
    }
}
