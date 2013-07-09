/**
 * 
 */
package net.ufida.info.util;

import java.util.Properties;

/**@author Jordan	2011-10-28		上午10:03:21
 * 
 */
public class CoreAppConfig {
	private static Properties properties = new Properties();
	static{
		try {
			properties.load(CoreAppConfig.class.getResourceAsStream("/application.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static final String HDFS_SERVER = properties.getProperty("hdfs.server");
	public static final String HIVE_SERVER = properties.getProperty("hive.server");
	public static final long BROWSE_DEEP_MAX = Long.parseLong(properties.getProperty("browse.deep.max"));
	public static final long SESSION_TIME_MAX = Long.parseLong(properties.getProperty("session.time.max"));
	public static final long SESSION_TIME_STEP = Long.parseLong(properties.getProperty("session.time.step"));
	public static final String HIVE_EXEC_SCRATCH_DIR = properties.getProperty("hive.exec.scratchdir");
	
}
