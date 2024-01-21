import datastructure.ArrayQueue;
import datastructure.Node;
import model.Job;

/**
 *
 * @author hoang
 */
public class JobManager2 {
    public ArrayQueue jobs;

    public JobManager2() {
        jobs = new ArrayQueue();
        jobs.enqueue(new Job("Job 2", 2));
        jobs.enqueue(new Job("Job 3", 3));
        jobs.enqueue(new Job("Job 4", 3));
        jobs.enqueue(new Job("Job 5", 4));
    }

    public void showAllJob() {
        ArrayQueue tempJobs = new ArrayQueue();

        try {
            Job currentJob = new Job();
            while (!jobs.isEmpty()) {
                currentJob = (Job) jobs.dequeue();
                System.out.println(currentJob);
                tempJobs.enqueue(currentJob);
            }
            while (!tempJobs.isEmpty()) {
                jobs.enqueue(tempJobs.dequeue());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addJob(Job job) {
        try {
            if (jobs.isEmpty()) {
                jobs.enqueue(job);
            } else {
                int i = 0;
                // Find the correct position in the queue for the new job
                while (i <= jobs.last && job.getPriority() >= ((Job) jobs.a[i]).getPriority()) {
                    i++;
                }
                // Insert the new job at the correct position
                jobs.insert(i, job);
            }
            System.out.println("Job " + job.getJobName() + " has been added.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void executeNextJob() {
        try {
            if (!jobs.isEmpty()) {
                Job nextJob = (Job) jobs.dequeue();
                System.out.println("Current execute " + nextJob.getJobName() + "...");
            } else {
                System.out.println("No job remain!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
