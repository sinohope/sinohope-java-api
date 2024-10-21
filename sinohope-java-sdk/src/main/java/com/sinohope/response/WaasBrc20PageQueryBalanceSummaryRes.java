package com.sinohope.response;

import lombok.Data;

import java.util.List;

@Data
public class WaasBrc20PageQueryBalanceSummaryRes {


    private Long height;
    private Long total;
    private Long start;
    private List<PageBrc20SummaryDetail> detail;
}
