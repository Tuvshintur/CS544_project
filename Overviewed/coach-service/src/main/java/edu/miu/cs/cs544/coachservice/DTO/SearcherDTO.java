package edu.miu.cs.cs544.coachservice.DTO;


import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * SearcherDTO @author Turuu
 */

public class SearcherDTO implements IGeneralDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String keyWord;

    private Integer page;

    private Integer size;

    private String direction;

    /**
     * Constructor
     **/

    public SearcherDTO() {
        super();
    }

    public SearcherDTO(String keyWord) {
        this.keyWord = keyWord;
    }

    public SearcherDTO(String keyWord, Integer page, Integer size, String direction) {
        this.keyWord = keyWord;
        this.page = page;
        this.size = size;
        this.direction = direction;
    }

    /**
     * Getter.Setter
     **/

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDirection() {
        return this.direction!=null ? this.direction : "asc";
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}