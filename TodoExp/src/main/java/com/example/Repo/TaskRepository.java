package com.example.Repo;

import com.example.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


}
