package edu.ufp.inf.sd.project.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JobGroupImpl extends UnicastRemoteObject implements JobGroupRI {
    protected JobGroupImpl() throws RemoteException {
    }

    // assocWorker()
    // setSchedulingState()
    // updateSchedulingState() -> worker
}
