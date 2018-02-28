package com.qtpselenium.facebook.pom.util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if(extent ==null) {
			Date d = new Date();
			String fileName = d.toString().replaceAll(":", "_").replaceAll(" ","_") + ".html";
			String reportPath = FacebookConstants.REPORTS_PATH+fileName;
			extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir") + "/ExtentReport"));
			extent.addSystemInfo("Selenium Version", "3.8.1").addSystemInfo("Environment", "QA");
		}
		return extent;
	}

}
