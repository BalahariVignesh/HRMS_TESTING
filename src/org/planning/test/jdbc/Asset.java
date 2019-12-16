package org.planning.test.jdbc;

public class Asset {
private String Asset_type;
private int Asset_Id;
public String getAsset_type() {
	return Asset_type;
}
public void setAsset_type(String asset_type) {
	Asset_type = asset_type;
}
public int getAsset_Id() {
	return Asset_Id;
}
public void setAsset_Id(int asset_Id) {
	Asset_Id = asset_Id;
}
public Asset(String asset_type, int asset_Id) {
	super();
	Asset_type = asset_type;
	Asset_Id = asset_Id;
}

}
