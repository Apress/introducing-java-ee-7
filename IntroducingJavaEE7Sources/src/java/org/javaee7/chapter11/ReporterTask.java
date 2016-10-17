
package org.javaee7.chapter11;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.ejb.EJB;
import org.javaee7.entity.Jobs;
import org.javaee7.entity.Product;
import org.javaee7.jpa.session.JobsSession;
import org.javaee7.jpa.session.ProductSession;

/**
 *
 * @author Juneau
 */
public class ReporterTask implements Runnable {

    String reportName;
    @EJB
    private JobsSession jobsFacade;
    @EJB
    private ProductSession productFacade;

    public ReporterTask(String reportName) {
        this.reportName = reportName;
    }

    public void run() {
// Run the named report
        if ("JobsReport".equals(reportName)) {
            runJobReport();


        } else if ("ProductReport".equals(reportName)) {
            runProductReport();
        }
    }

    /**
     * Prints a list of jobs to the system log.
     */
    public void runJobReport() {
        List<Jobs> jobs = jobsFacade.getJobList();
        System.out.println("Job Listing Report");
        System.out.println("=====================");

        for (Jobs job : jobs) {
            System.out.println(job.getTitle() + " " + job.getDivision());
        }
    }

    /**
     * Prints a list of products 
     */
    void runProductReport() {
        System.out.println("Querying the database");
        Path reportFile = Paths.get("ProductReport.txt");
       
        try (BufferedWriter writer = Files.newBufferedWriter(
                reportFile, Charset.defaultCharset())) {
            Files.deleteIfExists(reportFile);
            reportFile = Files.createFile(reportFile);
            writer.append("Product Listing Report");
            writer.newLine();
            writer.append("===================");
            writer.newLine();
            List<Product> products = productFacade.obtainProduct();
            for (Product product : products) {
                writer.append(product.getName());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException exception) {
            System.out.println("Error writing to file");
        }


    }
}

