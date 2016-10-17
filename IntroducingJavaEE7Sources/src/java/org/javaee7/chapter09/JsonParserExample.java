/*
 * Recipe 17-5
 */
package org.javaee7.chapter09;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

/**
 *
 * @author Juneau
 */
@ManagedBean(name="jobsParser")
public class JsonParserExample {
    
    @Inject
    JsonController controller;

    public void parseObject() {
        InputStream in = new ByteArrayInputStream(controller.buildJobs().getBytes());
        JsonParser parser = Json.createParser(in);
        Event ev = parser.next();
        
    }
    
    public String readObject() {
        InputStream in = new ByteArrayInputStream(controller.buildJobs().getBytes());
        JsonReader reader = Json.createReader(in);
        JsonObject obj = reader.readObject();
        return obj.toString();
              
    }

    public static void main(String[] args) {
        JsonParserExample ex = new JsonParserExample();
        ex.parseObject();
    }
}
