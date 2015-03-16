package com.englishRibbon.utils;

/**
 * Created by t3wr on 08.03.15.
 */
public interface SessionStorage
{
    String getSessionKey();

    boolean checkSessionKey( String sessionKey );

    Integer getUserIdBySessionKey(String sessionKey);
}
