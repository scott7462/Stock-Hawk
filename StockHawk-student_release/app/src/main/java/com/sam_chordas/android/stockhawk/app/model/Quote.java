package com.sam_chordas.android.stockhawk.app.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sam_chordas.android.stockhawk.db.provider.Contract;
import com.tojc.ormlite.android.annotation.AdditionalAnnotation.DefaultContentMimeTypeVnd;
import com.tojc.ormlite.android.annotation.AdditionalAnnotation.DefaultContentUri;

/**
 * Created by scott7462 on 3/28/16.
 */
@DatabaseTable(tableName = Contract.Quote.TABLE_NAME)
@DefaultContentUri(authority = Contract.AUTHORITY, path = Contract.Quote.CONTENT_URI_PATH)
@DefaultContentMimeTypeVnd(name = Contract.Quote.MIMETYPE_NAME, type = Contract.Quote.MIMETYPE_TYPE)
public class Quote implements Parcelable {

    private static final String FIELD_ID = "_id";
    public static final String SYMBOL = "symbol";

    public static final String QUOTE = Quote.class.getSimpleName();

    @DatabaseField(generatedId = true, columnName = FIELD_ID)
    private int id;
    @DatabaseField(columnName = Contract.Quote.SYMBOL)
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @DatabaseField(columnName = Contract.Quote.BID)
    @SerializedName("Bid")
    @Expose
    private String bid;
    @DatabaseField(columnName = Contract.Quote.CHANGE)
    @SerializedName("Change")
    @Expose
    private String change;
    @DatabaseField(columnName = Contract.Quote.OPEN)
    @SerializedName("Open")
    @Expose
    private String open;
    @DatabaseField(columnName = Contract.Quote.NAME)
    @SerializedName("Name")
    @Expose
    private String name;
    @DatabaseField(columnName = Contract.Quote.PERCENT_CHANGE)
    @SerializedName("PercentChange")
    @Expose
    private String percentChange;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return The symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol The symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }


    public String getChange() {
        return change;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }


    public String getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }

    public Quote() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.symbol);
        dest.writeString(this.bid);
        dest.writeString(this.change);
        dest.writeString(this.name);
        dest.writeString(this.open);
        dest.writeString(this.percentChange);
    }

    public Quote(int id, String symbol, String bid, String change, String open, String name, String percentChange) {
        this.id = id;
        this.symbol = symbol;
        this.bid = bid;
        this.change = change;
        this.open = open;
        this.name = name;
        this.percentChange = percentChange;
    }

    public static Quote CursorQuote(Cursor cursor) {
        try {
            int idIndex = cursor.getColumnIndexOrThrow(FIELD_ID);
            int symbolIndex = cursor.getColumnIndexOrThrow(Contract.Quote.SYMBOL);
            int bidIndex = cursor.getColumnIndexOrThrow(Contract.Quote.BID);
            int changeIndex = cursor.getColumnIndexOrThrow(Contract.Quote.CHANGE);
            int nameIndex = cursor.getColumnIndexOrThrow(Contract.Quote.NAME);
            int openIndex = cursor.getColumnIndexOrThrow(Contract.Quote.OPEN);
            int percentChangeIndex = cursor.getColumnIndexOrThrow(Contract.Quote.PERCENT_CHANGE);
            return new Quote(cursor.getInt(idIndex),
                    cursor.getString(symbolIndex),
                    cursor.getString(bidIndex),
                    cursor.getString(changeIndex),
                    cursor.getString(nameIndex),
                    cursor.getString(openIndex),
                    cursor.getString(percentChangeIndex));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected Quote(Parcel in) {
        this.id = in.readInt();
        this.symbol = in.readString();
        this.bid = in.readString();
        this.change = in.readString();
        this.name = in.readString();
        this.open = in.readString();
        this.percentChange = in.readString();
    }

    public static final Creator<Quote> CREATOR = new Creator<Quote>() {
        @Override
        public Quote createFromParcel(Parcel source) {
            return new Quote(source);
        }

        @Override
        public Quote[] newArray(int size) {
            return new Quote[size];
        }
    };
}
