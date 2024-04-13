package guru.qa;

import Utils.TestBase;
import Utils.TestData;
import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class FilesParsingTests extends TestBase {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private ClassLoader cl = FilesParsingTests.class.getClassLoader();

    @Test
    @DisplayName("Check files names in ZIP")
    void zipFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream(TestData.ZIP_FILE_NAME))) {
            ZipEntry entry;
            ArrayList<String> testListOfFilesInZIP = new ArrayList<>();
            while ((entry = zis.getNextEntry()) != null) {
                String fileName = getFileName(entry.getName());
                if (fileName.length() > 0) {
                    testListOfFilesInZIP.add(fileName);
                }
            }

            Assertions.assertTrue(testListOfFilesInZIP.containsAll(TestData.LIST_OF_FILE_NAMES_IN_ZIP_FILE) &&
                    TestData.LIST_OF_FILE_NAMES_IN_ZIP_FILE.containsAll(testListOfFilesInZIP));
        }
    }

    @Test
    @DisplayName("Check pdf document title")
    void pdfFileParsingTest() throws Exception {
        try (ZipFile zipFile = new ZipFile(TestData.ZIP_FILE_PATH)) {
            Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
            while (zipEntries.hasMoreElements()) {
                ZipEntry zipEntry = zipEntries.nextElement();
                if (fileExtensionIsPDF(zipEntry.getName())) {
                    try (InputStream inputStream = zipFile.getInputStream(zipEntry)) {
                        PDF pdf = new PDF(inputStream);
                        Assertions.assertEquals(TestData.PDF_FILE_TITLE, pdf.title);
                    }
                }
            }
        }
    }

    @Test
    @DisplayName("Check customers cities in xslx document")
    void xlsxFileParsingTest() throws Exception {
        try (ZipFile zipFile = new ZipFile(TestData.ZIP_FILE_PATH)) {
            Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
            while (zipEntries.hasMoreElements()) {
                ZipEntry zipEntry = zipEntries.nextElement();
                if (fileExtensionIsXLSX(zipEntry.getName())) {
                    try (InputStream inputStream = zipFile.getInputStream(zipEntry)) {
                        XLS xls = new XLS(inputStream);
                        String[] actualValue = new String[]{
                                xls.excel.getSheetAt(0).getRow(1).getCell(2).getStringCellValue(),
                                xls.excel.getSheetAt(0).getRow(2).getCell(2).getStringCellValue(),
                                xls.excel.getSheetAt(0).getRow(3).getCell(2).getStringCellValue()};
                        Assertions.assertEquals(Arrays.toString(TestData.LIST_OF_CITIES_IN_XLSX_FILE), Arrays.toString(actualValue));
                    }
                }
            }
        }
    }

    @Test
    @DisplayName("Check customers bank details in csv document")
    void csvFileParsingTest() throws Exception {
        try (ZipFile zipFile = new ZipFile(TestData.ZIP_FILE_PATH)) {
            Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
            while (zipEntries.hasMoreElements()) {
                ZipEntry zipEntry = zipEntries.nextElement();
                if (fileExtensionIsCSV(zipEntry.getName())) {
                    try (InputStream inputStream = zipFile.getInputStream(zipEntry)) {
                        CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
                        List<String[]> data = csvReader.readAll();

                        Assertions.assertEquals(TestData.CSV_DATA.size(), data.size());

                        for (int i = 0; i < data.size(); i++) {
                            Assertions.assertArrayEquals(TestData.CSV_DATA.get(i), data.get(i));
                        }
                    }
                }
            }
        }
    }

    @Test
    @DisplayName("Check customer master data in json file")
    void jsonFileParsingCustomerMaster() throws Exception {
        try (Reader reader = new InputStreamReader(cl.getResourceAsStream("customerMaster.json"))) {
            Customer actual = objectMapper.readValue(reader, Customer.class);

            Assertions.assertEquals(TestData.JSON_CUSTOMER_NUMBER, actual.getCustomerNumber());
            Assertions.assertEquals(TestData.JSON_COUNTRY_KEY, actual.getCountryKey());
            Assertions.assertEquals(TestData.JSON_CUSTOMER_NAME, actual.getName());
            Assertions.assertEquals(TestData.JSON_CUSTOMER_PHONE_NUMBER, actual.getPhoneNumber());
            Assertions.assertArrayEquals(TestData.JSON_CUSTOMER_INDUSTRY_CODES, actual.getIndustryCodes());
            Assertions.assertEquals(TestData.JSON_CUSTOMER_POSTAL_CODE, actual.getAddress().getPostalCode());
        }
    }
}

