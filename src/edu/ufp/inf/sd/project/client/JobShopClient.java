package edu.ufp.inf.sd.project.client;

import edu.ufp.inf.sd.project.server.JobGroupRI;
import edu.ufp.inf.sd.project.server.JobShopFactoryRI;
import edu.ufp.inf.sd.project.server.JobShopRI;
import edu.ufp.inf.sd.project.server.JobShopSessionRI;
import edu.ufp.inf.sd.project.util.geneticalgorithm.CrossoverStrategies;
import edu.ufp.inf.sd.project.util.geneticalgorithm.GeneticAlgorithmJSSP;
import edu.ufp.inf.sd.rmi.util.rmisetup.SetupContextRMI;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * Title: Projecto SD</p>
 * <p>
 * Description: Projecto apoio aulas SD</p>
 * <p>
 * Copyright: Copyright (c) 2017</p>
 * <p>
 * Company: UFP </p>
 *
 * @author Rui S. Moreira
 * @version 3.0
 */
public class JobShopClient {

    /**
     * Context for connecting a RMI client MAIL_TO_ADDR a RMI Servant
     */
    private SetupContextRMI contextRMI;
    /**
     * Remote interface that will hold the Servant proxy
     */
    private JobShopRI jobShopRI;
    private Scanner scanner;
    private DataBaseWorkers database;
    private JobShopSessionRI sessionRI;
    private JobShopFactoryRI factoryRI;

    public static void main(String[] args) {
        if (args != null && args.length < 2) {
            System.err.println("usage: java [options] edu.ufp.sd.inf.rmi._01_helloworld.server.HelloWorldClient <rmi_registry_ip> <rmi_registry_port> <service_name>");
            System.exit(-1);
        } else {
            //1. ============ Setup client RMI context ============
            JobShopClient hwc = new JobShopClient(args);
            //2. ============ Lookup service ============
            hwc.lookupService();
            //3. ============ Play with service ============
            hwc.playService();
            //Init Observer
            //todo: initObserver(args);
        }
    }


    public JobShopClient(String args[]) {
        try {
            //List ans set args
            SetupContextRMI.printArgs(this.getClass().getName(), args);
            String registryIP = args[0];
            String registryPort = args[1];
            String serviceName = args[2];
            //Create a context for RMI setup
            contextRMI = new SetupContextRMI(this.getClass(), registryIP, registryPort, new String[]{serviceName});
        } catch (RemoteException e) {
            Logger.getLogger(JobShopClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private Remote lookupService() {
        try {
            //Get proxy MAIL_TO_ADDR rmiregistry
            Registry registry = contextRMI.getRegistry();
            //Lookup service on rmiregistry and wait for calls
            if (registry != null) {
                //Get service url (including servicename)
                String serviceUrl = contextRMI.getServicesUrl(0);
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "going MAIL_TO_ADDR lookup service @ {0}", serviceUrl);

                //============ Get proxy MAIL_TO_ADDR HelloWorld service ============
                jobShopRI = (JobShopRI) registry.lookup(serviceUrl);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "registry not bound (check IPs). :(");
                //registry = LocateRegistry.createRegistry(1099);
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return jobShopRI;
    }

    private void playService() {
        try {
            //============ Call TS remote service ============
            String jsspInstancePath = "edu/ufp/inf/sd/project/data/la01.txt";
            int makespan = this.jobShopRI.runTS(jsspInstancePath);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO,
                    "[TS] Makespan for {0} = {1}",
                    new Object[]{jsspInstancePath, String.valueOf(makespan)});


            //============ Call GA ============
            String queue = "jssp_ga";
            String resultsQueue = queue + "_results";
            CrossoverStrategies strategy = CrossoverStrategies.ONE;
            Logger.getLogger(this.getClass().getName()).log(Level.INFO,
                    "GA is running for {0}, check queue {1}",
                    new Object[]{jsspInstancePath, resultsQueue});
            GeneticAlgorithmJSSP ga = new GeneticAlgorithmJSSP(jsspInstancePath, queue, strategy);
            ga.run();

        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * register users
     * @throws RemoteException
     */
    private void register() throws RemoteException {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (this.database.register(username, password))
            System.out.println("Registered Account Successfully.");
        else
            System.out.println("Username Already Taken, Please Try Again.");
    }

    /**
     * login
     * @throws RemoteException
     */
    private void login() throws RemoteException {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        sessionRI = factoryRI.login(username, password);

        if (sessionRI != null) {
            System.out.println("Successfully Logged In.");
        } else {
            System.out.println("Error Logging in.");
        }
    }

    /**
     * logout
     * @param username
     * @throws RemoteException
     */
    private void logout(String username) throws RemoteException {
        if (this.sessionRI != null) {
            factoryRI.logout(username);
            sessionRI = null;
        }
    }

    /*todo
    private void jobGroupCreate() throws RemoteException {

    }
     */

    /**
     *
     * @throws RemoteException
     */
    private void jobGroupList() throws RemoteException {
        if (this.sessionRI != null) {

            ArrayList<String> groups = this.sessionRI.listJobGroups();
            System.out.println("List of Groups:");
            for (String name : groups)
                System.out.println(name);
        }
    }

    /**
     *
     * @throws RemoteException
     */
    private void jobGroupAddWorker() throws RemoteException {
        if (this.sessionRI != null) {
            System.out.println("Group ID: ");
            String id = scanner.nextLine();
            JobGroupRI jobGroupRI = this.sessionRI.joinJobGroup(Integer.parseInt(id));
            //todo
        }
    }

    /*todo
    private static void initObserver(String[] args) {
        try {
            String username = this.jTextFieldUsername.getText();
            //observer = new ObserverImpl(username, this, args);
            observer = new ObserverImpl(username, this, this.subjectRI);
        } catch (Exception e) {
            Logger.getLogger(ObserverGuiClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }
     */
}
