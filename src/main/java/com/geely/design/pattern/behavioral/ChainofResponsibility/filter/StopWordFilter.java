package com.geely.design.pattern.behavioral.ChainofResponsibility.filter;

public class StopWordFilter implements Filter {

    @Override
    public String dofilter(String msg) {
        return msg.replace("and", "").replace("to", "").replace("ing", "").replace("is", "");
    }
}
