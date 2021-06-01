package edu.ufp.inf.sd.project.server;

import edu.ufp.inf.sd.project.util.geneticalgorithm.CrossoverStrategies;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface JobShopRI extends Remote {
    /**
     * realizes tabu search
     *
     * @param jsspInstance
     * @return
     * @throws RemoteException
     */
    int runTS(String jsspInstance) throws RemoteException;

    /**
     * genetic algorithm
     * @param jsspInstance
     * @param queue
     * @param crossoverStrategy
     * @throws RemoteException
     */
    void runGA(String jsspInstance, String queue, CrossoverStrategies crossoverStrategy) throws RemoteException;
}
