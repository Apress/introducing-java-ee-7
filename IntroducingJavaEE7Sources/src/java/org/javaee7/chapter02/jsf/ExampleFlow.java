
package org.javaee7.chapter02.jsf;

import javax.faces.context.FacesContext;
import javax.faces.flow.Flow;
//import javax.faces.flow.FlowDefinition;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowDefinition;
import javax.inject.Named;

/**
 *
 * @author Juneau
 
@Named("exampleFlow2")
@FlowDefinition
public class ExampleFlow {
    private static final long serialVersionUID = -7623501087369765218L;
    
    public Flow defineFlow(FacesContext context, FlowBuilder builder){
        String flowId = "example2";
       
        builder.id(flowId);
        builder.viewNode(flowId, "/" + flowId + ".xhtml").markAsStartNode();
        
        builder.returnNode("returnFromFlow").fromOutcome("#{flowBean.returnValue}");
        
        return builder.getFlow();
    }
}
*/