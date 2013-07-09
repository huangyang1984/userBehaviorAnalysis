package net.ufida.info.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.apache.log4j.Logger;


public class HDFSUtils {
	private static final Logger log = Logger.getLogger(HDFSUtils.class);
	private static String HDFS_SERVER = "hdfs://" + CoreAppConfig.HDFS_SERVER;
	private static String TEMP_DIR = "/opt/ufda/temp/";
	
	/**
	 * 读文件
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void readFromHdfs(String path) throws FileNotFoundException,IOException {
	      System.out.println("===================读文件==================" + path);
		  Configuration conf = new Configuration();
		  FileSystem fs = FileSystem.get(URI.create(HDFS_SERVER + path), conf);
		  FSDataInputStream hdfsInStream = fs.open(new Path(HDFS_SERVER + path));
		  String s = "";
		  while (s != null) {
			s = hdfsInStream.readLine();
			if(s != null){
				System.out.println(s);
			}
		  }
		  hdfsInStream.close();
		  fs.close();
	 }
	
	//copy the file from HDFS to local
	public static void getFile(String srcFile, String dstFile) throws IOException {
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(HDFS_SERVER + srcFile), conf);
		Path srcPath = new Path(HDFS_SERVER + srcFile);
		Path dstPath = new Path(dstFile);
		fs.copyToLocalFile(true, srcPath, dstPath);
	}
	
	
	/**
	 * 遍历HDFS上的文件和目录
	 */

	public static void getDirectoryFromHdfs(String dir) throws FileNotFoundException,IOException {
		 System.out.println("===================遍历文件==================" + dir);
		  Configuration conf = new Configuration();
		  FileSystem fs = FileSystem.get(URI.create(HDFS_SERVER + dir), conf);
		  FileStatus fileList[] = fs.listStatus(new Path(HDFS_SERVER + dir));
		  int size = fileList.length;
		  for(int i = 0; i < size; i++){
			  System.out.println("name:" + fileList[i].getPath().getName() + "\t\tsize:" + fileList[i].getLen());
		  }
		  fs.close();
	 }
	 
	 /**
	  * 创建文件夹
	  * 如果没有写权限，可以配置hdfs-site.xml：
	  * <property>
                <name>dfs.permissions</name>
                <value>false</value>
        </property>
	  * @param dir
	  * @throws IOException
	  */
	public static void createHdfsDir(String dir) throws IOException{
		 System.out.println("===================创建文件夹==================" + dir);
		 short ap = 755;
		 Configuration conf = new Configuration();
		 FileSystem fs = FileSystem.get(URI.create(HDFS_SERVER + dir), conf);
		 FsPermission fp = new FsPermission(ap);
		 fs.mkdirs(fs,new Path(HDFS_SERVER + dir),fp);

		 fs.close();
	 }
	 
	/**
	  * 创建文件
	  */
	public static void createFile(String path) throws Exception{
		 System.out.println("===================创建文件==================" + path);
		 Configuration conf = new Configuration();
		 FileSystem fs = FileSystem.get(URI.create(HDFS_SERVER + path),conf);
		 OutputStream out = fs.create(new Path(HDFS_SERVER + path), new Progressable() {
			@Override
			public void progress() {
				System.out.println("=========process...");
			}
		});
		 out.close();
		 fs.close();
	 }
	 /**
	  * 写内容到文件中.
	  * 如果文件不存在，则异常。
	  * 如果在hdfs-site.xml中配置了
	  * 		<property>
               	<name>dfs.support.append</name>
               	<value>true</value>
               </property>,
                 则可以把内容append到已存在的文件末尾，否则覆盖原文件。
	  */
	public static void createAndWriteHdfsFile(String filePath, String value) throws FileNotFoundException,IOException {
		 System.out.println("===================写文件==================" + filePath + "========" + value);
		 Configuration conf = new Configuration();
		 FileSystem fs = FileSystem.get(URI.create(HDFS_SERVER + filePath), conf);
		 System.out.println("*****************写入hadoop文件路径*******************" + HDFS_SERVER + filePath);

		 FSDataOutputStream hdfsoutput = fs.append(new Path(HDFS_SERVER + filePath));
		 hdfsoutput.write(value.getBytes(),0,value.length());

		 hdfsoutput.close();
		 fs.close();

	 }
	/**
	 * 写数据到临时文件
	 * @author Jordan  2011-10-28 上午10:43:35
	 * @param content
	 * @return	临时文件目录。如果操作失败，则返回null
	 */
	public static String saveTmpFile(String content){
		log.info("===================写数据到临时文件==================");
		try {
			Configuration conf = new Configuration();
			String curTime = String.valueOf(System.currentTimeMillis());
	        String filePath = TEMP_DIR  + curTime;		//生成文件路径
	        System.out.println("filePath = " + URI.create(HDFS_SERVER + filePath));
	        FileSystem fs = FileSystem.get(URI.create(HDFS_SERVER + filePath),conf);
	        OutputStream out = fs.create(new Path(HDFS_SERVER + filePath));
	        out.write(content.getBytes());
	        out.close();
			fs.close();
			return filePath;
		} catch (FileNotFoundException e) {
			log.error("写数据到临时文件失败");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			log.error("写数据到临时文件失败");
			e.printStackTrace();
			return null;
		}
	}
	 
	/**
	  * 删除文件。
	  */
	public static void deleteFile(String path){
		log.info("===================删除文件==================" + path);
		try {
			Configuration conf = new Configuration();
			FileSystem fs = FileSystem.get(URI.create(HDFS_SERVER + path), conf);
			fs.delete(new Path(HDFS_SERVER + path), true);	//级联删除子文件
			fs.close();
		} catch (FileNotFoundException e) {
			log.error("删除文件失败");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("删除文件失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除指定目录下、最后修改时间在指定时间之前的文件夹
	 * @author Jordan.Zhao  2011-12-22 下午05:25:11
	 * @param path
	 * @param date
	 */
	public static void deleteFile(String path, Date date){
		log.info("===================删除文件夹" + path + "下，最后修改时间在" + date + "之前的文件夹======");
		try {
	        Configuration conf = new Configuration();
			FileSystem fs = FileSystem.get(URI.create(HDFS_SERVER + path), conf);
			Path TmpDirPath = new Path(URI.create(HDFS_SERVER + path));
	        FileStatus[] fileStatusArray = fs.listStatus(TmpDirPath);
	        for (FileStatus fileStatus : fileStatusArray) {
	            if(fileStatus.getModificationTime() < date.getTime() ) {
                     fs.delete(fileStatus.getPath(),true);
	            }
	        }
	        fs.close();
		} catch (Exception e) {
			log.info("===================删除文件夹失败======");
		}
	}
	
	
	public static void main(String[] arg) throws Exception{
//		String curTime = String.valueOf(System.currentTimeMillis());
//        String filePath = "/user/hive/temp/" + curTime;		//生成文件路径
//        System.out.println(filePath);
//		Configuration conf = new Configuration();
//		 FileSystem fs = FileSystem.get(URI.create(HDFS_SERVER + filePath), conf);
//		 OutputStream out = fs.create(new Path(HDFS_SERVER + filePath));
//		 out.write("aaaaaaabbbbbbbbbcccccccc".getBytes());
////		 FSDataOutputStream hdfsoutput = fs.append(new Path(HDFS_SERVER + filePath));
////		 hdfsoutput.close();
//		 fs.close();
		
//		deleteFile(CoreAppConfig.HIVE_EXEC_SCRATCH_DIR + "hive_2011-12-15_11-00-00_142_4113540048484378059");
		 
//		deleteFile(CoreAppConfig.HIVE_EXEC_SCRATCH_DIR, DateUtil.getDateFromString("2011-12-16","yyyy-MM-dd"));
		
//		readFromHdfs("/user/hive");
		
//		Configuration conf = new Configuration();
//		  FileSystem fs = FileSystem.get(URI.create(HDFS_SERVER + "/user/hive"), conf);
//		  FSDataInputStream hdfsInStream = fs.open(new Path(HDFS_SERVER + "/user/hive"));
		
//		 HDFSUtils.deleteFile(CoreAppConfig.HIVE_EXEC_SCRATCH_DIR, 
//					new Date(DateUtil.getTodayDate().getTime() + 24 * 60 * 60 * 1000));
		
//		System.out.println(new Date(Long.parseLong("1325088000000")));
		
		
//		saveTmpFile("aaaaaaaaaaa11111111111");
//		 System.out.println("success");
		 
//		 createFile("/tt/test.dat");
//		 createAndWriteHdfsFile("/tt/test.dat", "19039,1866,3" + "\r\n" + "10580,1869,2" + "\r\n" + "20079,1865,1" + "\r\n");
////		 readFromHdfs("/lory/test1.txt");
//		 deleteFile("/lory/test1.txt");
//		 saveTmpFile("TEST");
		 
//		 System.out.println(new Configuration().get("hadoop.tmp.dir"));
//		 InputStream in = new URL("hdfs://dev.localdomain:9000/opt/ufda/temp/1336046072281").openStream();
//		 IOUtils.copyBytes(in,System.out,2048,false);
//		 URI path = new URL("hdfs://dev.localdomain:9000/opt/ufda/temp/1336046072281").toURI();
//		 Configuration conf = new Configuration();
//		 FileSystem fs = FileSystem.get(path, conf);
////	     File tempDataFile = File.createTempFile("mahout-taste-hadoop", "txt");
////	     tempDataFile.deleteOnExit();
//	     fs.copyToLocalFile(new Path("hdfs://dev.localdomain:9000/opt/ufda/temp/1336046072281"), new Path("/opt/ufda/data/tmp/data.dat"));
//		 System.out.println(path);
		 
//		 File file = new File("\\opt\\ufda\\data\\mahoutRask\\data.dat");
//		 System.out.println(file.getPath());
		
		deleteFile("/mahoutRask/data.dat");
	}
}
