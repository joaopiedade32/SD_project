package edu.ufp.inf.sd.project.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JobGroupRI extends Remote {
    //todo attach & getgroupstatus
    public void detach(String username) throws RemoteException;
    public void requestTask(String username) throws RemoteException;
}
