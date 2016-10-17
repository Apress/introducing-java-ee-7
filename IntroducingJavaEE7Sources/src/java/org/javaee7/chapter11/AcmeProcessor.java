package org.javaee7.chapter11;

import java.util.List;
import javax.batch.api.chunk.ItemProcessor;

/**
 *
 * @author Juneau
 */
public class AcmeProcessor implements ItemProcessor {

    public AcmeProcessor() {
    }

    /**
     * Write out all lines that contain the text "Two"
     *
     * @param item
     * @return
     * @throws Exception
     */
    @Override
    public WidgetOutputItem processItem(Object item) throws Exception {
        List<WidgetReportItem> widgetReportItems = (List<WidgetReportItem>) item;
        WidgetOutputItem out = null;
        for (WidgetReportItem witem : widgetReportItems) {
            if (witem.getLineText().contains("Two")) {
                out = new WidgetOutputItem(witem.getLineText());
            } 
        }
        return out;
    }
}
