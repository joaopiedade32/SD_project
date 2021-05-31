package edu.ufp.inf.sd.project.server;

import edu.ufp.inf.sd.project.client.ObserverRI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SubjectRI extends Remote {
    /**
     * attach
     * @param obsRI
     * @throws RemoteException
     */
    public void attach(ObserverRI obsRI) throws RemoteException;

    /**
     * detach
     * @param obsRI
     * @throws RemoteException
     */
    public void detach(ObserverRI obsRI) throws RemoteException;

    /**
     * get state
     * @return
     * @throws RemoteException
     */
    public State getState() throws RemoteException;

    /**
     * set state
     * @param state
     * @throws RemoteException
     */
    public void setState(State state) throws RemoteException;
}
