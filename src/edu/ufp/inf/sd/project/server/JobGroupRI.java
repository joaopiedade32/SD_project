package edu.ufp.inf.sd.project.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JobGroupRI extends Remote {
    //todo attach & getgroupstatus

    /**
     * detach user
     * @param username
     * @throws RemoteException
     */
    public void detach(String username) throws RemoteException;

    /**
     * add task to worker
     * @param username
     * @throws RemoteException
     */
    public void requestTask(String username) throws RemoteException;
}
