/**
 * 
 */
package net.ufida.info.util;

import java.util.ResourceBundle;

/**
 * @author Steven.yang
 * 
 */
public class ResourceManager {
	
	private static ResourceBundle r = null;
	
	static {
		r = ResourceBundle.getBundle("serviceAuthor");
	}

	public final static String getValue(String key) {
		return r.getString(key);
	}

	public final static void refresh() {
		r = ResourceBundle.getBundle("BasicConfig");
	}

	public static void main(String args[]) {
		System.out.println(getValue("egssadmin"));
	}

}
