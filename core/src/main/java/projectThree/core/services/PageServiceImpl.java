package projectThree.core.services;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Node;
import javax.jcr.Session;

@Component(immediate = true,name = "Sample Page")

public class PageServiceImpl implements PageService{

    private String user = "";

    private Session session;

    //Inject a Sling Resource Resolver
    @Reference
    private ResourceResolverFactory resolverFactory;

    @Override
    public String CreatePage(String PageName) {
        String pagePath = "/content/projectThree/en";
        String teplatePath = "/conf/projectThree/settings/wcm/templates/content-page";
        String pageTitle = "New Page";
        Page newPage;
        PageManager pageManager;

        ResourceResolver resolver = null;

        try{
            //Invoke adapto method to create a session
            resolver = resolverFactory.getServiceResourceResolver(null);
            session = resolver.adaptTo(Session.class);

            //create a page manager instance
            pageManager = resolver.adaptTo(PageManager.class);

            //crearte a new paze
            newPage = pageManager.create(pagePath,PageName,teplatePath,pageTitle);

            if(newPage != null){
                user = resolver.getUserID();
                //Defining a node in the page
                Node newNode = newPage.adaptTo(Node.class); //simple node
                Node content = newNode.getNode("jcr:content"); //content node inside simple node unstructured

                if(content != null) {
                    Node rootNode = session.getRootNode();
                    String path = rootNode.getPath();
                    Node paragraphNode = JcrUtils.getNodeIfExists(content, "par");
                    Node textNode = JcrUtils.getNodeIfExists(paragraphNode, "text");

                    textNode.setProperty("text", "<p>Page created from java </p>");
                    session.save();

                }


            }
return pageTitle;
        }catch (Exception e){

        }
        return "";
    }
}
