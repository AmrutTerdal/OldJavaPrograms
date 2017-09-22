package CustomerModule;

public class SetGetCategory {
	private String CustCategoryID;
	private String Desc;
	private String ShDesc;
	private String StatusCombo;
	
	public String getCustCategoryID() {
		return CustCategoryID;
	}
	public void setCustCategoryID(String custCategoryID) {
		CustCategoryID = custCategoryID;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	public String getShDesc() {
		return ShDesc;
	}
	public void setShDesc(String shDesc) {
		ShDesc = shDesc;
	}
	public String getStatusCombo() {
		return StatusCombo;
	}
	public void setStatusCombo(String statusCombo) {
		StatusCombo = statusCombo;
	}
	
}
