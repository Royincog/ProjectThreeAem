package projectThree.core.services;


import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@Component(service = DeveloperInfoConfigService.class,immediate = true)
@Designate(ocd = DeveloperInfoConfigServiceImpl.DeveloperInfoConfig.class)
public class DeveloperInfoConfigServiceImpl implements DeveloperInfoConfigService {


    @ObjectClassDefinition(name = "Developer Configuration", description = "Please provide the developer name")
    public @interface DeveloperInfoConfig {


        @AttributeDefinition(name = "Developer Name", type = AttributeType.STRING)
        public String getDeveloperName();


    }

    private String developerName;



 @Activate
 @Modified
 protected void activate(DeveloperInfoConfig config){
     developerName = config.getDeveloperName();
 }



    @Override
    public String getDeveloperName() {
        return developerName;
    }

}
