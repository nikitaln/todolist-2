package main.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistics {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private int countCompletedTasks;

    private int countDeletedTasks;

    private int countInProcessTasks;


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCountCompletedTasks() {
        return countCompletedTasks;
    }

    public void setCountCompletedTasks(int countCompletedTasks) {
        this.countCompletedTasks = countCompletedTasks;
    }

    public int getCountDeletedTasks() {
        return countDeletedTasks;
    }

    public void setCountDeletedTasks(int countDeletedTasks) {
        this.countDeletedTasks = countDeletedTasks;
    }

    public int getCountInProcessTasks() {
        return countInProcessTasks;
    }

    public void setCountInProcessTasks(int countInProcessTasks) {
        this.countInProcessTasks = countInProcessTasks;
    }
}
