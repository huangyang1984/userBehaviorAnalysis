/**
 * 
 */
package net.ufida.info.mahout.mail;

import java.util.Date; 
import java.util.Properties; 
import javax.mail.Address; 
import javax.mail.Authenticator; 
import javax.mail.Message; 
import javax.mail.SendFailedException; 
import javax.mail.Session; 
import javax.mail.Transport; 
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage; 

/**
 * @author Steven.yang
 * 邮件提醒
 */
public class Mail {
	private String host = "mail.yonyou.com";

	private String mail_head_name = "this is head of this mail";

	private String mail_head_value = "this is head of this mail";

//	private String mail_to = "huangyangc@yonyou.com;niemin@yonyou.com";

	private String mail_from = "huangyangc@yonyou.com";

	private String mail_subject = "UserBehaviorAnalyse_Task_Detail";

//	private String mail_body = "this is mail_body of this test mail";

	private String personalName = "行为分析任务执行通知";

	public void sendMail(String mail_body,String[] to) throws SendFailedException {
		try {
			Properties props = new Properties();// 获取系统环境
			Authenticator auth = new Email_Autherticator();// 进行邮件服务用户认证
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");
			System.out.println(props);
			Session session = Session.getDefaultInstance(props, auth);
			// 设置session,和邮件服务器进行通讯
			MimeMessage message = new MimeMessage(session);
			message.setContent("Hello", "text/plain");// 设置邮件格式
			message.setSubject(mail_subject);// 设置邮件主题
			message.setText(mail_body);// 设置邮件内容
			message.setHeader(mail_head_name, mail_head_value);// 设置邮件标题
			message.setSentDate(new Date());// 设置邮件发送时期
			Address address = new InternetAddress(mail_from, personalName);
			message.setFrom(address);// 设置邮件发送者的地址
			String toList = getMailList(to);  
	        InternetAddress[] iaToList = new InternetAddress().parse(toList);  
	        message.setRecipients(Message.RecipientType.TO,iaToList); //收件人 
	        
//			Address toaddress = new InternetAddress(mail_to);// 设置邮件接收者的地址
//			message.addRecipient(Message.RecipientType.TO, toaddress);
			System.out.println(message);
			Transport.send(message);
			System.out.println("Send Mail Ok!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return flag;
	}
	
	/**
	 * 邮件接受人
	 * @param mailArray
	 * @return
	 */
	private String getMailList(String[] mailArray) {
		StringBuffer toList = new StringBuffer();
		int length = mailArray.length;
		if (mailArray != null && length < 2) {
			toList.append(mailArray[0]);
		} else {
			for (int i = 0; i < length; i++) {
				toList.append(mailArray[i]);
				if (i != (length - 1)) {
					toList.append(",");
				}
			}
		}
		return toList.toString();
	}
	
	public static void main(String[] args){
		Mail mail = new Mail();
		String to[]={"yangzqa@yonyou.com","zhangzhenc@yonyou.com","niemin@yonyou.com","huangyangc@yonyou.com"};  
		try {
			mail.sendMail("running success",to);
		} catch (SendFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
