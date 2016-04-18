package com.sam_chordas.android.stockhawk.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by scott7462 on 4/17/16.
 */
@DatabaseTable
public class QuoteHistory implements Parcelable {

    private static final String FIELD_ID = "_id";

    @DatabaseField(generatedId = true, columnName = FIELD_ID)
    private int id;
    @DatabaseField
    @SerializedName("Symbol")
    @Expose
    private String Symbol;
    @DatabaseField
    @SerializedName("Date")
    @Expose
    private String Date;
    @DatabaseField
    @SerializedName("Open")
    @Expose
    private String Open;
    @DatabaseField
    @SerializedName("High")
    @Expose
    private String High;
    @DatabaseField
    @SerializedName("Low")
    @Expose
    private String Low;
    @DatabaseField
    @SerializedName("Close")
    @Expose
    private String Close;
    @DatabaseField
    @SerializedName("Volume")
    @Expose
    private String Volume;
    @DatabaseField
    @SerializedName("Adj_Close")
    @Expose
    private String AdjClose;

    /**
     * @return The Symbol
     */
    public String getSymbol() {
        return Symbol;
    }

    /**
     * @param Symbol The Symbol
     */
    public void setSymbol(String Symbol) {
        this.Symbol = Symbol;
    }

    /**
     * @return The Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date The Date
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     * @return The Open
     */
    public String getOpen() {
        return Open;
    }

    /**
     * @param Open The Open
     */
    public void setOpen(String Open) {
        this.Open = Open;
    }

    /**
     * @return The High
     */
    public String getHigh() {
        return High;
    }

    /**
     * @param High The High
     */
    public void setHigh(String High) {
        this.High = High;
    }

    /**
     * @return The Low
     */
    public String getLow() {
        return Low;
    }

    /**
     * @param Low The Low
     */
    public void setLow(String Low) {
        this.Low = Low;
    }

    /**
     * @return The Close
     */
    public String getClose() {
        return Close;
    }

    /**
     * @param Close The Close
     */
    public void setClose(String Close) {
        this.Close = Close;
    }

    /**
     * @return The Volume
     */
    public String getVolume() {
        return Volume;
    }

    /**
     * @param Volume The Volume
     */
    public void setVolume(String Volume) {
        this.Volume = Volume;
    }

    /**
     * @return The AdjClose
     */
    public String getAdjClose() {
        return AdjClose;
    }

    /**
     * @param AdjClose The Adj_Close
     */
    public void setAdjClose(String AdjClose) {
        this.AdjClose = AdjClose;
    }


    protected QuoteHistory(Parcel in) {
        id = in.readInt();
        Symbol = in.readString();
        Date = in.readString();
        Open = in.readString();
        High = in.readString();
        Low = in.readString();
        Close = in.readString();
        Volume = in.readString();
        AdjClose = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(Symbol);
        dest.writeString(Date);
        dest.writeString(Open);
        dest.writeString(High);
        dest.writeString(Low);
        dest.writeString(Close);
        dest.writeString(Volume);
        dest.writeString(AdjClose);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<QuoteHistory> CREATOR = new Parcelable.Creator<QuoteHistory>() {
        @Override
        public QuoteHistory createFromParcel(Parcel in) {
            return new QuoteHistory(in);
        }

        @Override
        public QuoteHistory[] newArray(int size) {
            return new QuoteHistory[size];
        }
    };


}