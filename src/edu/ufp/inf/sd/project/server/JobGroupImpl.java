package edu.ufp.inf.sd.project.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JobGroupImpl extends UnicastRemoteObject implements JobGroupRI {
    private final int id;
    private final String name;


    protected JobGroupImpl(int id, String name) throws RemoteException {
        this.id = id;
        this.name = name;
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

// assocWorker()
    // setSchedulingState()
    // updateSchedulingState() -> worker
}
