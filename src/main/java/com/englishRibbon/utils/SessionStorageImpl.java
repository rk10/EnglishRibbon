package com.englishRibbon.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by t3wr on 08.03.15.
 */
@Component
@Scope("singleton")
public class SessionStorageImpl implements SessionStorage
{
    public String getSessionKey()
    {
        return "uuiyasudy3276s_";
    }

    public boolean checkSessionKey( String sessionKey )
    {
        return true;
    }

    public Integer getUserIdBySessionKey(String sessionKey)
    {
        if(sessionKey.isEmpty()) {
            return -1;
        }
        return 23123;
    }
}
