package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.Menu;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    public List<Map<String, List<Map<String, Object>>>> getMenuApiItems(String key){

        String url = "https://api.eatstreet.com/publicapi/v1/restaurant/"+key+"/menu?includeCustomizations=false";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Access-Token", "__API_EXPLORER_AUTH_KEY__");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<Object> respEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        List<Map<String, List<Map<String, Object>>>> menuApusList = (List<Map<String, List<Map<String, Object>>>>)respEntity.getBody();
        return menuApusList;
    }

    public List<Menu> getMenuItems(String key){

        List<Map<String, List<Map<String, Object>>>> menuApusList = getMenuApiItems(key);
        List<Menu> menuList = new ArrayList<>();
        if(menuApusList != null){
            for(int i=0;i<30;i++){
                if( menuApusList.size() > i && menuApusList.get(i) != null){
                    List<Map<String, Object>> items = menuApusList.get(i).get("items");
                    String itemName = items.get(0).get("name").toString();
                    Double itemPrice = (Double) items.get(0).get("basePrice");
                    Menu menu = new Menu(itemName, itemPrice);
                    menuList.add(menu);
                }
            }
        }
        return menuList;
    }
}