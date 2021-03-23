package projectThree.core.services;

import com.day.commons.datasource.poolservice.DataSourcePool;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component(service = checkBoxService.class, immediate = true, name = "CheckBoxService")
public class checkBoxServiceImpl implements checkBoxService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final List<String> listOfCheckBox = new ArrayList<String>();

    @Reference
    DataSourcePool source;

    private Connection getConnection(String dataSourceName) throws Exception {
        DataSource dataSource = null;
        Connection con = null;
        log.info("Before connection is getting created");
        dataSource = (DataSource) source.getDataSource(dataSourceName);
        con = dataSource.getConnection();
        log.info("Connection created");
        return con;

    }

    @Activate
    @Modified
    public void activate() throws Exception {
        Connection con = getConnection("test");
        String query = "SELECT * FROM checkbox_name";
        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        while (resultSet.next()) {
            String checkBoxName = resultSet.getString("name");
            listOfCheckBox.add(checkBoxName);
        }

    }

    @Override
    public List<String> getCheckBoxList() {
        return listOfCheckBox;
    }
}
