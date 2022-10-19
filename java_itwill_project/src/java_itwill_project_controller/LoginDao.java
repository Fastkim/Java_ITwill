package java_itwill_project_controller;

import java_itwill_project_model.Login;

public interface LoginDao {

    int create(Login login);
    
    int select(String loginId, String loginPassword);
}
