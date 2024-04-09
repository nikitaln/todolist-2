package main.services;

import main.dto.Task;
import main.repositories.StatisticsRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    StatisticsRepository statisticsRepository;

    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public void addCompletedTask(Task task) {

    }

    public void addDeletedTask() {

    }

    public void addTaskInProcess(Task task) {
        int userId = task.getUser().getId();
        int statisticsId = statisticsRepository.getStatisticsId(userId);

    }
}
