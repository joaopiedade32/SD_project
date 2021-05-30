package edu.ufp.inf.sd.project.client;

import edu.ufp.inf.sd.project.server.State;
import edu.ufp.inf.sd.project.server.SubjectRI;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ObserverImpl implements ObserverRI {
    String id;
    State lastObserverState;
    SubjectRI subjectRI;


    public ObserverImpl(String id, SubjectRI subjectRI) throws RemoteException {
        super();
        this.id = id;
        this.subjectRI = subjectRI;
        this.lastObserverState = new State(id, "");
        this.subjectRI.attach(this);
    }

    public ObserverImpl(String id, String[] arg) {
        super();
    }

    public State getLastObserverState() {
        return this.lastObserverState;
    }

    public void update() {
        try {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Update called on client {0}", new Object[]{this.id});
            this.lastObserverState = subjectRI.getState();
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
