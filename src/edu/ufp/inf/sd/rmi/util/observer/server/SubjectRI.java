package edu.ufp.inf.sd.rmi.util.observer.server;

import edu.ufp.inf.sd.rmi.util.observer.client.ObserverRI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SubjectRI extends Remote {
    public void attach(ObserverRI obsRI) throws RemoteException;
    public void detach(ObserverRI obsRI) throws RemoteException;
    public State getState() throws RemoteException;
    public void setState(State state) throws RemoteException;
}