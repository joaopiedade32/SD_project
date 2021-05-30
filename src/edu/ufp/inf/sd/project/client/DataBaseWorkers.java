package edu.ufp.inf.sd.project.client;

import edu.ufp.inf.sd.project.server.JobGroupImpl;

import java.util.ArrayList;

public class DataBaseWorkers {

    private final ArrayList<Worker> workers;
    private final ArrayList<JobGroupImpl> jobGroups;


    public DataBaseWorkers(ArrayList<Worker> workers, ArrayList<JobGroupImpl> jobGroups) {
        this.workers = workers;
        this.jobGroups = jobGroups;
    }

    public DataBaseWorkers() {
        workers = new ArrayList<>();
        jobGroups = new ArrayList<>();
    }

    /**
     * Registar um novo worker.
     *
     * @param u username
     * @param p password
     * @return
     */
    public boolean register(String u, String p) {
        if (!exists(u)) {
            workers.add(new Worker(u, p));
            return true;
        }
        return false;
    }

    /**
     * verifies if username has been taken.
     *
     * @param u username
     * @return
     */
    public boolean exists(String u) {
        for (Worker worker : this.workers) {
            if (worker.getUserName().compareTo(u) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * verifica as credenciais do user.
     *
     * @param u username
     * @param p password
     * @return
     */
    public boolean exists(String u, String p) {
        for (Worker worker : this.workers) {
            if (worker.getUserName().compareTo(u) == 0 && worker.getPassword().compareTo(p) == 0) {
                return true;
            }
        }
        return false;
    }

    public void updateWorker(Worker worker) {
        for (Worker w : this.workers) {
            if (w.getUserName().equals(worker.getUserName())) {
                w.setCredits(worker.getCredits());
            }
        }
    }

    public ArrayList<JobGroupImpl> getJobGroups() {
        return this.jobGroups;
    }

    public ArrayList<String> listJobGroups() {
        ArrayList<String> jobGroupsList = new ArrayList<>();
        for (JobGroupImpl jobGroup : jobGroups) {
            jobGroupsList.add("[" + jobGroup.getId() + "] ");
        }
        return jobGroupsList;
    }
}
