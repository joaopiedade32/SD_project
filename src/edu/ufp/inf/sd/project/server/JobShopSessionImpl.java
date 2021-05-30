package edu.ufp.inf.sd.project.server;

import edu.ufp.inf.sd.project.client.DataBaseWorkers;
import edu.ufp.inf.sd.project.client.Worker;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class JobShopSessionImpl extends UnicastRemoteObject implements JobShopSessionRI {

    private DataBaseWorkers database;
    private Worker worker;

    public JobShopSessionImpl(DataBaseWorkers db) throws RemoteException {
        super();
        this.database = db;
    }

    @Override
    public JobGroupRI createJobGroup(String name) throws RemoteException {
        //todo
        /*JobGroupImpl jobGroup = new JobGroupImpl(id);
        this.database.addjobgroup;
        return jobGroup;
         */
        return null;
    }

    @Override
    public ArrayList<String> listJobGroups() throws RemoteException {
        return this.database.listJobGroups();
    }

    @Override
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
    public void pauseJobGroup(int id) throws RemoteException {

        ArrayList<JobGroupImpl> jobGroups = this.database.getJobGroups();
        for (JobGroupImpl jobGroup : jobGroups) {
            if (jobGroup.getId() == id) {
                jobGroup.pause();
            }
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
    public int showCredits() throws RemoteException {
        return this.worker.getCredits();
    }

    @Override
    public void addCredits(int credits) throws RemoteException {
        this.worker.setCredits(this.worker.getCredits() + credits);
        this.database.updateWorker(this.worker);
    }

    @Override
    public String showMyUsername() throws RemoteException {
        return this.worker.getUserName();
    }

    // createtask()
    // server -> jobGroup

}
