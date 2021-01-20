package Test;

import gui.RegisterPanel;
import java.sql.SQLException;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

/**
 * The test of register panel
 * @author zk
 */
public class RegisterPanelTest {
     String account;
     String password;
     String confirmPassword;
     RegisterPanel registerPanel;
      @Before
    public void setUp() {
      account = "aaa";
      password = "123456";
      confirmPassword = "123456";
      registerPanel =  new RegisterPanel();
      registerPanel.setVisible(true);
        
    }
    @Test
    public void testNullAccount() throws SQLException, ClassNotFoundException{
       assertFalse(registerPanel.judgeRegister("",password,confirmPassword));
    }
     public void testNullPassword()throws SQLException, ClassNotFoundException{
       assertFalse(registerPanel.judgeRegister(account,"",confirmPassword));
    }
      public void testpasswordAndConfirmPassword() throws SQLException, ClassNotFoundException{
       assertFalse(registerPanel.judgeRegister(account,password,""));
    }
     @After
    public void tearDown(){
        account = null;
        password = null;
        confirmPassword = null;
        registerPanel.dispose();
    }

}
