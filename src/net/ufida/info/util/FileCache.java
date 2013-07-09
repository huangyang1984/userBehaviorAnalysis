/**
 * 
 */
package net.ufida.info.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Steven.yang
 * 文件缓存类
 */
public class FileCache {
	
	private ArrayList list = new ArrayList();
	
	public FileCache(File file){
		 try {  
	            FileReader fr = new FileReader(file);  
	            BufferedReader br = new BufferedReader(fr);  
	            String line ;  
	            while((line = br.readLine())!=null){  
	                list.add(line);  
	            }  
	            br.close();  
	            
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
		
	}
	
	
	public void bankUp(File desFile){
		StringBuffer sb = new StringBuffer();
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(desFile);
			for(int i = 0;i<list.size();i++){
				sb.append(list.get(i).toString() + "\r\n");
			}
			fileWriter.write(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getLine(int n){  
        if(n<0)return null;  
        System.out.println("#######################" + list.get(n));
        
        return (String) ((n<list.size())? list.get(n):null);  
    }  
	
	public static void main(String[] args) throws IOException{
		FileCache cache = new FileCache(new File("E://data.dat"));
		cache.getLine(1);
		System.out.println("####################" + cache.list.get(0) + "*************" + cache.list.size());
//		cache.bankUp("E:/bankupdata.dat");
	}
	
	
	
	
	
}
