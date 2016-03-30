package com.sam_chordas.android.stockhawk.app.db;

import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.sam_chordas.android.stockhawk.app.App;
import com.sam_chordas.android.stockhawk.app.model.Quote;

import java.sql.SQLException;


/**
 * Copyright (C) 2015 The Android Open Source Project
 * <p/>8
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class DBQLiteHelper extends OrmLiteSqliteOpenHelper {

    public static final String DATABASE_EXTERNAL_NAME = "quote.db";
    private static final int DATABASE_EXTERNAL_VERSION = 1;
    private Dao<Quote, Integer> quoteDao;

    public DBQLiteHelper() {
        super(App.getGlobalContext(), DATABASE_EXTERNAL_NAME, null, DATABASE_EXTERNAL_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Quote.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Quote.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        super.close();
        setQuoteDao(null);
    }

    /**
     * Get the dao to access the quote table
     */
    public Dao<Quote, Integer> getQuoteDao() throws SQLException {
        if (quoteDao == null) {
            quoteDao = getDao(Quote.class);
        }
        return quoteDao;
    }

    public void setQuoteDao(Dao<Quote, Integer> quoteDao) {
        this.quoteDao = quoteDao;
    }

}
