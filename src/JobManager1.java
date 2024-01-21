/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import datastructure.LinkedListQueue;
import datastructure.Node;
import model.Job;

/**
 *
 * @author hoang
 */
// Implement with LinkedListQueue assume that 1 is highest priority
public class JobManager1 {
    public LinkedListQueue jobs;

    public JobManager1() {
        jobs = new LinkedListQueue();
        jobs.enqueue(new Job("Job 2", 2));
        jobs.enqueue(new Job("Job 3", 3));
        jobs.enqueue(new Job("Job 4", 3));
        jobs.enqueue(new Job("Job 5", 4));
    }

    public void showAllJob() {
        if (jobs.isEmpty()) {
            System.out.println("No job remain");
        } else {
            jobs.toStringQueue();
        }
    }

    public void addJob(Job job) {
        try {
            Node current = jobs.head;

            while (current != null) {
                Job currentJob = (Job) current.info;

                // Handle case that job's priority is higher that head's priority
                if (current == jobs.head && currentJob.getPriority() > job.getPriority()) {
                    Node n = new Node(job, current);
                    jobs.head = n;
                    break;
                }

                Job nextJob = (Job) current.next.info;
                if (currentJob.getPriority() <= job.getPriority() && nextJob.getPriority() > job.getPriority()) {
                    Node n = new Node(job, jobs.head);
                    current.next = n;
                    break;
                }

                current = current.next;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void executeNextJob() {
        try {
            if (jobs.isEmpty()) {
                System.out.println("No job remain");
            } else {
                Job j = (Job) jobs.dequeue();
                System.out.println("Execute " + j.getJobName() + "...");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}