package edu.ufp.inf.sd.project.client;

import java.util.ArrayList;

public class DataBaseWorkers {

    private final ArrayList<Worker> workers;

    public DataBaseWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    public DataBaseWorkers() {
        workers = new ArrayList<>();
    }

    /**
     * Registar um novo worker.
     *  @param u username
     * @param p password
     * @return
     */
    public boolean register(String u, String p) {
        if (!exists(u, p)) {
            workers.add(new Worker(u, p));
        }
        return false;
    }

    /**
     * verifica as credenciais do worker.
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
}
