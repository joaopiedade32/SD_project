package edu.ufp.inf.sd.rmi.util.observer.client;

import edu.ufp.inf.sd.rmi.util.observer.server.State;
import edu.ufp.inf.sd.rmi.util.observer.server.SubjectRI;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObserverImpl implements ObserverRI {
    String id;
    State lastObserverState;
    SubjectRI subjectRI;
    ObserverGuiClient chatFrame;


    public ObserverImpl(String id, ObserverGuiClient f, SubjectRI subjectRI) throws RemoteException {
        super();
        this.id = id;
        this.chatFrame = f;
        this.subjectRI = subjectRI;
        this.lastObserverState = new State(id, "");
        this.subjectRI.attach(this);
    }

    public ObserverImpl(String id, ObserverGuiClient f, String[] arg) {
        super();
    }

    public State getLastObserverState() {
        return this.lastObserverState;
    }

    public void update() {
        try {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Update called on client {0}", new Object[]{this.id});
            this.lastObserverState = subjectRI.getState();
            this.chatFrame.updateTextArea();
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
