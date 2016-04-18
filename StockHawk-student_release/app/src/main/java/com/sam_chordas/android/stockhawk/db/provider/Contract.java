package com.sam_chordas.android.stockhawk.db.provider;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

import com.sam_chordas.android.stockhawk.db.DBQLiteHelper;

/**
 * Created by scott7462 on 4/17/16.
 */
public class Contract {
    public static final String DATABASE_NAME = DBQLiteHelper.DATABASE_EXTERNAL_NAME;
    public static final int DATABASE_VERSION = DBQLiteHelper.DATABASE_EXTERNAL_VERSION;

    public static final String AUTHORITY = "com.sam_chordas.android.stockhawk.app.model.Quote";

    // accounts table info
    public static class Quote implements BaseColumns {
        public static final String TABLE_NAME = "quotes";

        public static final String CONTENT_URI_PATH = TABLE_NAME;

        public static final String MIMETYPE_TYPE = TABLE_NAME;
        public static final String MIMETYPE_NAME = AUTHORITY + ".provider";

        // feild info
        public static final String NAME = "Name";
        public static final String SYMBOL = "Symbol";
        public static final String BID = "Bid";
        public static final String CHANGE = "Change";
        public static final String OPEN = "Open";
        public static final String PERCENT_CHANGE = "PercentChange";


        // content uri pattern code
        public static final int CONTENT_URI_PATTERN_MANY = 1;
        public static final int CONTENT_URI_PATTERN_ONE = 2;

        // Refer to activity.
        public static final Uri contentUri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_CONTENT)
                .authority(AUTHORITY)
                .appendPath(CONTENT_URI_PATH)
                .build();
    }
}