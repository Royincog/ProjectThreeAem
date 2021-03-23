package projectThree.core.services;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component(service = ExcelService.class,immediate = true,name = "ExcelServiceComponent")
public class ExcelServiceImpl implements ExcelService {
    @ValueMapValue
    private List<String>  nameList;
    @ValueMapValue
    private List<String> idList;


@Activate
@Modified
protected void activate() throws Exception {
   idList = new ArrayList<String>();
   nameList =  new ArrayList<String>();
   File file = new File("D:\\AEMDEv\\forAEM.xlsx");
   FileInputStream fileInputStream = new FileInputStream(file);
   XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
   XSSFSheet sheet = workbook.getSheetAt(0);

    int row = sheet.getPhysicalNumberOfRows();

    for(int i = 1;i<row;i++){
        String id = String.valueOf(sheet.getRow(i).getCell(0).getNumericCellValue());
        String name = sheet.getRow(i).getCell(1).getStringCellValue();
        idList.add(id);
        nameList.add(name);
    }

}


    @Override
    public List<String> getId() {
        return nameList;
    }

    @Override
    public List<String> getName() {
        return idList;
    }
}
