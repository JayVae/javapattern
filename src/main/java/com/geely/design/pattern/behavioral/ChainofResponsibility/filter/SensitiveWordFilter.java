package com.geely.design.pattern.behavioral.ChainofResponsibility.filter;

public class SensitiveWordFilter implements Filter {

    @Override
    public String dofilter(String msg) {
        return msg.replace("fuck", "f**k").replace("Fuck", "F**k");
    }
}
