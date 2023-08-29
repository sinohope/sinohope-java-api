package com.sinohope.request;

import lombok.Data;

@Data
public class BaseWaasParam {

    /**
     * 第几页
     */
    private Integer pageIndex=1;

    /**
     * 每页显示几条
     */
    private Integer pageSize=10;

    /**
     * 偏移量
     */
    private Integer offset;


    public Integer getOffset() {
        if(this.pageSize == null || this.pageSize.intValue() <= 0){
            return 0;
        }
        if(this.pageIndex == null || this.pageIndex.intValue() <= 0){
            return 0;
        }
        return this.pageSize.intValue() * (this.pageIndex.intValue() -1);
    }


}
