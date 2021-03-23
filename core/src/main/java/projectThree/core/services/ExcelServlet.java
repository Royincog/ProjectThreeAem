package projectThree.core.services;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class,property = {
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlets.paths=" + "/bin/excel"
})
public class ExcelServlet extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(ExcelServlet.class);
    @OSGiService
    private ExcelService excelService;

    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response)throws ServletException, IOException{
                log.info("Entering do get");

                response.getWriter().println("<h1>"+excelService.getId()+" "+excelService.getId() + " "+"</h1>");
                response.setContentType("text/html");

                log.info("Ending do get");
    }
}
