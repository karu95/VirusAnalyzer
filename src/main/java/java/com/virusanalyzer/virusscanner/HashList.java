package java.com.virusanalyzer.virusscanner;

import java.io.*;
import java.util.ArrayList;

public class HashList {

    private static HashList hashList;

    private ArrayList<String> hashes;

    public static HashList getHashList() {
        if (hashList == null) {
            hashList = new HashList();
        }
        return hashList;
    }

    private HashList(){
        hashes = new ArrayList<String>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader
                    (new File("VirusHashes.txt")));
            String hash;
            while ((hash = bufferedReader.readLine()) != null){
                hashes.add(hash);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getHashes() {
        return hashes;
    }
}
