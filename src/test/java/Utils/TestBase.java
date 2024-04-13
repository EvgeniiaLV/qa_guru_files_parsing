package Utils;

public class TestBase {
    public String getFileExtension(String fileName) {
        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return fileName.substring(lastIndexOf + 1);
    }

    public String getFileName(String fileName) {
        int lastIndexOf = fileName.lastIndexOf("/");
        if (lastIndexOf == -1) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
    }

    public boolean fileExtensionIsCSV(String fileName) {
        return getFileExtension(fileName).equalsIgnoreCase(TestData.FILE_EXTENSION_CSV);
    }

    public boolean fileExtensionIsXLSX(String fileName) {
        return getFileExtension(fileName).equalsIgnoreCase(TestData.FILE_EXTENSION_XLSX);
    }

    public boolean fileExtensionIsPDF(String fileName) {
        return getFileExtension(fileName).equalsIgnoreCase(TestData.FILE_EXTENSION_PDF);
    }
}
