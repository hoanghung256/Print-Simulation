/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import datastructure.ArrayQueue;
import model.Job;

/**
 *
 * @author hoang
 */
public class JobManager {
    private ArrayQueue jobs;

    public JobManager() {
        jobs = new ArrayQueue();
        jobs.enqueue(new Job("Job 1", 1));
        jobs.enqueue(new Job("Job 2", 2));
        jobs.enqueue(new Job("Job 3", 3));
    }

    public void showAllJob() {
        try {
            while (!jobs.isEmpty()) {
                System.out.println(jobs.dequeue());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addJob(Job job) {

    }

    public void executeNextJob() {

    }
}
