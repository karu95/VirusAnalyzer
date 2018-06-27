package com.virusanalyzer.reportgenerator;

public class ReportGenerator {

    private static String description;

    public ReportGenerator() {
    }

    public static void writeOnReport(String subDesc) {
        description += ("\n" + subDesc);
    }

    public static String generateReport() {
        return description;
    }

    public static void clear() {
        description = "";
    }
}
