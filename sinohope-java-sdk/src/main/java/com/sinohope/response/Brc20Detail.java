package com.sinohope.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Objects;

@Data
@Accessors(chain = true)
public class Brc20Detail {
    private String method;
    //    private String op;
    private String ticker;
    private String quantity;
    private String inscriptionId;
    private Integer step;
    private String from;
    private String to;
}
