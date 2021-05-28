package edu.ufp.inf.sd.rmi.util.observer.server;

import edu.ufp.inf.sd.rmi.util.observer.client.ObserverRI;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Observer;


public class SubjectImpl implements SubjectRI {
    private final State subjectState;
    private final ArrayList<Observer> observers;

    public SubjectImpl(State subjectState) throws RemoteException {
        super();
        this.subjectState = subjectState;
        this.observers = new ArrayList<>();
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            ObserverRI obsRI = (ObserverRI) observer;
            try {
                obsRI.update();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public State getSubjectState() {
        return subjectState;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    @Override
    public void attach(ObserverRI obsRI) throws RemoteException {
        if (!this.observers.contains(obsRI))
            this.observers.add(obsRI);
    }

    @Override
    public void detach(ObserverRI obsRI) throws RemoteException {
        this.observers.remove(obsRI);
    }

    @Override
    public State getState() throws RemoteException {
        return this.subjectState;
    }

    @Override
    public void setState(State state) throws RemoteException {
        this.subjectState.setInfo(state.getInfo());
        this.notifyAllObservers();
    }
}
