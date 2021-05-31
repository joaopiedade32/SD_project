package edu.ufp.inf.sd.project.client;

import edu.ufp.inf.sd.project.server.State;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Observer;

public interface ObserverRI extends Remote, Observer {
    /**
     *
     * @throws RemoteException
     */
    public void update() throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public State getLastObserverState() throws RemoteException;
}
