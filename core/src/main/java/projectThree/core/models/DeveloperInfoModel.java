package projectThree.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import projectThree.core.services.DeveloperInfoConfigService;

import javax.annotation.PostConstruct;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = DeveloperInfoAdapter.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DeveloperInfoModel implements DeveloperInfoAdapter{

    @OSGiService
    private DeveloperInfoConfigService developerInfoConfigService;


    public String getDeveloperName(){
        return " The developer here is " + developerInfoConfigService.getDeveloperName();
    }

}
