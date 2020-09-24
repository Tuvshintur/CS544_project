package edu.miu.cs.cs544.tmservice.dto;

import java.util.List;

/**
 * Body DTO @author Turuu
 */

public class ListDTO<E> implements IGeneralDTO {

    private List<E> list;

    public ListDTO(List<E> list) {
        this.list = list;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}