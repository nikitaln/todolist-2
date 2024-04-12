package main.services;

import main.dto.Statistics;
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
        System.out.println("Вход, статистика");
        int userId = task.getUser().getId();

        //счетчик
        try {

            int statisticsId = statisticsRepository.getStatisticsId(userId);    // потенциальное исключение
            Statistics statistics = statisticsRepository.findById(statisticsId).get();
            Integer countTasksInProcess = statisticsRepository.findById(statisticsId).get().getCountInProcessTasks();
            countTasksInProcess = countTasksInProcess + 1;
            statistics.setCountInProcessTasks(countTasksInProcess);
            statisticsRepository.save(statistics);
            System.out.println("Успех без исключения");

        } catch (Exception e){
            System.out.println("Исключение");
            Statistics statistics = new Statistics();
            statistics.setCountInProcessTasks(1);
            statistics.setUser(task.getUser());
            statisticsRepository.save(statistics);
            System.out.println("Успех исключения");
        }
    }
}
