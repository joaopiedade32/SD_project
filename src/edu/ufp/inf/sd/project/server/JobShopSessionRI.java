package edu.ufp.inf.sd.project.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface JobShopSessionRI extends Remote {

    // Groups todo

    /**
     * create job group
     * @param name
     * @return
     * @throws RemoteException
     */
    public JobGroupRI createJobGroup(String name) throws RemoteException;

    /**
     * list job groups
     * @return
     * @throws RemoteException
     */
    public ArrayList<String> listJobGroups() throws RemoteException;

    /**
     * join job group
     * @param id
     * @return
     * @throws RemoteException
     */
    public JobGroupRI joinJobGroup(int id) throws RemoteException;

    /**
     * pause job group
     * @param id
     * @throws RemoteException
     */
    public void pauseJobGroup(int id) throws RemoteException;

    /**
     * delete job group
     * @param id
     * @throws RemoteException
     */
    public void deleteJobGroup(int id) throws RemoteException;

    // Worker
    public int showCredits() throws RemoteException;

    public void addCredits(int credits) throws RemoteException;

    public String showMyUsername() throws RemoteException;

}
