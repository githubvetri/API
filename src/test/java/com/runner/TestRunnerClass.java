package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(dryRun = false, snippets = SnippetType.CAMELCASE, strict = true, plugin = { "pretty",
		"junit:target/cucumber.xml" }, monochrome = true, features = "src\\test\\resources\\Feature", glue = "com.stepdefinition")

public class TestRunnerClass {
	@AfterClass
	public static void afterClass() {
		Reporting.generateJVMReport(
				"E:\\VETRI\\Eclipse Backup\\eclipsebackup\\OMRBranchAPIAutomation\\target\\cucumber.json");
	}

}
