package com.example.Controller;

import com.example.Exception.ResourceNotFoundException;
import com.example.Service.TaskService;
import com.example.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(task));
    }


    @GetMapping("/AllTasks")
    public ResponseEntity<List<Task>>getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTask());
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(taskService.getTask(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) throws ResourceNotFoundException {

        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();


    }
}
