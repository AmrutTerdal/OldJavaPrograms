package ReadExcelData;

class ReadExcelDataFromConfig {

	public static void main(String[] args){
		
		ExcelDataConfig excel = new ExcelDataConfig("‪‪E:\\Selenium\\tools\\TestData.xlsx"); 	
		System.out.println("the values are"+excel.getData(0, 0, 0));
		
	}
}
