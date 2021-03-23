package projectThree.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import projectThree.core.services.checkBoxService;

import javax.annotation.PostConstruct;
import java.util.List;


@Model(adaptables = Resource.class)
public class checkBoxModel {
    private List<String> checkBoxes;

    @OSGiService
    private checkBoxService service;

    @PostConstruct
    protected void init(){
        checkBoxes = service.getCheckBoxList();
    }

    public List<String> getCheckBoxes() {
        return checkBoxes;
    }
}
