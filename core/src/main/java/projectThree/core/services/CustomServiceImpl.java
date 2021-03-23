package projectThree.core.services;


import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = CustomService.class,immediate = true,name = "HelloComponent")
public class CustomServiceImpl implements CustomService{

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public String getMessage() {
        return "Hello From Java Service";
    }

    @Activate
    @Modified

    protected void activate()
    {
        logger.info("Activating the Hello from Java service");
    }
}
