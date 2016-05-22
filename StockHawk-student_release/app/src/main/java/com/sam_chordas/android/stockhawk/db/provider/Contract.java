package com.sam_chordas.android.stockhawk.db.provider;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

import com.sam_chordas.android.stockhawk.db.DBQLiteHelper;

/**
 * Copyright (C) 2015 The Android Open Source Project
 * <p/>
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
        static final int CONTENT_URI_PATTERN_MANY = 1;
        static final int CONTENT_URI_PATTERN_ONE = 2;

        // Refer to activity.
        public static final Uri contentUri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_CONTENT)
                .authority(AUTHORITY)
                .appendPath(CONTENT_URI_PATH)
                .build();
    }
}