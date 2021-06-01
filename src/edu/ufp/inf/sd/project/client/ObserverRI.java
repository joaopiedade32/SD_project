package edu.ufp.inf.sd.project.client;

import edu.ufp.inf.sd.project.server.SubjectRI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObserverRI extends Remote {

    public void update(boolean jobState) throws RemoteException;

    public SubjectRI getSubject() throws RemoteException;

    public void setSubject(SubjectRI subjectRI) throws RemoteException;

    public void startThread() throws RemoteException;

    public void stopThread() throws RemoteException;

    void update();
}
