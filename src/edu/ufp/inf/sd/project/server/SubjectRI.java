package edu.ufp.inf.sd.project.server;

import edu.ufp.inf.sd.project.client.ObserverRI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SubjectRI extends Remote {

    public boolean isPaused() throws RemoteException;

    public void attach(ObserverRI observerRI) throws RemoteException;

    public void detach(ObserverRI observerRI) throws RemoteException;

    public void notifyAllObservers() throws RemoteException;

    public State getState() throws RemoteException;

    void setState(State state) throws RemoteException;
}
