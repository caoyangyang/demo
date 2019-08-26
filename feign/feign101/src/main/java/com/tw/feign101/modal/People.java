package com.tw.feign101.modal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class People {
    private  String name;
    private  String url;

}
