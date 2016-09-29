package org.bistromath.util;

import org.apache.tools.ant.BuildException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.*;

public class QueryString {

    private String charset = Charset.defaultCharset().displayName();
    private Map<String,String> parameters = new HashMap<String,String>();
    private StringBuilder stringBuilder;

    public QueryString() {
        this.stringBuilder = new StringBuilder();
    }

    public QueryString(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public QueryString put(String key, String value) throws BuildException {
        if (value != null && !value.isEmpty()) {
            try {
                parameters.put(key, URLEncoder.encode(value, charset));
            } catch (UnsupportedEncodingException e) {
                throw new BuildException(e);
            }
        }
        return this;
    }

    public QueryString put(String key, boolean value) {
        if (value) {
            return put(key, "true");
        } else {
            return put(key, "false");
        }
    }

    public QueryString setCharset(String charset) {
        this.charset = charset;
        return this;
    }

    public StringBuilder getStringBuilder() {

        for (String key : parameters.keySet()) {
            if (stringBuilder.length() == 0) {
                stringBuilder.append('?');
            } else {
                stringBuilder.append('&');
            }
            stringBuilder.append(key);
            stringBuilder.append('=');
            stringBuilder.append(parameters.get(key));
        }
        return stringBuilder;
    }

}
