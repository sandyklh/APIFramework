package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import java.io.*;
import java.util.Properties;

public class utils {
   static RequestSpecification Reqspec;


    public utils()  {
    }

    public RequestSpecification requestspecification() throws IOException {
        if(Reqspec==null){

        PrintStream log=new PrintStream(new FileOutputStream("Logs.txt"));
          Reqspec=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseurl")).addQueryParam("key","qaclick123").
                addFilter(RequestLoggingFilter.logRequestTo(log))// to log request we new to pass object of pritnstram it will create log file to show logs
                  .addFilter(ResponseLoggingFilter.logResponseTo(log))
                  .setContentType(ContentType.JSON).build();
        return Reqspec;
        }
        return Reqspec;

    }

    public  static String getGlobalValue(String key) throws IOException {
        Properties pro=new Properties();
        FileInputStream fis= new FileInputStream("C:\\Users\\royal\\eclipse-workspaceJS\\APIFramework\\src\\test\\java\\resources\\global.properties");
        pro.load(fis);
       return  pro.getProperty(key);

    }

    public static String getFromJason(Response response, String key ){

        String resp=response.asString();
        JsonPath js=new JsonPath(resp);

        return js.get(key).toString();
    }
}
