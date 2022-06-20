package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
public static void generateJVMReport(String JsonFile) {

	File file = new File("E:\\VETRI\\Eclipse Backup\\eclipsebackup\\OMRBranchAPIAutomation\\target");
	
	
	Configuration configuration = new Configuration(file, "OMRBranchAPIAutomation");
	
	List<String> jsonFiles = new ArrayList<String>();
	
	jsonFiles.add(JsonFile);
	
	ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
	
	builder.generateReports();
}		
	}

