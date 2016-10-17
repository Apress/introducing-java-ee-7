package org.javaee7.chapter07;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Instance;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Produces;
import org.javaee7.beans.WidgetOne;
import org.javaee7.beans.WidgetTwo;
import org.javaee7.beans.WidgetX;
import org.javaee7.interfaces.Widget;
import org.javaee7.jsf.AcmeBean;

/**
 *
 * @author Juneau
 */
@ManagedBean(name="widgetBean")
public class WidgetBean implements java.io.Serializable {
    
    @Inject
    OrderProcessor processor;
    
    private List<Widget> widgets;
    
    private String widgetType = Widget.GENERIC;
    private Widget selectedWidget;
    
    // Programmatic Lookup of Acmebean
    @Inject Instance<AcmeBean> acmeBean;

    public WidgetBean() {
        widgets = new ArrayList();
        widgets.add(new WidgetOne());
        widgets.add(new WidgetTwo());
    }

    @Produces
    public Widget getWidget() {
        switch (widgetType) {
            case Widget.PLASTIC:
                return new WidgetOne();
            case Widget.METAL:
                return new WidgetTwo();
            default:
                return new WidgetX();
        }
    }

    /**
     * @return the widgetType
     */
    public String getWidgetType() {
        return widgetType;
    }

    /**
     * @param widgetType the widgetType to set
     */
    public void setWidgetType(String widgetType) {
        this.widgetType = widgetType;
    }

    /**
     * @return the widget
     */
    public Widget getSelectedWidget() {
        selectedWidget = getWidget();
        return selectedWidget;
    }

    /**
     * @param widget the widget to set
     */
    public void setSelectedWidget(Widget widget) {
        this.selectedWidget = widget;
    }
    
    public String getAcmeBean(){
        AcmeBean bean = acmeBean.get();
        return bean.getMsg();
    }
    
    public String getOrderProcessor(){
        return processor.getBeanName();
    }
    
    @Produces
    @Named
    public List<Widget> getWidgets(){
        return widgets;
    }
}
