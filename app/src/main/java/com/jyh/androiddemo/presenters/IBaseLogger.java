package com.jyh.androiddemo.presenters;

public interface IBaseLogger {

    void debug(String str);

    void info(String str);

    void warn(String str);

    void error(String str);

    void wtf(String str);

    String getTag();

}
