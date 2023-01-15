/*
 * @(#)DateJsonSerializer.java   1.0  2022年03月18日
 *
 * Copyright (c)	2014-2022. All Rights Reserved.	GuangZhou hhmk Technology Company LTD.
 */
package com.canton.util.type.json;

import com.canton.util.type.DateUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * example：
 * @JsonSerialize(using= DateJsonSerializer.class)
 * private Date createTime;
 *
 * @author 宇文
 * @version 1.0  2022年03月18日
 */
public class DateJsonSerializer extends JsonSerializer<Date> {


    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(date==null) return;
        jsonGenerator.writeString(DateUtil.formatDate(date));
    }
}
