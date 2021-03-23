package projectThree.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import projectThree.core.services.CustomService;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class)
public class CustomServiceModel {

@OSGiService
private CustomService customService;


String message;




@PostConstruct
protected void init(){

    message = customService.getMessage();

}

public String getMessage(){

    return message;
}



}
