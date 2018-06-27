package com.virusanalyzer.virusscanner;

import com.virusanalyzer.reportgenerator.ReportGenerator;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;

public class HashScanner {
    private static HashScanner hashScanner;

    public static HashScanner getHashScanner() {
        if (hashScanner == null) {
            hashScanner = new HashScanner();
        }
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
                desc = "Virus detected in file. \nMD5 Hash = " + hash;
            } else {
                desc = "No virus detected in file. \nMD5 Hash = " + hash;
            }
            ReportGenerator.writeOnReport(desc);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return virusDetected;
    }

}
