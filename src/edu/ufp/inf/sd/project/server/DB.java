package edu.ufp.inf.sd.project.server;

import edu.ufp.inf.sd.project.client.Worker;

import java.util.ArrayList;
import java.util.HashMap;

public class DB {

    private static DB db = null;

    private final ArrayList<User> users;

    private final ArrayList<JobGroupImpl> jobGroups;

    private final ArrayList<Worker> workers;

    private final HashMap<String, JobShopSessionRI> sessions;


    private DB() {
        this.users = new ArrayList<>();
        this.jobGroups = new ArrayList<>();
        this.workers = new ArrayList<>();
        this.sessions = new HashMap<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<JobGroupImpl> getJobGroups() {
        return this.jobGroups;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public HashMap<String, JobShopSessionRI> getSessions() {
        return sessions;
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
            users.add(new User(u, p));
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
        for (User user : this.users)
            if (user.getUsername().compareTo(u) == 0)
                return true;
        return false;
    }

    /**
     * verify user credentials
     *
     * @param u username
     * @param p password
     * @return
     */
    public boolean exists(String u, String p) {
        for (User user : this.users)
            if (user.getUsername().compareTo(u) == 0 && user.getPassword().compareTo(p) == 0) return true;
        return false;
    }

    /**
     * returns a user trough his credentials
     *
     * @param username
     * @param password
     * @return
     */
    public User getUserByCredentials(String username, String password) {
        for (User user : this.users)
            if (user.getUsername().compareTo(username) == 0 && user.getPassword().compareTo(password) == 0) return user;
        return null;
    }

    /**
     * creates a new session, once a user logs in
     *
     * @param username
     * @param sessionRI
     */
    public void addSession(String username, JobShopSessionRI sessionRI) {
        sessions.put(username, sessionRI);
    }

    /**
     * removes a session. logout
     *
     * @param username
     * @param sessionRI
     */
    public void removeSession(String username, JobShopSessionRI sessionRI) {
        sessions.remove(username);
    }

    /**
     * updates user within database
     *
     * @param user
     */
    public void updateUser(User user) {
        for (User u : this.users)
            if (user.getUsername().compareTo(u.getUsername()) == 0 && user.getPassword().compareTo(u.getPassword()) == 0) {
                u.setCredits(user.getCredits());
                u.setSessions(user.getSessions());
            }
    }

    /**
     * adds a new job group to the db
     *
     * @param jobGroup
     */
    public void addJobGroup(JobGroupImpl jobGroup) {
        this.jobGroups.add(jobGroup);
    }

    /**
     * adds a new worker to the db
     *
     * @param worker
     */
    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    /**
     * @return list of job groups
     */
    public ArrayList<String> listJobGroups() {
        ArrayList<String> jobGroupsList = new ArrayList<>();
        for (JobGroupRI jobGroup : jobGroups) {
            jobGroupsList.add("[" + jobGroup + "]");
        }
        return jobGroupsList;
    }
}
