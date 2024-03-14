package main.controller;

import main.dto.StatusType;
import main.repositories.TaskRepository;
import main.repositories.UserRepository;
import main.dto.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;


@Controller
@RequestMapping(value = "tasks")
public class TaskController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    private final Logger logger = LogManager.getLogger(TaskController.class);

    private int id = 0;


    @GetMapping()
    public String getTasks(Model model) {
        logger.info("GET /tasks returns main_page.html");

        model.addAttribute("task", new Task());
        model.addAttribute("tasks", taskRepository.findAll());
        model.addAttribute("tasksCount", taskRepository.count());
        model.addAttribute("usersFromDb", userRepository.findAll());

        model.addAttribute("usersCount", userRepository.count());
        model.addAttribute("users", userRepository.findAll());
        return "main_page";
    }


    @PostMapping(value = "/save")
    public String saveTask(Task task) {
        logger.info("POST /save task to database");

        LocalDate dateNow = LocalDate.now();
        task.setStartDateTask(dateNow);
        task.setFinishDateTask(dateNow.plusDays(task.getDeadline()));
        task.setStatus(StatusType.PROCESS);
        taskRepository.save(task);
        return "redirect:/tasks";
    }


    @PostMapping(value = "/delete")
    public String deleteTask(@RequestParam(name = "btn-remove") int taskIdToRemove) {
        logger.info("POST /delete task from database");

        if (taskRepository.existsById(taskIdToRemove)) {
            taskRepository.deleteById(taskIdToRemove);
            logger.info("Delete task with ID: " + taskIdToRemove);
            return "redirect:/tasks";

        } else {

            return "main_page";
        }
    }


    @PostMapping(value = "/complete")
    public String completeTask(@RequestParam(name = "btn-complete") int taskIdToComplete) {
        logger.info("POST /complete task");
        if (taskRepository.existsById(taskIdToComplete)) {
            Task task = taskRepository.findById(taskIdToComplete).get();
            task.setStatus(StatusType.COMPLETE);
            taskRepository.save(task);
            logger.info("Set status COMPLETE for task with ID: " + taskIdToComplete);
            return "redirect:/tasks";

        } else {
            return "main_page";

        }
    }
}
