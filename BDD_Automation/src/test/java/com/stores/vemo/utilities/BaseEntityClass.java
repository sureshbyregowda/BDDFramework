package com.stores.vemo.utilities;

import com.stores.vemo.pages.*;

public class BaseEntityClass
{
    protected DriverHelper driverHelper;
    protected static Page_Login page_login;
    protected static Page_Account_Registration page_account_registration;

    public BaseEntityClass(DriverHelper driverHelper)
    {
        this.driverHelper = driverHelper;
        page_login= new Page_Login(this.driverHelper.driver);
        page_account_registration= new Page_Account_Registration(this.driverHelper.driver);
    }


	public BaseEntityClass() {
		
	}
    
    
}