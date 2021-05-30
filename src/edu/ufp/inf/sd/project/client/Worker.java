package edu.ufp.inf.sd.project.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Worker {

    private String userName;
    private String password;
    private Scanner scanner;
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

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

    /**
     * attempts to read data contained inside files
     * todo: differentiate first line from the rest
     * @throws IOException
     */
    private void getData() throws IOException {
        System.out.print("filename: ");
        String filename = scanner.nextLine(), delimiter = " ";
        BufferedReader br = openBufferedReader(".//src//edu//ufp//inf//sd//project//data//" + filename + ".txt");
        ArrayList<Integer> dataList = new ArrayList<>();
        if (br != null) {
            String line = br.readLine();
            while (line != null) {
                String[] text = line.split(delimiter);
                for (int i = 0; i < line.length(); i++)
                    dataList.add(i, Integer.valueOf(text[0]));
                line = br.readLine();
            }
            br.close();
        }
    }

    /**
     * @param path - Buffered Reader Path
     * @return
     */
    private BufferedReader openBufferedReader(String path) {
        try {
            FileReader fr = new FileReader(path);
            return new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
