package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {

    public static final String FILE_EXTENSION_CSV = "csv";
    public static final String FILE_EXTENSION_XLSX = "xlsx";
    public static final String FILE_EXTENSION_PDF = "pdf";
    public static final String ZIP_FILE_PATH = "src/test/resources/customerData.zip";
    public static final String ZIP_FILE_NAME = "customerData.zip";
    public static final String CSV_FILE_NAME = "BankDetails.csv";
    public static final String XLSX_FILE_NAME = "CustomerAddress.xlsx";
    public static final String PDF_FILE_NAME = "CustomerStatement.pdf";
    public static final String PDF_FILE_TITLE = "CUSTOMER STATEMENT";

    public static final ArrayList<String> LIST_OF_FILE_NAMES_IN_ZIP_FILE = new ArrayList<>(Arrays.asList(
            CSV_FILE_NAME,
            XLSX_FILE_NAME,
            PDF_FILE_NAME));
    public static final String[] LIST_OF_CITIES_IN_XLSX_FILE = new String[]{
            "Helsinki",
            "Saint Petersburg",
            "Berlin"};

    public static final List<String[]> CSV_DATA = Arrays.asList(
            new String[]{"Customer ID", "Bank country key", "Bank Keys", "Bank account number"},
            new String[]{"35", "151", "8796712009", "2341543509824323"},
            new String[]{"36", "890", "7301239829", "4329000013425424"},
            new String[]{"37", "204", "1200000044", "9012432438543732"});

    public static final String JSON_CUSTOMER_NUMBER = "0123456789";
    public static final int JSON_COUNTRY_KEY = 145;
    public static final String JSON_CUSTOMER_NAME = "Cats company";
    public static final String JSON_CUSTOMER_PHONE_NUMBER = "89012419014";
    public static final String JSON_CUSTOMER_CITY = "Moscow";
    public static final String JSON_CUSTOMER_POSTAL_CODE = "115304";

    public static final String[] JSON_CUSTOMER_INDUSTRY_CODES = new String[]{
            "00000001",
            "00000057",
            "00000102"};
}
