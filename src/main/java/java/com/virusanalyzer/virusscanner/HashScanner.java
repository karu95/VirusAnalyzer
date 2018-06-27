package java.com.virusanalyzer.virusscanner;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;

public class HashScanner {
    private static HashScanner hashScanner;

    public static HashScanner getHashScanner() {

        return hashScanner;
    }

    private HashScanner() {
    }

    public boolean checkHash(String path) {
        boolean virus = false;
        try {
            FileInputStream inputStream = new FileInputStream(new File(path));
            String hash = DigestUtils.md5Hex(inputStream);
            HashList hashList = HashList.getHashList();
            if (hashList.getHashes().contains(hash)){

            } else {

            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return virus;
    }

}
