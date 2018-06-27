package java.com.virusanalyzer.virusscanner;

import org.apache.commons.codec.digest.DigestUtils;

import java.com.virusanalyzer.reportgenerator.ReportGenerator;
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
        boolean virusDetected = false;
        try {
            FileInputStream inputStream = new FileInputStream(new File(path));
            String hash = DigestUtils.md5Hex(inputStream);
            HashList hashList = HashList.getHashList();
            String desc;
            if (hashList.getHashes().contains(hash)){
                virusDetected = true;
                desc = "Virus detected in file. MD5 Hash = " + hash;
            } else {
                desc = "No virus detected in file. MD5 Hash = " + hash;
            }
            ReportGenerator.writeOnReport(desc);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return virusDetected;
    }

}
