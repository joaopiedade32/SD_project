package edu.ufp.inf.sd.project.client;

import java.io.IOException;

public class Worker {

    private String userName;
    private String password;
    private int credits;

    public Worker(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.credits = 0;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredits() { return credits; }

    public void setCredits(int credits) { this.credits = credits; }

    @Override
    public String toString() {
        return "Worker{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //todo
    private int tabuSearch() throws IOException {

        /*String sBest = first schedule found;
        String bestCandidate = first schedule found;
        ArrayList <String> tabuList = new ArrayList<>();
        tabuList.add(first schedule found);

        for (int i=0; i<listSize; i++){
              sNeighborhood ← getNeighbors(bestCandidate)
              bestCandidate ← sNeighborhood[0]
              for (sCandidate in sNeighborhood)
                   if ( (not tabuList.contains(sCandidate)) and (fitness(sCandidate) > fitness(bestCandidate)) )
                        bestCandidate ← sCandidate
                    end
              end
              if (fitness(bestCandidate) > fitness(sBest))
                sBest ← bestCandidate
              end
              tabuList.push(bestCandidate)
              if (tabuList.size > maxTabuSize)
                tabuList.removeFirst()
              end
        }

        return sBest;
        */

        return 0;
    }
}
