package edu.ufp.inf.sd.project.server;

import edu.ufp.inf.sd.project.client.Worker;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class JobGroupImpl extends UnicastRemoteObject implements JobGroupRI {
    private final int id;
    private final String name;
    transient private final HashMap<String, Worker> workers;

    protected JobGroupImpl(int id, String name, HashMap<String, Worker> workers) throws RemoteException {
        this.id = id;
        this.name = name;
        this.workers = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void pause() {
        //todo
    }

    public void delete() {
        //todo
    }

    @Override
    /**
     * detach workers from jobgroup
     */
    public void detach(String username) throws RemoteException {
        this.workers.remove(username);
    }

    @Override
    /**
     * add task to worker
     */
    public void requestTask(String username) throws RemoteException {
        System.out.println("New task requested by " + username);
        //todo: rest
    }

// assocWorker()
    // setSchedulingState()
    // updateSchedulingState() -> worker
}
