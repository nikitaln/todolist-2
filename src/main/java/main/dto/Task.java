package main.dto;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String taskName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDate startDateTask;

    private LocalDate finishDateTask;

    private int deadline;
    @Column(name = "status", nullable = true)
    @Enumerated(EnumType.STRING)

    private StatusType status;

    private String description;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getStartDateTask() {
        return startDateTask;
    }

    public void setStartDateTask(LocalDate startDateTask) {
        this.startDateTask = startDateTask;
    }

    public LocalDate getFinishDateTask() {
        return finishDateTask;
    }

    public void setFinishDateTask(LocalDate finishDateTask) {
        this.finishDateTask = finishDateTask;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
