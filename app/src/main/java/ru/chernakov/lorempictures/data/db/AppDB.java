package ru.chernakov.lorempictures.data.db;

import com.raizlabs.android.dbflow.annotation.Database;

import ru.chernakov.lorempictures.BuildConfig;

@Database(name = AppDB.DB_NAME, version = AppDB.VERSION)
public class AppDB {

	public static final String DB_NAME = "application_db";

	public static final int VERSION = BuildConfig.VERSION_CODE;
}
