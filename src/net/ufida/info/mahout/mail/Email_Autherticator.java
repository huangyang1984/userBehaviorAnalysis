/**
 * 
 */
package net.ufida.info.mahout.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author Steven.yang
 * 
 */
public class Email_Autherticator extends Authenticator {
	String username = "huangyangc@yonyou.com";

	String password = "uf0000";

	public Email_Autherticator() {
		super();
	}

	public Email_Autherticator(String user, String pwd) {
		super();
		username = user;
		password = pwd;
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
}