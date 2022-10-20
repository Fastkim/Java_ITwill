package java_itwill_project_controller;

import static java_itwill_project_model.Altered.Entity.*;


public interface JdbcSql {

    // 전체 검색 - 요청 글 번호 내림차순 정렬
    String SQL_SELECT_ALL = String.format(
            "select * from %s order by %s desc",
            TBL_ALTERED, COL_ALTERED_NO);
    
    // 요청 글 번호로 검색.
    String SQL_SELECT_BY_NO = String.format(
            "select * from %s where %s = ?",
            TBL_ALTERED, COL_ALTERED_NO);
    
    // 새로운 요청 글 저장.
    String SQL_REQUEST = String.format(
            "insert into %s (%s, %s, %s, %s) values (?, ?, ?, ?)",
            TBL_ALTERED, COL_TITLE, COL_DETAIL_ALTERED, COL_AUTHOR, COL_CLOTHES_TYPE);
    
    // 요청 글 업데이트(수정)
    String SQL_UPDATE = String.format(
            "update %s set %s = ? , %s = ? , %s = ?, %s = sysdate where %s = ?",
            TBL_ALTERED, COL_TITLE, COL_DETAIL_ALTERED, COL_CLOTHES_TYPE, COL_MODIFIED_DATE, COL_ALTERED_NO );
    
    // 요청 글 삭제
    String SQL_DELETE = String.format(
            "delete from %s where %s = ?",
            TBL_ALTERED, COL_ALTERED_NO);
    
    // 제목/내용/작성자로 검색하기
    // 제목으로 검색하기
    String SQL_SELECT_BY_TITLE = String.format(
            "select * from %s where lower(%s) like ? order by %s desc",
            TBL_ALTERED, COL_TITLE, COL_ALTERED_NO);
    
    // 세부내용으로 검색하기
    String SQL_SELECT_BY_DETAIL_ALTERED = String.format(
            "select * from %s where lower(%s) like ? order by %s desc",
            TBL_ALTERED, COL_DETAIL_ALTERED, COL_ALTERED_NO);
    
    // 제목 또는 세부내용으로 검색하기
    String SQL_SELECT_BY_TITLE_OR_DETAIL_ALTERED = String.format(
            "select * from %s where lower(%s) like ? or lower(%s) like ? order by %s desc",
            TBL_ALTERED, COL_TITLE, COL_DETAIL_ALTERED, COL_ALTERED_NO);
    
    // 작성자로 검색하기
    String SQL_SELECT_BY_AUTHOR = String.format(
            "select * from %s where lower(%s) like ? order by %s desc",
            TBL_ALTERED, COL_AUTHOR, COL_ALTERED_NO);
            
}
