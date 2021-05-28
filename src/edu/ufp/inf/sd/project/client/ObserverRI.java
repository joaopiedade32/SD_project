package edu.ufp.inf.sd.project.client;

import edu.ufp.inf.sd.project.server.State;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Observer;

public interface ObserverRI extends Remote, Observer {
    public void update() throws RemoteException;

    public State getLastObserverState() throws RemoteException;
}
