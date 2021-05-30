package edu.ufp.inf.sd.project.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JobGroupImpl extends UnicastRemoteObject implements JobGroupRI {
    private final int id;

    protected JobGroupImpl(int id) throws RemoteException {
        this.id = id;
    }

    public int getId() {
        return id;
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
