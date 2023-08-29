package com.sinohope.response.common;

import lombok.Data;

import java.util.List;

@Data
public class PageData<T> {

    private Integer pageIndex;

    private Integer pageSize;

    private Integer totalSize;

    private List<T> list;


    public static <T> PageData<T> emptyData(List<T> list, Integer pageIndex, Integer pageSize){
        PageData<T> emptyData = new PageData<>();
        emptyData.setList(list);
        emptyData.setPageSize(pageSize);
        emptyData.setPageIndex(pageIndex);
        emptyData.setTotalSize(0);
        return emptyData;
    }

    public static <T> PageData<T> fillData(List<T> list, Integer pageIndex, Integer pageSize, Integer totalSize){
        PageData<T> emptyData = new PageData<>();
        emptyData.setList(list);
        emptyData.setPageSize(pageSize);
        emptyData.setPageIndex(pageIndex);
        emptyData.setTotalSize(totalSize);
        return emptyData;
    }
}
