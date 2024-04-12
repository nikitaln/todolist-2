package main.repositories;

import main.dto.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {


    @Query(value = "SELECT id FROM statistics WHERE user_id = :userId", nativeQuery = true)
    int getStatisticsId(@Param("userId") int userId);
}
