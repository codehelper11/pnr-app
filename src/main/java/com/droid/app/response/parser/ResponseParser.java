package com.droid.app.response.parser;

/**
 * Created by vinay on 25/8/16.
 */
public interface ResponseParser<T,K> {

    T parseResponse(K response);
}
