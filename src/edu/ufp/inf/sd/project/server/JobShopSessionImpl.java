package edu.ufp.inf.sd.project.server;

import edu.ufp.inf.sd.project.client.ObserverRI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class JobShopSessionImpl extends UnicastRemoteObject implements JobShopSessionRI {

    private DB database;
    private User user;

    public JobShopSessionImpl(DB db) throws RemoteException {
        super();
        this.database = db;
    }

    @Override
    /**
     * create job group
     */
    public JobGroupRI createJobGroup(String tsAlgorithm) throws RemoteException {
        int creditsNeeded = 500;

        if (this.user.getCredits() >= creditsNeeded) {

            JobGroupImpl newJobGroup = new JobGroupImpl(tsAlgorithm, this.user);
            this.database.addJobGroup(newJobGroup);
            this.user.setCredits(this.user.getCredits() - creditsNeeded);

            System.out.println("Spent " + creditsNeeded + " credits to create the new Job Group!");
            return newJobGroup;
        }
        System.out.println("You don't have enough credits (500) to create the new Job Group");
        return null;
    }

    @Override
    /**
     * list job groups
     */
    public ArrayList<String> listJobGroups() throws RemoteException {
        return this.database.listJobGroups();
    }

    @Override
    /**
     * join a job group
     */
    public JobGroupRI joinJobGroup(int id) throws RemoteException {
        ArrayList<JobGroupImpl> jobGroups = this.database.getJobGroups();
        for (JobGroupImpl jobGroup : jobGroups) {
            if (jobGroup.getId() == id) {
                return jobGroup;
            }
        }
        return null;
    }

    @Override
    public ObserverRI createWorker() throws RemoteException {
        return null;
    }

    /**
     * associates a worker to a jobgroup, and a worker thread starts
     *
     * @param worker
     * @param idJob
     * @throws RemoteException
     */
    @Override
    public void associatesWorker(ObserverRI worker, int idJob) throws RemoteException {
/* todo
        if (worker.getSubject() == null) {

            for (SubjectRI jobGroup : database.getJobGroups()) {

                if (jobGroup.getId() == idJob) {

                    jobGroup.attach(worker);
                    worker.setSubject(jobGroup);
                    worker.startThread();
                    break;
                }
            }
        }

 */
    }

    /**
     * desassociates a worker to the job group, and interrupts his thread
     *
     * @param worker
     * @param jobGroupId
     * @throws RemoteException
     */
    @Override
    public void dessacWorker(ObserverRI worker, int jobGroupId) throws RemoteException {

        /*todo
        for (SubjectRI jobGroup : database.getJobGroups()) {

            if (jobGroup.getId() == jobGroupId) {

                if (worker.getSubject().equals(jobGroup)) {

                    jobGroup.detach(worker);
                    worker.setSubject(null);
                    worker.stopThread();
                }
            }
        }

         */
    }

    @Override
    public void pauseJobGroup(int id) throws RemoteException {
        for (JobGroupImpl jobGroup : this.database.getJobGroups())
            if (jobGroup.getId() == id && jobGroup.getCreator().equals(this.user)) {
                jobGroup.setPaused(true);
                System.out.println("The Job Group is paused!");
                break;
            }
    }

    @Override
    public void deleteJobGroup(int id) throws RemoteException {
        ArrayList<JobGroupImpl> jobGroups = this.database.getJobGroups();
        for (JobGroupImpl jobGroup : jobGroups) {
            if (jobGroup.getId() == id) {
                jobGroup.delete();
                this.database.getJobGroups().remove(jobGroup);
            }
        }

    }

    @Override
    public void logout(String username, JobShopSessionRI sessionRI) throws RemoteException {
        database.removeSession(username, sessionRI);
    }

    @Override
    public int showCredits() throws RemoteException {
        return this.user.getCredits();
    }

    @Override
    public void addCredits(int credits) throws RemoteException {
        this.user.setCredits(this.user.getCredits() + credits);
        this.database.updateUser(this.user);
    }

    @Override
    public String showMyUsername() throws RemoteException {
        return this.user.getUsername();
    }

    @Override
    public User getUser() throws RemoteException {
        return this.user;
    }

}
