/**
 * 
 */
package ufida.ws;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import net.sf.json.JSONArray;
import net.ufida.info.mahout.model.RecommenderComputerResult;
import net.ufida.info.util.MD5;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

/**
 * @author Steven.yang
 *  ws Test
 */
public class WsClientTest {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ServiceException, RemoteException, MalformedURLException {
//		String url = "http://127.0.0.1:8080/userBehaviorAnalysis/services/RecommenderService?wsdl";
//		Service service = new Service();
//		long userId = 230;
//		int count = 100;
//		int catId= 174;
//		
//		Call call = (Call) service.createCall();
//        call.setTargetEndpointAddress(url);
//        //这里的QName的ns和wsdd文件中的对应
//        QName qn = new QName("urn:RecommenderComputerResult", "RecommenderComputerResult");
//        //这里是将对象序列化和反序列化的配置
//        call.registerTypeMapping(RecommenderComputerResult.class, qn, new BeanSerializerFactory(RecommenderComputerResult.class, qn), new BeanDeserializerFactory(RecommenderComputerResult.class, qn));
//        call.setOperationName("getRecommendDataSubFilter");
//        call.getMessageContext().setUsername("yonyou");// 设置用户名。
//        call.getMessageContext().setPassword("yonyou");// 设置密码
//        call.addParameter("userId", XMLType.XSD_LONG, ParameterMode.IN);
//        call.addParameter("count", XMLType.XSD_INT, ParameterMode.IN);
//        call.addParameter("catId", XMLType.XSD_INT, ParameterMode.IN);
//        call.setReturnClass(List.class);
//        List<RecommenderComputerResult> recommenderComputerResults = (List<RecommenderComputerResult>) call.invoke(new Object[] { userId,count,catId });
////        System.out.println("*************************" + recommenderComputerResults.size());
//        
//        //json 格式
//        JSONArray jsonArray = JSONArray.fromObject(recommenderComputerResults);
//        
//        System.out.println(jsonArray);
		
		String url = "http://localhost:7080/icc_api/services/ServiceApi?wsdl";
		Service service = new Service();
		String companyPk = "1";
		String userName = "admin";
		String password = MD5.getMD5Str("123456");
		
		Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(url);
        //这里的QName的ns和wsdd文件中的对应
//        QName qn = new QName("urn:RecommenderComputerResult", "RecommenderComputerResult");
//        //这里是将对象序列化和反序列化的配置
//        call.registerTypeMapping(RecommenderComputerResult.class, qn, new BeanSerializerFactory(RecommenderComputerResult.class, qn), new BeanDeserializerFactory(RecommenderComputerResult.class, qn));
//        call.setOperationName("getRecommendDataSubFilter");
//        call.getMessageContext().setUsername("yonyou");// 设置用户名。
//        call.getMessageContext().setPassword("yonyou");// 设置密码
        call.addParameter("companyPk", XMLType.XSD_STRING, ParameterMode.IN);
        call.addParameter("userName", XMLType.XSD_STRING, ParameterMode.IN);
        call.addParameter("password", XMLType.XSD_STRING, ParameterMode.IN);
        call.setReturnClass(List.class);
        List<RecommenderComputerResult> recommenderComputerResults = (List<RecommenderComputerResult>) call.invoke(new Object[] { companyPk,userName,password });
//        System.out.println("*************************" + recommenderComputerResults.size());
        
        //json 格式
        JSONArray jsonArray = JSONArray.fromObject(recommenderComputerResults);
        
        System.out.println(jsonArray);
	}
	

}
