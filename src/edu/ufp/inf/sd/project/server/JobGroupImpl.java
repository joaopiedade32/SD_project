package edu.ufp.inf.sd.project.server;

import edu.ufp.inf.sd.project.client.ObserverRI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class JobGroupImpl extends UnicastRemoteObject implements JobGroupRI {
    private int id;

    private User creator;       //owner

    private ArrayList<ObserverRI> observers = new ArrayList<>();        //workers that will do the job

    private boolean state;      //true: going; false:stopped

    private boolean paused;

    private ArrayList<JobGroupRI> jobs = new ArrayList<>();

    int credits = 500;      //inicial

    private String tsAlgorithm;

    public JobGroupImpl(String tsAlgorithm, User creator) throws RemoteException {
        this.creator = creator;
        this.tsAlgorithm = tsAlgorithm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public ArrayList<ObserverRI> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<ObserverRI> observers) {
        this.observers = observers;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isPaused() {
        return paused;
    }


    @Override
    public void requestTask(String username) throws RemoteException {
        System.out.println("[Server]: " + username + " requested a new task.");


    }

    /**
     * add a observer (worker) to the job group
     *
     * @param observerRI
     * @throws RemoteException
     */
    @Override
    public void attach(ObserverRI observerRI) throws RemoteException {
        this.getObservers().add(observerRI);
    }

    /**
     * removes the observer (worker) from this task
     *
     * @param observerRI
     * @throws RemoteException
     */
    @Override
    public void detach(ObserverRI observerRI) throws RemoteException {
        this.getObservers().remove(observerRI);
    }

    /**
     * when a observer finds the answer, gives a update to all the workers and interrupts the running
     * threads, cause the jobgroup is over
     *
     * @throws RemoteException
     */
    @Override
    public void notifyAllObservers() throws RemoteException {
        for (ObserverRI observerRI : this.observers)
            try {
                observerRI.update(this.state);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public ArrayList<JobGroupRI> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<JobGroupRI> jobs) {
        this.jobs = jobs;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getTsAlgorithm() {
        return tsAlgorithm;
    }

    public void setTsAlgorithm(String tsAlgorithm) {
        this.tsAlgorithm = tsAlgorithm;
    }

    public void delete() {
    }
}
