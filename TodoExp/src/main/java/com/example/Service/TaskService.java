package com.example.Service;

import com.example.Exception.ResourceNotFoundException;
import com.example.Repo.TaskRepository;
import com.example.entity.Task;
import com.example.entity.TaskStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

   // private final JavaMailSender mailSender;

    public Task createTask(Task task) {
        return taskRepository.save(task);

    }


    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }


    public Task getTask(Long id) throws ResourceNotFoundException {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not Found"));
    }

    public Task updateTask(Long id , Task updatedTask) throws ResourceNotFoundException {

        Task task = getTask(id);
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        task.setDueDate(updatedTask.getDueDate());

//        if(updatedTask.getStatus() == TaskStatus.COMPLETED) {
//            sendTaskCompletionEmail(task);
//        }

        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);

    }

//    public void sendTaskCompletionEmail(Task task) {
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setTo("nikhi@gmal.com");
//        message.setSubject("Task Completed :" + task.getDescription());
//        message.setText("Your Task : " + task.getDescription() + "has Completed");
//
//        mailSender.send(message);
//
//        log.info("Task completion mail sent to Task Id:" task.getId());
//    }
}



