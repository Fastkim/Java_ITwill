package java_itwill_project_model;

import java.time.LocalDateTime;

public class Altered {

    public interface Entity {
        String TBL_ALTERED = "ALTERED"; // 테이블 이름
        String COL_ALTERED_NO = "ALTERED_NO";
        String COL_TITLE = "TITLE";
        String COL_AUTHOR = "AUTHOR";
        String COL_DETAIL_ALTERED = "DETAIL_ALTERED";
        String COL_CLOTHES_TYPE = "CLOTHES_TYPE";
        String COL_CREATED_DATE = "CREATED_DATE";
        String COL_MODIFIED_DATE = "MODIFIED_DATE";
    }

    private Integer alteredNo;
    private String detailAltered;
    private String title;
    private String author;
    private String clothesType;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    
    public Altered() {}

    
    public Altered(Integer alteredNo, String title, String detailAltered, String author, String clothesType, LocalDateTime createdDate,
            LocalDateTime modifiedDate) {
        this.alteredNo = alteredNo;
        this.detailAltered = detailAltered;
        this.title = title;
        this.author = author;
        this.clothesType = clothesType;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }


    public Integer getAlteredNo() {
        return alteredNo;
    }


    public String getDetailAltered() {
        return detailAltered;
    }


    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }
    
    public String getClothesType() {
        return clothesType;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }


    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }


    @Override
    public String toString() {
        return String.format(
                "Altered(NO=%d, title=%s, detailAltered=%s, clothesType=%s author=%s, created=%s, modified=%s",
                alteredNo, title, detailAltered, author, clothesType, createdDate, modifiedDate);
                
    }
    
    
}
