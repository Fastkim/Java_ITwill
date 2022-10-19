package java_itwill_project_controller;

import static java_itwill_project_model.Login.Entity.*;

public interface jdbcSqlLogin {

    // 회원가입했을때 Login 테이블에 ID와 Password 저장.
    String SQL_CREATE_ACCOUNT = String.format(
            "insert into %s (%s, %s, %s, %s) values (?, ?, ?, ?)",
            TBL_LOGIN, COL_LOGIN_ID, COL_LOGIN_PASSWORD, COL_NAME, COL_PHONE);
    
    String SQL_SELECT_LOGIN = String.format(
            "select * from %s where %s = ? and %s = ? ",
            TBL_LOGIN, COL_LOGIN_ID, COL_LOGIN_PASSWORD);
}
