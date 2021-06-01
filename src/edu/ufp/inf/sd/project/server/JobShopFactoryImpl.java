package edu.ufp.inf.sd.project.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class JobShopFactoryImpl extends UnicastRemoteObject implements JobShopFactoryRI {

    private HashMap<String, JobShopSessionImpl> sessions = new HashMap<>();
    private DB db;

    public JobShopFactoryImpl(DB DB) throws RemoteException {
        super();
        this.db = DB;
    }

    @Override
    /**
     * register user
     */
    public boolean register(String username, String password) throws RemoteException {
        return this.db.register(username, password);
    }

    @Override
    /**
     * login user
     */
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

}
