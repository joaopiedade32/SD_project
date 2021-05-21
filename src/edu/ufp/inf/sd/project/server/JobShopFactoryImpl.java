package edu.ufp.inf.sd.project.server;

import edu.ufp.inf.sd.project.client.DataBaseWorkers;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class JobShopFactoryImpl extends UnicastRemoteObject implements JobShopFactoryRI {

    private HashMap<String, JobShopSessionImpl> sessions = new HashMap<>();
    private DataBaseWorkers db;

    public JobShopFactoryImpl(DataBaseWorkers dataBaseWorkers) throws RemoteException {
        super();
        this.db = dataBaseWorkers;
    }

    @Override
    public boolean register(String username, String password) throws RemoteException {
        boolean register = this.db.register(username, password);
        return register;
    }

    @Override
    public JobShopSessionRI login(String username, String password) throws RemoteException {
        if (this.sessions.containsKey(username)) {
            return this.sessions.get(username);
        }
        if (this.db.exists(username, password)) {
            JobShopSessionImpl lib = new JobShopSessionImpl(this.db);
            this.sessions.put(username, lib);

            return lib;
        }
        return null;
    }

    @Override
    public JobShopSessionRI logout(String username) throws RemoteException {
        this.sessions.remove(username);
        return null;
    }
}
