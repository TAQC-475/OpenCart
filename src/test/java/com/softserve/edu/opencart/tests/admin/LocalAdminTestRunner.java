package com.softserve.edu.opencart.tests.admin;

import com.softserve.edu.opencart.pages.admin.account.SigninPage;
import com.softserve.edu.opencart.pages.admin.account.catalog.ModifiedCatalogPage;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class LocalAdminTestRunner extends LocalTestRunner {
    @Parameters({"adminServerUrl"})
    @BeforeMethod
    public void beforeMethod(String adminServerUrl) {
        getDriver().get(adminServerUrl);
    }

    protected SigninPage loadSignInPage() {
        return new SigninPage(getDriver());
    }
    public SearchSuccessPage successPage() {
        return new SearchSuccessPage(getDriver());
    }
    public ModifiedCatalogPage modifiedCatalogPage(){
        return new ModifiedCatalogPage(getDriver());
    }

}
