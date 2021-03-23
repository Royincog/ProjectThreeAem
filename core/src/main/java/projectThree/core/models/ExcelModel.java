package projectThree.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import projectThree.core.services.ExcelService;

import javax.annotation.PostConstruct;
import java.util.List;

@Model(adaptables = Resource.class)
public class ExcelModel {

    private List<String> nameList;
    private List<String> idList;


    @OSGiService
    private ExcelService excelService;

    @PostConstruct
    protected void init() {
        nameList = excelService.getName();
        idList = excelService.getId();
    }


    public List<String> getId() {
        return idList;
    }



    public List<String> getName() {
        return nameList;
    }

}
