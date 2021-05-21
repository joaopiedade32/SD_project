package edu.ufp.inf.sd.project.server;

import edu.ufp.inf.sd.project.client.DataBaseWorkers;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JobShopSessionImpl extends UnicastRemoteObject implements JobShopSessionRI {

    private DataBaseWorkers database;

    public JobShopSessionImpl(DataBaseWorkers db) throws RemoteException {
        super();
        this.database = db;
    }

    // createtask()
    // server -> jobGroup

}
