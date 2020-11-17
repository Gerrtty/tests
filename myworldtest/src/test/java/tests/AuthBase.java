package tests;

import data.AccountData;
import org.junit.Before;
import settings.Settings;

public class AuthBase extends TestBase {

    @Override
    @Before
    public void setUp() {
        applicatonManager = ApplicatonManager.getInstance();
        AccountData user = new AccountData(Settings.getLogin(), Settings.getPassword());
        applicatonManager.getNavigationHelper().openHomePage();
        applicatonManager.getLoginHelper().login(user);
    }

}
