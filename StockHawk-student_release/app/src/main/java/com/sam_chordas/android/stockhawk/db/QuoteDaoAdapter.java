package com.sam_chordas.android.stockhawk.db;

import com.j256.ormlite.dao.Dao;
import com.sam_chordas.android.stockhawk.app.App;
import com.sam_chordas.android.stockhawk.app.model.Quote;
import com.sam_chordas.android.stockhawk.db.provider.Contract;
import com.sam_chordas.android.stockhawk.widget.WidgetUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
public class QuoteDaoAdapter {

    /**
     * Get get all movies
     */
    public static ArrayList<Quote> getAllQuote() throws SQLException {
        DBQLiteHelper dbHelper = App.getDBExternalHelper();
        Dao<Quote, Integer> movieDao = dbHelper.getQuoteDao();
        ArrayList<Quote> quotes = new ArrayList<Quote>(movieDao.queryForAll());
        return quotes;
    }

    /**
     * insert movie
     */
    public static int insertQuote(Quote quote) throws SQLException {
        DBQLiteHelper dbHelper = App.getDBExternalHelper();
        Dao<Quote, Integer> quotesDao = dbHelper.getQuoteDao();
        return quotesDao.create(quote);
    }

    /**
     * remove q
     */
    public static int removeQuote(Quote quote) throws SQLException {
        DBQLiteHelper dbHelper = App.getDBExternalHelper();
        Dao<Quote, Integer> quotesDao = dbHelper.getQuoteDao();
        return quotesDao.delete(quote);
    }

    /**
     * remove q
     */
    public static void updatePositions(ArrayList<Quote> quotes) throws SQLException {
        DBQLiteHelper dbHelper = App.getDBExternalHelper();
        Dao<Quote, Integer> quotesDao = dbHelper.getQuoteDao();
        quotesDao.delete(quotes);
        for (Quote quote : quotes) {
            quotesDao.create(quote);
        }
    }

    /**
     * validate if the movie is in the database
     */
    public static boolean isQuote(String symbol) throws SQLException {
        DBQLiteHelper dbHelper = App.getDBExternalHelper();
        Dao<Quote, Integer> quotesDao = dbHelper.getQuoteDao();
        List<Quote> quotes = quotesDao.queryBuilder().where().eq(Contract.Quote.SYMBOL, symbol).query();
        return (quotes != null && quotes.size() > 0);
    }


    public static void removeAllQuote() throws SQLException {
        DBQLiteHelper dbHelper = App.getDBExternalHelper();
        Dao<Quote, Integer> quotesDao = dbHelper.getQuoteDao();
        quotesDao.delete(quotesDao.queryForAll());
    }
}
