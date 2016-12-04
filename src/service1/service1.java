package service1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/martlocs")
public class service1 {
	public static final String MART_INFO_KEY = "52566855766e6a6836397646416344";
	public static final String MART_LOC_KEY = "46526d53586e6a683536654d564778";
	public static ArrayList<MartLoc> martList = new ArrayList<MartLoc>(){{             // ����� ��Ʈ ��ġ����
	        add(new MartLoc("�ż����ȭ��", 127.11, 37.33));
	        add(new MartLoc("�̸�Ʈ�����", 126.96, 37.53));
	        add(new MartLoc("�Ե���Ʈ���￪��", 126.97, 37.56));
	        add(new MartLoc("�̸�Ʈ�̾���", 127.03, 37.61));
	        add(new MartLoc("�����ȭ���̾���", 127.03, 37.61));
	        add(new MartLoc("Ȩ�÷�����������", 126.90, 37.52));
	        add(new MartLoc("�̸�Ʈ���ǵ���", 126.93, 37.52));
	        add(new MartLoc("�̸�Ʈâ����", 127.05, 37.65));
	        add(new MartLoc("Ȩ�÷���������", 127.04, 37.66));
	        add(new MartLoc("�����ȭ��������", 126.94, 37.56));
	        add(new MartLoc("Ȩ�÷���������", 126.85, 37.56));
	        add(new MartLoc("�̸�Ʈ������", 126.86, 37.56));
	        add(new MartLoc("�̸�Ʈ������", 127.05, 37.50));
	        add(new MartLoc("�Ե���ȭ��������", 127.05, 37.50));
	        add(new MartLoc("2001�ƿ﷿�ұ���", 126.93, 37.61));
	        add(new MartLoc("�̸�Ʈ������", 126.92, 37.60));
	        add(new MartLoc("�Ե���ȭ��", 126.77, 37.66));
	        add(new MartLoc("�̸�Ʈû����", 127.02, 37.57));
	        add(new MartLoc("�����ϳ��θ�Ʈ�����", 126.96, 37.53));
	        add(new MartLoc("�Ե���ȭ���̾��� ", 127.03, 37.61));
	        add(new MartLoc("�̸�Ʈ�սʸ���", 127.04, 37.56));
	        add(new MartLoc("�̸�Ʈ������", 127.05, 37.54));
	        add(new MartLoc("�̸�Ʈ�ھ���", 127.073358, 37.538784));
	        add(new MartLoc("�Ե���Ʈ������", 127.10, 37.54));
	        add(new MartLoc("Ȩ�÷������빮��", 127.04, 37.57));
	        add(new MartLoc("�Ե���ȭ��û������", 127.05, 37.58));
	        add(new MartLoc("�̸�Ʈ�����", 127.09, 37.60));
	        add(new MartLoc("Ȩ�÷��������", 127.08, 37.58));
	        add(new MartLoc("�Ե���ȭ�������", 127.06, 37.66));
	        add(new MartLoc("Ȩ�÷����߰���", 127.07, 37.64));
	        add(new MartLoc("�ູ�Ѽ������(�ϳ��θ�Ʈ)", 126.88, 37.53));
	        add(new MartLoc("�̸�Ʈ�ŵ�����", 126.89, 37.51));
	        add(new MartLoc("�ְ��ȭ��", 126.8126, 37.45));
	        add(new MartLoc("�׷��帶Ʈ������", 126.94, 37.55));
	        add(new MartLoc("Ȩ�÷�����������", 126.90, 37.57));
	        add(new MartLoc("�����ȭ��", 126.98, 37.49));
	        add(new MartLoc("�Ե���ȭ����������", 126.91, 37.52));
	        add(new MartLoc("�Ե���ȭ��������", 126.92, 37.49));
	        add(new MartLoc("���̺긶Ʈ", 126.91, 37.71));
	        add(new MartLoc("�ϳ���Ŭ��������", 127.04, 37.46));
	        add(new MartLoc("�Ե���ȭ�������", 127.10, 37.51));
	        add(new MartLoc("Ȩ�÷��������", 127.10, 37.52));
	        add(new MartLoc("�̸�Ʈ������", 127.16, 37.55));
	        add(new MartLoc("Ȩ�÷���������", 127.14, 37.55));
	        add(new MartLoc("���ھƾƿ﷿������", 127.01, 37.51));
	        add(new MartLoc("�ϳ���Ŭ���̾���", 127.03, 37.62));
	        add(new MartLoc("�̸�Ʈ����", 126.87, 37.53));
	        add(new MartLoc("�ż����ȭ��������", 127.00, 37.50));
	        add(new MartLoc("�Ե�����", 128.62, 38.08));
	        add(new MartLoc("Ȩ�÷���������", 126.90, 37.47));
	    }};
	    
	
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/{type}")
	public String getMartLoc(@PathParam("type") String type) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Set hs = new LinkedHashSet(); //���� �����ϴ� Set
		
		Client client = ClientBuilder.newClient(); 
		WebTarget target = null;
		Invocation.Builder invocBuilder = null;

		//���� ,��Ʈ ��ǰ ���� api ȣ��
		for (int i = 1; i <= 3; i++) {
			target = client.target("http://openAPI.seoul.go.kr:8088/"+MART_INFO_KEY+"/json/ListNecessariesPricesService/"
							+ ((i - 1) * 1000 + 1) + "/" + (i * 1000));
			invocBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
			String mart_info = invocBuilder.get(String.class); //Receive HTTP Response			
			
			
			//���� HTTP Message(JSON)���� �ʿ��� ���� ����.
			Map<String, Object> mart_info_Map = mapper.readValue(mart_info, Map.class);
			Map<String, Object> ListNecessariesPricesServiceMap = (Map<String, Object>) mart_info_Map.get("ListNecessariesPricesService");
			ArrayList<HashMap<String, Object>> row_info_Map = (ArrayList<HashMap<String, Object>>) ListNecessariesPricesServiceMap.get("row");
			
			Iterator it_info = row_info_Map.iterator();
			while (it_info.hasNext()) {
				HashMap<String, Object> h = (HashMap<String, Object>) it_info.next();
				hs.add(h.get("M_NAME")); //Set�� �ߺ� ��� ���ϰ� ����. ����,��Ʈ �̸��鸸 �̾Ƴ��� LinkedHashSet �� ����
			}
		}
//			return hs.toString();

		//���� ��ġ ���� api ȣ��
		target = client.target("http://openAPI.seoul.go.kr:8088/"+MART_LOC_KEY+"/json/ListTraditionalMarket/1/350/");
		invocBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
		String mart_loc = invocBuilder.get(String.class);//Receive HTTP Response
		
		//���� HTTP Message(JSON)���� �ʿ��� ���� ����.
		Map<String, Object> mart_loc_Map = mapper.readValue(mart_loc, Map.class);
		Map<String, Object> ListTraditionalMarketMap = (Map<String, Object>) mart_loc_Map.get("ListTraditionalMarket");
		ArrayList<LinkedHashMap<String, Object>> row_loc_Map = (ArrayList<LinkedHashMap<String, Object>>) ListTraditionalMarketMap.get("row");
		
		
		
		//json���� ��Ʈ�� ����
		String jsonResult="{ \"row\" :[ ";
		
		if(type.equals("market")){
			int k = 0;
			for(LinkedHashMap<String,Object> h : row_loc_Map){		
				k++;
				if(hs.contains(h.get("M_NAME"))){
					jsonResult+="{\"M_NAME\" : "+"\""+h.get("M_NAME")+"\""+", \"LAT\" : "+(Double)h.get("LAT")+", \"LNG\" : "+(Double)h.get("LNG");
					jsonResult+= k != row_loc_Map.size() ? "}," : "}";
					
				}
			}
		}else if(type.equals("mart")){
			for(int i=0;i<martList.size();i++){
				jsonResult+="{\"M_NAME\" : "+"\""+martList.get(i).getM_NAME()+"\""+", \"LAT\" : "+martList.get(i).getLNG()+", \"LNG\" : "+martList.get(i).getLAT();
				jsonResult+= i != martList.size()-1 ? "}," : "}" ;
			}
		}
		jsonResult+="]}";
		return jsonResult;

	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/search/{name}")
	public String searchMart(@PathParam("name") String name) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		
		//���� ��ġ api �ٽ� �ҷ�����. ������ ��� �̿��ұ�?
		Client client = ClientBuilder.newClient(); 
		WebTarget target = client.target("http://openAPI.seoul.go.kr:8088/"+MART_LOC_KEY+"/json/ListTraditionalMarket/1/350/");
		Invocation.Builder invocBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
		String mart_loc = invocBuilder.get(String.class);//Receive HTTP Response
		//���� HTTP Message(JSON)���� �ʿ��� ���� ����.
		Map<String, Object> mart_loc_Map = mapper.readValue(mart_loc, Map.class);
		Map<String, Object> ListTraditionalMarketMap = (Map<String, Object>) mart_loc_Map.get("ListTraditionalMarket");
		ArrayList<LinkedHashMap<String, Object>> row_loc_Map = (ArrayList<LinkedHashMap<String, Object>>) ListTraditionalMarketMap.get("row");
		
		
		String jsonResult="{ \"result\" : ";
		boolean find=false;
		for(LinkedHashMap<String,Object> h : row_loc_Map){		
			if(name.equals(h.get("M_NAME"))){
				jsonResult+="{\"M_NAME\" : "+"\""+h.get("M_NAME")+"\""+", \"LAT\" : "+(Double)h.get("LAT")+", \"LNG\" : "+(Double)h.get("LNG");
				find=true;
				break;
			}
		}
		for(int i=0;i<martList.size();i++){
			if(name.equals(martList.get(i).getM_NAME())){
				jsonResult+="{\"M_NAME\" : "+"\""+martList.get(i).getM_NAME()+"\""+", \"LAT\" : "+martList.get(i).getLNG()+", \"LNG\" : "+martList.get(i).getLAT();
				find=true;
				break;
			}
		}
		if(find){
			jsonResult+="}}";
		}else{
			jsonResult+= "\"fail\"}";
		}
		
		return jsonResult;

		
	}
}
