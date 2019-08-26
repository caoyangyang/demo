package com.tw.feign101.modal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookKind {
    private  String shortName;
    private int id;
}
