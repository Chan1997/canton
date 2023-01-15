/*
 * @(#)DateJsonDeserializer.java   1.0  2022年03月17日
 *
 * Copyright (c)	2014-2022. All Rights Reserved.	GuangZhou hhmk Technology Company LTD.
 */
package com.canton.util.type.json;

import com.canton.util.type.CanUtil;
import com.canton.util.type.DateUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;

/**
 * example：
 * @JsonDeserialize(using= LongDateJsonDeserializer.class)
 * private Date createTime;
 *
 *
 * @author 宇文
 * @version 1.0  2022年03月17日
 */
public class DateJsonDeserializer extends JsonDeserializer<Date> {


    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if(jsonParser==null) return null;
        if(CanUtil.isNull(jsonParser.getText())) return null;
        Date date  = DateUtil.parseDate(jsonParser.getText());
        return date;
    }
}
