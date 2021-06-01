package edu.ufp.inf.sd.project.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JobShopFactoryRI extends Remote {
    /**
     * register
     * @param username
     * @param password
     * @return
     * @throws RemoteException
     */
    public boolean register(String username, String password) throws RemoteException;

    /**
     * login
     * @param username
     * @param password
     * @return
     * @throws RemoteException
     */
    public JobShopSessionRI login(String username, String password) throws RemoteException;

}
