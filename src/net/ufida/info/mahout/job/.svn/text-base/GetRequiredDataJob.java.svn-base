/**
 * 
 */
package net.ufida.info.mahout.job;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.SendFailedException;

import net.ufida.info.mahout.mail.Mail;
import net.ufida.info.mahout.manager.SlopeOneManager;

import org.apache.log4j.Logger;

/**
 * @author Steven.yang
 *
 */
public class GetRequiredDataJob {
	
	public static GetRequiredDataJob m_instance;
	
	private Logger logger = Logger.getLogger(GetRequiredDataJob.class);

	public static GetRequiredDataJob instance() {
		if (m_instance == null) {
			synchronized (GetRequiredDataJob.class) {
				if (m_instance == null) {
					m_instance = new GetRequiredDataJob();
				}
			}
		}
		return m_instance;
	}
	
	private  SlopeOneManager slopeOneManager;

	 /**
	 * @return the slopeOneManager
	 */
	public SlopeOneManager getSlopeOneManager() {
		return slopeOneManager;
	}

	/**
	 * @param slopeOneManager the slopeOneManager to set
	 */
	public void setSlopeOneManager(SlopeOneManager slopeOneManager) {
		this.slopeOneManager = slopeOneManager;
	}

	public  void run(){   
		  try {
			  Date date = new Date();
			  String beginDate = new Timestamp(date.getTime()).toString();
			  
			  StringBuffer sb = new StringBuffer();
			  sb.append("定时任务开始执行............,当前执行时间为:" + beginDate + "\r\n");
			  sb.append("开始解析 ++  192.168.100.213 ++ kshop库原始数据" + "\r\n");
			  
			  slopeOneManager.getUnprocessedDataFromKshop(); 
			  sb.append("原始数据处理成功，已写入hadoop相关路径,磁盘文件路径：/opt/ufda/data/mahoutRask/data.dat" + "\r\n");
			  
			  SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			  String endDate = endDateFormat.format(new Date());
			  
			  sb.append("定时任务执行结束，推荐模型数据已刷新.........." + "\r\n");
			  sb.append("可调用webService接口进行一次过滤及二次过滤查询..........");

			  Mail mail = new Mail();
			  String to[]={"yangzqa@yonyou.com","zhangzhenc@yonyou.com","niemin@yonyou.com","huangyangc@yonyou.com"};  
			  mail.sendMail(sb.toString(), to);
		} catch (SendFailedException e) {
			  logger.error("邮件系统error，信息未准确写入......");
		}
     }  
	
	
	public static void main(String[] args){
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		  String date = simpleDateFormat.format(new Date());
//		System.out.println(date);
		  /*
		  Date date = new Date();
			String dateStr2 = new Timestamp(date.getTime()).toString();
			System.out.println(dateStr2);*/
	}
	
}
