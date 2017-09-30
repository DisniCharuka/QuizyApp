package com.example.disni.quizy.Database;

import android.provider.BaseColumns;

/**
 * Created by disni on 9/30/2017.
 */

public final class UsersMaster {
    private UsersMaster(){}

    public static class Users implements BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_PASSWORD = "password";
    }
}
