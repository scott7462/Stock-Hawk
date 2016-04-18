package com.sam_chordas.android.stockhawk.db.provider;

import com.sam_chordas.android.stockhawk.db.DBQLiteHelper;
import com.tojc.ormlite.android.OrmLiteSimpleContentProvider;
import com.tojc.ormlite.android.framework.MatcherController;
import com.tojc.ormlite.android.framework.MimeTypeVnd;

/**
 * Created by scott7462 on 4/17/16.
 */
public class DBProvider extends OrmLiteSimpleContentProvider<DBQLiteHelper> {
    @Override
    protected Class<DBQLiteHelper> getHelperClass() {
        return DBQLiteHelper.class;
    }

    @Override
    public boolean onCreate() {
        setMatcherController(new MatcherController()
                .add(com.sam_chordas.android.stockhawk.app.model.Quote.class, MimeTypeVnd.SubType.DIRECTORY, "", Contract.Quote.CONTENT_URI_PATTERN_MANY)
                .add(com.sam_chordas.android.stockhawk.app.model.Quote.class, MimeTypeVnd.SubType.ITEM, "#", Contract.Quote.CONTENT_URI_PATTERN_ONE)
        );
        return true;
    }
}

