package java_itwill_project_controller;

import java.util.List;

import java_itwill_project_model.Altered;

public interface AlteredDao {

    List<Altered> select(); // SQL_SELECT_ALL
    Altered select(Integer alteredNo); // SQL_SELECT_BY_NO
    int request(Altered altered); // SQL_REQUEST
    int update(Altered altered); // SQL_UPDATE
    int delete(Integer AlteredNo); // SQL_DELETE
    
    // SELECT_BY_TITLE, SELECT_BY_DETAIL_ALTERED, SELECT_BY_AUTHOR, SELECT_BY_TITLE_OR_DETAIL_ALTERED
    List<Altered> select(int type, String keyword);
    
}

