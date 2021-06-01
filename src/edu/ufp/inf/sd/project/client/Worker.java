package edu.ufp.inf.sd.project.client;

import edu.ufp.inf.sd.project.server.JobShopImpl;
import edu.ufp.inf.sd.project.server.SubjectRI;
import edu.ufp.inf.sd.project.server.User;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Worker extends UnicastRemoteObject implements ObserverRI, Runnable {
    private SubjectRI subject;

    private User user;

    private Thread thread;      //worker thread (begins when we add a woker to the job group)

    private boolean jobState;

    private String username;
    private String password;
    private Scanner scanner;
    private int credits;

    public Worker(User user) throws RemoteException {
        super();
        this.user = user;
        this.thread = new Thread(this);         //instantiating the thread
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public SubjectRI getSubject() {
        return subject;
    }

    @Override
    public void setSubject(SubjectRI subject) {
        this.subject = subject;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public boolean isJobState() {
        return jobState;
    }

    public void setJobState(boolean jobState) {
        this.jobState = jobState;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * gives a update on the job group state
     * @param jobState
     * @throws RemoteException
     */
    @Override
    public void update(boolean jobState) throws RemoteException {

        try {

            this.setJobState(jobState);
            this.stopThread();
        } catch (RemoteException e) {

            e.printStackTrace();
        }
    }

    /**
     * starts the thread
     * @throws RemoteException
     */
    @Override
    public void startThread() throws RemoteException {

        this.getThread().start();
    }

    /**
     * interrupts the thread
     * @throws RemoteException
     */
    @Override
    public void stopThread() throws RemoteException {
        this.getThread().interrupt();
    }

    @Override
    public void update() {

    }

    @Override
    public void run() {

    }


    private void tabuSearch() throws IOException {
        JobShopImpl jobShop = new JobShopImpl();
        System.out.print("filename: ");
        String filename = scanner.nextLine(), delimiter = " ";
        String path = ".//src//edu//ufp//inf//sd//project//data//" + filename + ".txt";
        jobShop.runTS(path);
    }

    private void geneticAlgorithm() throws IOException {
        JobShopImpl jobShop = new JobShopImpl();
        System.out.print("filename: ");
        String filename = scanner.nextLine(), delimiter = " ";
        String path = ".//src//edu//ufp//inf//sd//project//data//" + filename + ".txt";
        //todo GA
    }
}
