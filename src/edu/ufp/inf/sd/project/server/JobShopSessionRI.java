package edu.ufp.inf.sd.project.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface JobShopSessionRI extends Remote {

    // Groups todo
    public JobGroupRI createJobGroup(String name) throws RemoteException;

    public ArrayList<String> listJobGroups() throws RemoteException;

    public JobGroupRI joinJobGroup(int id) throws RemoteException;

    public void pauseJobGroup(int id) throws RemoteException;

    public void deleteJobGroup(int id) throws RemoteException;

    // User
    public int showCredits() throws RemoteException;

    public void addCredits(int credits) throws RemoteException;
    
    public String showMyUsername() throws RemoteException;

}
