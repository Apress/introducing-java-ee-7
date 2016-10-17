package org.javaee7.chapter09;

import java.io.StringWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import org.javaee7.entity.Jobs;
import org.javaee7.jpa.session.JobsSession;

@Named
public class JsonController {

    @EJB
    JobsSession jobsFacade;

    public String buildJobs() {
        List<Jobs> jobs = jobsFacade.findAll();
        JsonObjectBuilder builder = Json.createObjectBuilder();
        StringBuilder json = new StringBuilder();
        JsonObjectBuilder object = null;
        for (Jobs job : jobs) {
            object = builder.add("jobId", job.getJobId())
                    .add("division", job.getDivision())
                    .add("title", job.getTitle())
                    .add("salary", job.getSalary());

        }
        builder.add("job", object);
        JsonObject result = builder.build();
        StringWriter sw = new StringWriter();
        try (JsonWriter writer = Json.createWriter(sw)) {
            writer.writeObject(result);
        }
        json.append(sw.toString());
        return json.toString();
    }

    public JsonObject buildJobsJson() {
        List<Jobs> jobs = jobsFacade.findAll();
        JsonObjectBuilder builder = Json.createObjectBuilder();
        StringBuilder json = new StringBuilder();
        JsonObjectBuilder object = null;;
        for (Jobs job : jobs) {
            object = builder.add("job", Json.createObjectBuilder()
                    .add("jobId", job.getJobId())
                    .add("division", job.getDivision())
                    .add("title", job.getTitle())
                    .add("salary", job.getSalary()));
        }
        builder.add("job", object);
        JsonObject result = builder.build();

        return result;
    }
}
