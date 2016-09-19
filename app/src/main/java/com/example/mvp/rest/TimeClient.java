package com.example.mvp.rest;

import com.example.mvp.model.TimeModel;

import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


@Rest(rootUrl = "http://www.timeapi.org/", converters = { MappingJackson2HttpMessageConverter.class })
public interface TimeClient {

    @Get("utc/now.json")
    TimeModel getCurrentUTCTime();

}
