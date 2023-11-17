package com.liu.webMVC.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SysRequestLog {

    private String ip;
    private String requestUrl;
    private String browserName;
    private String browserVersionString;
    private String operatingSystem;
    private Double lat;
    private Double lng;
    private Integer responseCode;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date requestTime;


}
