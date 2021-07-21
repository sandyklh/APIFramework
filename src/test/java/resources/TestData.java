package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    public AddPlace addplace(String name,String language,String Address){
        AddPlace p=new AddPlace();
        p.setAccuracy(50);
        p.setName(name);
        p.setPhone_number("(+91) 983 893 3937");

        p.setAddress(Address);;;
        p.setWebsite("http://google.com");
        p.setLanguage(language);
        List<String> list=new ArrayList<>();
        list.add("shoe park");
        list.add("shop");
        p.setTypes(list);
        Location l=new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
return p;
    }

    public String deletePlacePayload(String Place){
        return "{\r\n    \"place_id\":\""+Place+"\"\r\n}";

    }
}
