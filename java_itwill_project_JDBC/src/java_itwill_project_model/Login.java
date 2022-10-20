package java_itwill_project_model;

import java.awt.Component;

public class Login {

    public interface Entity {
        String TBL_LOGIN = "LOGIN"; // 테이블 이름
        String COL_ACCOUNT_NO = "ACCOUNT_NO";
        String COL_LOGIN_ID = "LOGIN_ID";
        String COL_LOGIN_PASSWORD = "LOGIN_PASSWORD";
        String COL_NAME = "NAME";
        String COL_PHONE = "PHONE";
    }
    
    private Integer accountNo;
    private String loginId;
    private String loginPassword;
    private String name;
    private String phone;
    
    public Login() {}

    public Login(Integer accountNo, String loginId, String loginPassword, String name, String phone) {
        this.accountNo = accountNo;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.name = name;
        this.phone = phone;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getLoginPassword() {
        return loginPassword;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Login(accountNo=%d, loginId=%s, loginPassword=%s, name=%s, phone=%s",
                accountNo, loginId, loginPassword, name, phone);
                
    }
}
