package com.edu.miu.cs544.tminstructor.dto;

import java.util.List;


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