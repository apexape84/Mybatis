package com.ogiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface Mapper {
    @Select("SELECT CURRENT_DATE() FROM DUAL")
    Date selectSysDate();
}
