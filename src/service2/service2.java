package service2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/markinfos")
public class service2 {
	public static final String MART_INFO_KEY = "52566855766e6a6836397646416344";
	public static ArrayList<String> namelist = new ArrayList<String>(Arrays.asList("사과", "배", "배추", "무", "양파", "상추",
			"오이", "호박", "쇠고기", "돼지고기", "닭고기", "달걀", "조기", "명태", "오징어", "고등어"));

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/{name}")
	public String geProductInfo(@PathParam("name") String name)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		Client client = ClientBuilder.newClient();
		WebTarget target = null;
		Invocation.Builder invocBuilder = null;
		target = client.target(
				"http://openAPI.seoul.go.kr:8088/" + MART_INFO_KEY + "/json/ListNecessariesPricesService/1/16/" + name);
		invocBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
		String product_info = invocBuilder.get(String.class); // Receive HTTP
																// Response
		
		//받은 HTTP Message(JSON)에서 필요한 정보 추출.
		Map<String, Object> product_info_Map = mapper.readValue(product_info, Map.class);
		Map<String, Object> ListNecessariesPricesServiceMap = (Map<String, Object>) product_info_Map
				.get("ListNecessariesPricesService");
		ArrayList<LinkedHashMap<String, Object>> row_info_Map = (ArrayList<LinkedHashMap<String, Object>>) ListNecessariesPricesServiceMap
				.get("row");

//		return row_info_Map.toString();
//		return String.valueOf(namelist.size());

		//json 가공
		String jsonResult = "{ \"row\" :[ ";
		
		for(int i=0; i<namelist.size(); i++){
			int index=0;
			for(int j=0 ; j<row_info_Map.size(); j++){
				if(((String)row_info_Map.get(j).get("A_NAME")).indexOf(namelist.get(i))!=-1){
					index=j;
					break;
				}else{
					index=-1;
				}
			}
			if(index!=-1){
				String a_name = (String) row_info_Map.get(index).get("A_NAME");
				String a_unit = (String) row_info_Map.get(index).get("A_UNIT");
				String a_price = (String) row_info_Map.get(index).get("A_PRICE");
				
				jsonResult += "{\"A_NAME\" : " + "\"" + a_name + "\"" + ", \"A_UNIT\" : " + "\"" + a_unit + "\""
						+ ", \"A_PRICE\" : " + "\"" + a_price + "\"";
			}else{
				jsonResult += "{\"A_NAME\" : " + "\"" + namelist.get(i) + "\"" + ", \"A_UNIT\" : " + "\"0개\""
						+ ", \"A_PRICE\" : " + "\"\"";
			}
			jsonResult += i != namelist.size() - 1 ? "}," : "}";

		}
		
		jsonResult += "]}";
		return jsonResult;
	}
}
