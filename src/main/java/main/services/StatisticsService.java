package main.services;

import main.controller.TaskController;
import main.dto.Statistics;
import main.dto.Task;
import main.dto.User;
import main.repositories.StatisticsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    StatisticsRepository statisticsRepository;
    private final Logger logger = LogManager.getLogger(StatisticsService.class);


    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }


    public Statistics createNewStatistics(User user) {
        logger.info("create new statistics for new user");

        Statistics statistics = new Statistics();
        statistics.setUser(user);
        statistics.setCountCompletedTasks(0);
        statistics.setCountDeletedTasks(0);
        statistics.setCountInProcessTasks(0);
        statisticsRepository.save(statistics);
        return statistics;
    }


    public void addCompletedTask(Task task) {
        logger.info("task is completed");

    }


    public void addDeletedTask() {

    }


    public void addTaskInProcess(Task task) {
        logger.info("save new task for user");

        int userId = task.getUser().getId();
        int statisticsId = statisticsRepository.getStatisticsId(userId);
        Statistics statistics = statisticsRepository.findById(statisticsId).get();
        Integer countTasksInProcess = statisticsRepository.findById(statisticsId).get().getCountInProcessTasks();
        countTasksInProcess = countTasksInProcess + 1;
        statistics.setCountInProcessTasks(countTasksInProcess);
        statisticsRepository.save(statistics);
    }
}
