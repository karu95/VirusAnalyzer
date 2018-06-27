package java.com.virusanalyzer.virusscanner;

import org.apache.commons.io.FilenameUtils;

import java.com.virusanalyzer.reportgenerator.ReportGenerator;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExtensionScanner {

    public static void extensionScan(String pathStr) {
        try {
            Path path = FileSystems.getDefault().getPath(pathStr);
            String contentType = Files.probeContentType(path);
            String extension = FilenameUtils.getExtension(pathStr);
            String desc = "File Content type: " + contentType + "\n" + "File Extension: " + extension;
            ReportGenerator.writeOnReport(desc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
