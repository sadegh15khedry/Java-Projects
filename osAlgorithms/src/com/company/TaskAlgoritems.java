package com.company;


import javafx.scene.control.TableColumn;

import java.util.List;
import java.util.Queue;

public class TaskAlgoritems {
    private int timer;
    private int quantom = 5;
    public void roudRobin(Queue<Task> tasks){

        while (!tasks.isEmpty()){
            Task task = tasks.element();
            int timeLeft = task.getRemainingTime();
            if (timeLeft-quantom<=0){
                task.setRemainingTime(0);
            }
            else {
                task.setRemainingTime(task.getRemainingTime()-quantom);
                tasks.add(task);
            }

        }
    }

    public void shortestJobFirst(List<Task>taskList){
        while (!taskList.isEmpty()){
            int shortestTaskIndex = shortestJobIndexFiner(taskList);
            taskList.get(shortestTaskIndex).setRemainingTime(0);
            taskList.remove(shortestTaskIndex);
        }

    }



    public void shortestremainingJobFirst(List<Task>taskList){
        while (!taskList.isEmpty()){
            int shortestTaskIndex = shortestJobIndexFiner(taskList);
            taskList.get(shortestTaskIndex).setRemainingTime(taskList.get(shortestTaskIndex).getRemainingTime()-quantom);
        }

    }





    public int shortestJobIndexFiner(List<Task>taskList){
        int shortestTaskIndex =0;
        for (int i =1;i<=taskList.size();i++){
            if (taskList.get(i).getRemainingTime()<taskList.get(shortestTaskIndex).getRemainingTime()){
                shortestTaskIndex=i;
            }
        }
        return shortestTaskIndex;
    }


}
