package edu.ufp.inf.sd.project.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JobShopFactoryRI extends Remote {
    public boolean register(String username, String password) throws RemoteException;
    public JobShopSessionRI login(String username, String password) throws RemoteException;
    public JobShopSessionRI logout(String username) throws RemoteException;
}
