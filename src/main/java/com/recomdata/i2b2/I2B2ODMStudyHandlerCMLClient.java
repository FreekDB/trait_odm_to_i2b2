package com.recomdata.i2b2;

/**
 * Copyright(c)  2011-2012 Recombinant Data Corp., All rights Reserved
 * This is a handler's command-line client that can loading other source ODM XML files
 * @author: Alex Wu
 * @date: October 28, 2011
 */

import java.io.File;
import java.io.FileNotFoundException;

import nl.vumc.odmtoi2b2.export.OdmToFilesConverter;

import org.apache.log4j.xml.DOMConfigurator;
import org.cdisk.odm.jaxb.ODM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.recomdata.config.Config;
import com.recomdata.i2b2.dao.I2B2DBUtils;
import com.recomdata.odm.ODMLoader;

/**
 * This class will be used by both command-line and web app to load ODM files
 * from different sources.
 * 
 * @author awu
 * 
 */
public class I2B2ODMStudyHandlerCMLClient {
	/**
	 * Whether the export should go to the database (true) or to a file (false).
	 */
	public static final boolean EXPORT_TO_DATABASE = false;

    /**
     * The logger for this class.
     */
    private static final Logger logger = LoggerFactory.getLogger(I2B2ODMStudyHandlerCMLClient.class);

    /**
	 * method to process odm xml file and save data into i2b2
	 * 
	 * @param odmXmlPath the ODM file to process.
	 * @param exportFilePath the path of the export file.
	 * @param propertiesFilePath the file path to the properties.
	 * @throws Exception
	 */
    public void loadODMFile2I2B2(String odmXmlPath, String exportFilePath, final String propertiesFilePath) throws Exception {
		File xmlFile = new File(odmXmlPath);

		if (!xmlFile.exists()) {
            logger.error("ODM file not found: " + odmXmlPath);
			throw new FileNotFoundException(xmlFile.getPath());
		}

		// Load and parse ODM xml here by jaxb
		ODMLoader odmLoader = new ODMLoader();
		ODM odm = odmLoader.unmarshall(xmlFile);

		if (odm == null || odm.getStudy() == null || odm.getStudy().size() == 0) {
			throw new Exception("No study definitions were found in ODM file.");
		}

		// parse ODM XML and save as i2b2 metadata and demodata records
        if (EXPORT_TO_DATABASE) {
            I2B2ODMStudyHandler odmHandler = new I2B2ODMStudyHandler(odm);
            odmHandler.processODM();
        } else {
            OdmToFilesConverter odmHandler = new OdmToFilesConverter();
            odmHandler.processODM(odm, exportFilePath, propertiesFilePath);
            odmHandler.closeExportWriters();
        }
    }

	/**
	 * main method for command-line user
	 * 
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
        try {
			DOMConfigurator.configure(args[0]);

			if (args.length < 3) {
				logger.info("Please provide 1. the logging configuration (log4j.properties), "
						    + "2. the ODM file (plus path) to process, and "
						    + "3. the path of the export directory (without slash).");
				return;
			}

			String odmFilePath = args[1];
            String exportFilePath = args[2];

			if (EXPORT_TO_DATABASE) {
                logger.info("Initializing database connection...");
				Config config = Config.getConfig();
				I2B2DBUtils.init(config);
			}

            logger.info("Parsing ODM file ..." + odmFilePath);

			I2B2ODMStudyHandlerCMLClient client = new I2B2ODMStudyHandlerCMLClient();
			client.loadODMFile2I2B2(odmFilePath, exportFilePath, "ODM-to-i2b2.properties");

			if (EXPORT_TO_DATABASE) {
                logger.info("Releasing database connection.");
				I2B2DBUtils.shutdown();
			}

            logger.info("Processing complete.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
