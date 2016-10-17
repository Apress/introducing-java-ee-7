package org.javaee7.chapter09;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonWriter;
import javax.json.JsonObject;

/**
 *
 * @author Juneau
 */
@ManagedBean(name="jsonWriter")
public class JsonWriterExample {

    @Inject
    JsonController jsonController;

    public void writeJson() {
        try {
            JsonObject jsonObject = jsonController.buildJobsJson();
            StringWriter writer = new StringWriter();
            JsonWriter jsonWriter = Json.createWriter(writer);
            jsonWriter.writeObject(jsonObject);
            jsonWriter.close();
            writer.close();
            // Write file
            FileWriter fstream = new FileWriter("Jobs.json");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(writer.toString());
            out.close();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "JSON Built",
                "JSON Built"));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
