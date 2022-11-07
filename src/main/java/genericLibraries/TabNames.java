package genericLibraries;

public enum TabNames {
	ORGANNIZATIONS("Organizations"),SIGNOUT("Sign Out"),CONTACTS("Contacts"),
	LEADS("Leads");

	private String tabName ;
	private TabNames(String tab) {
		this.tabName=tab;
	} 
	
	public String getTabName()
	{
		return tabName;
	}

}
