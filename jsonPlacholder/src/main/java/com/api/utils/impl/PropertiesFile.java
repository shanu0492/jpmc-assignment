package com.api.utils.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.api.utils.ReadFile;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PropertiesFile implements ReadFile {
	
	private static final Logger LOG = LogManager.getLogger(PropertiesFile.class);
	private static FileInputStream fis;
	private static Properties prop = null;

	public String readValue(String property) {

		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("env/qa/config.properties").getFile());
			fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch(FileNotFoundException fnfe) {
			LOG.error("Properties File Not Found", fnfe);
		} catch(IOException ioe) {
			LOG.error("IO Exception while loading Properties File", ioe);
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				LOG.error("IO Exception while closing file input stream", e);
			}
		}
		return prop.getProperty(property).trim();
	}
}
