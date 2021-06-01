package edu.ufp.inf.sd.project.server;

import edu.ufp.inf.sd.project.client.ObserverRI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JobGroupRI extends Remote {

    /**
     * add task to worker
     * @param username
     * @throws RemoteException
     */
    public void requestTask(String username) throws RemoteException;

    void attach(ObserverRI observerRI) throws RemoteException;

    void detach(ObserverRI observerRI) throws RemoteException;

    void notifyAllObservers() throws RemoteException;

}
