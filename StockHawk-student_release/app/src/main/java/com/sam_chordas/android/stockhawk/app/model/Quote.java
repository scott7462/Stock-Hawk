package com.sam_chordas.android.stockhawk.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import net.simonvt.schematic.annotation.DataType;
import net.simonvt.schematic.annotation.NotNull;

/**
 * Created by scott7462 on 3/28/16.
 */
@DatabaseTable
public class Quote implements Parcelable {

    @DataType(DataType.Type.TEXT)
    @NotNull
    public static final String SYMBOL = "symbol";
    @DataType(DataType.Type.TEXT)
    @NotNull
    public static final String PERCENT_CHANGE = "percent_change";
    @DataType(DataType.Type.TEXT)
    @NotNull
    public static final String CHANGE = "change";
    @DataType(DataType.Type.TEXT)
    @NotNull
    public static final String BIDPRICE = "bid_price";
    @DataType(DataType.Type.TEXT)
    public static final String CREATED = "created";
    @DataType(DataType.Type.INTEGER)
    @NotNull
    public static final String ISUP = "is_up";
    @DataType(DataType.Type.INTEGER)
    @NotNull
    public static final String ISCURRENT = "is_current";
    private static final String FIELD_ID = "_id";


    @DatabaseField(generatedId = true, columnName = FIELD_ID)
    private String id;
    @DatabaseField
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("Ask")
    @Expose
    private String Ask;
    @SerializedName("AverageDailyVolume")
    @Expose
    private String AverageDailyVolume;
    @DatabaseField
    @SerializedName("Bid")
    @Expose
    private String Bid;
    @SerializedName("AskRealtime")
    @Expose
    private Object AskRealtime;
    @SerializedName("BidRealtime")
    @Expose
    private Object BidRealtime;
    @SerializedName("BookValue")
    @Expose
    private String BookValue;
    @SerializedName("Change_PercentChange")
    @Expose
    private String ChangePercentChange;
    @DatabaseField
    @SerializedName("Change")
    @Expose
    private String Change;
    @SerializedName("Commission")
    @Expose
    private Object Commission;
    @SerializedName("Currency")
    @Expose
    private String Currency;
    @SerializedName("ChangeRealtime")
    @Expose
    private Object ChangeRealtime;
    @SerializedName("AfterHoursChangeRealtime")
    @Expose
    private Object AfterHoursChangeRealtime;
    @SerializedName("DividendShare")
    @Expose
    private Object DividendShare;
    @SerializedName("LastTradeDate")
    @Expose
    private String LastTradeDate;
    @SerializedName("TradeDate")
    @Expose
    private Object TradeDate;
    @SerializedName("EarningsShare")
    @Expose
    private String EarningsShare;
    @SerializedName("ErrorIndicationreturnedforsymbolchangedinvalid")
    @Expose
    private Object ErrorIndicationreturnedforsymbolchangedinvalid;
    @SerializedName("EPSEstimateCurrentYear")
    @Expose
    private String EPSEstimateCurrentYear;
    @SerializedName("EPSEstimateNextYear")
    @Expose
    private String EPSEstimateNextYear;
    @SerializedName("EPSEstimateNextQuarter")
    @Expose
    private String EPSEstimateNextQuarter;
    @SerializedName("DaysLow")
    @Expose
    private String DaysLow;
    @SerializedName("DaysHigh")
    @Expose
    private String DaysHigh;
    @SerializedName("YearLow")
    @Expose
    private String YearLow;
    @SerializedName("YearHigh")
    @Expose
    private String YearHigh;
    @SerializedName("HoldingsGainPercent")
    @Expose
    private Object HoldingsGainPercent;
    @SerializedName("AnnualizedGain")
    @Expose
    private Object AnnualizedGain;
    @SerializedName("HoldingsGain")
    @Expose
    private Object HoldingsGain;
    @SerializedName("HoldingsGainPercentRealtime")
    @Expose
    private Object HoldingsGainPercentRealtime;
    @SerializedName("HoldingsGainRealtime")
    @Expose
    private Object HoldingsGainRealtime;
    @SerializedName("MoreInfo")
    @Expose
    private Object MoreInfo;
    @SerializedName("OrderBookRealtime")
    @Expose
    private Object OrderBookRealtime;
    @SerializedName("MarketCapitalization")
    @Expose
    private String MarketCapitalization;
    @SerializedName("MarketCapRealtime")
    @Expose
    private Object MarketCapRealtime;
    @SerializedName("EBITDA")
    @Expose
    private String EBITDA;
    @SerializedName("ChangeFromYearLow")
    @Expose
    private String ChangeFromYearLow;
    @SerializedName("PercentChangeFromYearLow")
    @Expose
    private String PercentChangeFromYearLow;
    @SerializedName("LastTradeRealtimeWithTime")
    @Expose
    private Object LastTradeRealtimeWithTime;
    @SerializedName("ChangePercentRealtime")
    @Expose
    private Object ChangePercentRealtime;
    @SerializedName("ChangeFromYearHigh")
    @Expose
    private String ChangeFromYearHigh;
    @SerializedName("PercebtChangeFromYearHigh")
    @Expose
    private String PercebtChangeFromYearHigh;
    @SerializedName("LastTradeWithTime")
    @Expose
    private String LastTradeWithTime;
    @SerializedName("LastTradePriceOnly")
    @Expose
    private String LastTradePriceOnly;
    @SerializedName("HighLimit")
    @Expose
    private Object HighLimit;
    @SerializedName("LowLimit")
    @Expose
    private Object LowLimit;
    @SerializedName("DaysRange")
    @Expose
    private String DaysRange;
    @SerializedName("DaysRangeRealtime")
    @Expose
    private Object DaysRangeRealtime;
    @SerializedName("FiftydayMovingAverage")
    @Expose
    private String FiftydayMovingAverage;
    @SerializedName("TwoHundreddayMovingAverage")
    @Expose
    private String TwoHundreddayMovingAverage;
    @SerializedName("ChangeFromTwoHundreddayMovingAverage")
    @Expose
    private String ChangeFromTwoHundreddayMovingAverage;
    @SerializedName("PercentChangeFromTwoHundreddayMovingAverage")
    @Expose
    private String PercentChangeFromTwoHundreddayMovingAverage;
    @SerializedName("ChangeFromFiftydayMovingAverage")
    @Expose
    private String ChangeFromFiftydayMovingAverage;
    @SerializedName("PercentChangeFromFiftydayMovingAverage")
    @Expose
    private String PercentChangeFromFiftydayMovingAverage;
    @SerializedName("Name")
    @Expose
    private String Name;
    @SerializedName("Notes")
    @Expose
    private Object Notes;
    @SerializedName("Open")
    @Expose
    private String Open;
    @SerializedName("PreviousClose")
    @Expose
    private String PreviousClose;
    @SerializedName("PricePaid")
    @Expose
    private Object PricePaid;
    @SerializedName("ChangeinPercent")
    @Expose
    private String ChangeinPercent;
    @SerializedName("PriceSales")
    @Expose
    private String PriceSales;
    @SerializedName("PriceBook")
    @Expose
    private String PriceBook;
    @SerializedName("ExDividendDate")
    @Expose
    private Object ExDividendDate;
    @SerializedName("PERatio")
    @Expose
    private Object PERatio;
    @SerializedName("DividendPayDate")
    @Expose
    private Object DividendPayDate;
    @SerializedName("PERatioRealtime")
    @Expose
    private Object PERatioRealtime;
    @SerializedName("PEGRatio")
    @Expose
    private String PEGRatio;
    @SerializedName("PriceEPSEstimateCurrentYear")
    @Expose
    private String PriceEPSEstimateCurrentYear;
    @SerializedName("PriceEPSEstimateNextYear")
    @Expose
    private String PriceEPSEstimateNextYear;
    @SerializedName("SharesOwned")
    @Expose
    private Object SharesOwned;
    @SerializedName("ShortRatio")
    @Expose
    private String ShortRatio;
    @SerializedName("LastTradeTime")
    @Expose
    private String LastTradeTime;
    @SerializedName("TickerTrend")
    @Expose
    private Object TickerTrend;
    @SerializedName("OneyrTargetPrice")
    @Expose
    private String OneyrTargetPrice;
    @SerializedName("Volume")
    @Expose
    private String Volume;
    @SerializedName("HoldingsValue")
    @Expose
    private Object HoldingsValue;
    @SerializedName("HoldingsValueRealtime")
    @Expose
    private Object HoldingsValueRealtime;
    @SerializedName("YearRange")
    @Expose
    private String YearRange;
    @SerializedName("DaysValueChange")
    @Expose
    private Object DaysValueChange;
    @SerializedName("DaysValueChangeRealtime")
    @Expose
    private Object DaysValueChangeRealtime;
    @SerializedName("StockExchange")
    @Expose
    private String StockExchange;
    @SerializedName("DividendYield")
    @Expose
    private Object DividendYield;
    @SerializedName("PercentChange")
    @Expose
    private String PercentChange;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    /**
     * @return The Ask
     */
    public String getAsk() {
        return Ask;
    }

    /**
     * @param Ask The Ask
     */
    public void setAsk(String Ask) {
        this.Ask = Ask;
    }

    /**
     * @return The AverageDailyVolume
     */
    public String getAverageDailyVolume() {
        return AverageDailyVolume;
    }

    /**
     * @param AverageDailyVolume The AverageDailyVolume
     */
    public void setAverageDailyVolume(String AverageDailyVolume) {
        this.AverageDailyVolume = AverageDailyVolume;
    }

    /**
     * @return The Bid
     */
    public String getBid() {
        return Bid;
    }

    /**
     * @param Bid The Bid
     */
    public void setBid(String Bid) {
        this.Bid = Bid;
    }

    /**
     * @return The AskRealtime
     */
    public Object getAskRealtime() {
        return AskRealtime;
    }

    /**
     * @param AskRealtime The AskRealtime
     */
    public void setAskRealtime(Object AskRealtime) {
        this.AskRealtime = AskRealtime;
    }

    /**
     * @return The BidRealtime
     */
    public Object getBidRealtime() {
        return BidRealtime;
    }

    /**
     * @param BidRealtime The BidRealtime
     */
    public void setBidRealtime(Object BidRealtime) {
        this.BidRealtime = BidRealtime;
    }

    /**
     * @return The BookValue
     */
    public String getBookValue() {
        return BookValue;
    }

    /**
     * @param BookValue The BookValue
     */
    public void setBookValue(String BookValue) {
        this.BookValue = BookValue;
    }

    /**
     * @return The ChangePercentChange
     */
    public String getChangePercentChange() {
        return ChangePercentChange;
    }

    /**
     * @param ChangePercentChange The Change_PercentChange
     */
    public void setChangePercentChange(String ChangePercentChange) {
        this.ChangePercentChange = ChangePercentChange;
    }

    /**
     * @return The Change
     */
    public String getChange() {
        return Change;
    }

    /**
     * @param Change The Change
     */
    public void setChange(String Change) {
        this.Change = Change;
    }

    /**
     * @return The Commission
     */
    public Object getCommission() {
        return Commission;
    }

    /**
     * @param Commission The Commission
     */
    public void setCommission(Object Commission) {
        this.Commission = Commission;
    }

    /**
     * @return The Currency
     */
    public String getCurrency() {
        return Currency;
    }

    /**
     * @param Currency The Currency
     */
    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }

    /**
     * @return The ChangeRealtime
     */
    public Object getChangeRealtime() {
        return ChangeRealtime;
    }

    /**
     * @param ChangeRealtime The ChangeRealtime
     */
    public void setChangeRealtime(Object ChangeRealtime) {
        this.ChangeRealtime = ChangeRealtime;
    }

    /**
     * @return The AfterHoursChangeRealtime
     */
    public Object getAfterHoursChangeRealtime() {
        return AfterHoursChangeRealtime;
    }

    /**
     * @param AfterHoursChangeRealtime The AfterHoursChangeRealtime
     */
    public void setAfterHoursChangeRealtime(Object AfterHoursChangeRealtime) {
        this.AfterHoursChangeRealtime = AfterHoursChangeRealtime;
    }

    /**
     * @return The DividendShare
     */
    public Object getDividendShare() {
        return DividendShare;
    }

    /**
     * @param DividendShare The DividendShare
     */
    public void setDividendShare(Object DividendShare) {
        this.DividendShare = DividendShare;
    }

    /**
     * @return The LastTradeDate
     */
    public String getLastTradeDate() {
        return LastTradeDate;
    }

    /**
     * @param LastTradeDate The LastTradeDate
     */
    public void setLastTradeDate(String LastTradeDate) {
        this.LastTradeDate = LastTradeDate;
    }

    /**
     * @return The TradeDate
     */
    public Object getTradeDate() {
        return TradeDate;
    }

    /**
     * @param TradeDate The TradeDate
     */
    public void setTradeDate(Object TradeDate) {
        this.TradeDate = TradeDate;
    }

    /**
     * @return The EarningsShare
     */
    public String getEarningsShare() {
        return EarningsShare;
    }

    /**
     * @param EarningsShare The EarningsShare
     */
    public void setEarningsShare(String EarningsShare) {
        this.EarningsShare = EarningsShare;
    }

    /**
     * @return The ErrorIndicationreturnedforsymbolchangedinvalid
     */
    public Object getErrorIndicationreturnedforsymbolchangedinvalid() {
        return ErrorIndicationreturnedforsymbolchangedinvalid;
    }

    /**
     * @param ErrorIndicationreturnedforsymbolchangedinvalid The ErrorIndicationreturnedforsymbolchangedinvalid
     */
    public void setErrorIndicationreturnedforsymbolchangedinvalid(Object ErrorIndicationreturnedforsymbolchangedinvalid) {
        this.ErrorIndicationreturnedforsymbolchangedinvalid = ErrorIndicationreturnedforsymbolchangedinvalid;
    }

    /**
     * @return The EPSEstimateCurrentYear
     */
    public String getEPSEstimateCurrentYear() {
        return EPSEstimateCurrentYear;
    }

    /**
     * @param EPSEstimateCurrentYear The EPSEstimateCurrentYear
     */
    public void setEPSEstimateCurrentYear(String EPSEstimateCurrentYear) {
        this.EPSEstimateCurrentYear = EPSEstimateCurrentYear;
    }

    /**
     * @return The EPSEstimateNextYear
     */
    public String getEPSEstimateNextYear() {
        return EPSEstimateNextYear;
    }

    /**
     * @param EPSEstimateNextYear The EPSEstimateNextYear
     */
    public void setEPSEstimateNextYear(String EPSEstimateNextYear) {
        this.EPSEstimateNextYear = EPSEstimateNextYear;
    }

    /**
     * @return The EPSEstimateNextQuarter
     */
    public String getEPSEstimateNextQuarter() {
        return EPSEstimateNextQuarter;
    }

    /**
     * @param EPSEstimateNextQuarter The EPSEstimateNextQuarter
     */
    public void setEPSEstimateNextQuarter(String EPSEstimateNextQuarter) {
        this.EPSEstimateNextQuarter = EPSEstimateNextQuarter;
    }

    /**
     * @return The DaysLow
     */
    public String getDaysLow() {
        return DaysLow;
    }

    /**
     * @param DaysLow The DaysLow
     */
    public void setDaysLow(String DaysLow) {
        this.DaysLow = DaysLow;
    }

    /**
     * @return The DaysHigh
     */
    public String getDaysHigh() {
        return DaysHigh;
    }

    /**
     * @param DaysHigh The DaysHigh
     */
    public void setDaysHigh(String DaysHigh) {
        this.DaysHigh = DaysHigh;
    }

    /**
     * @return The YearLow
     */
    public String getYearLow() {
        return YearLow;
    }

    /**
     * @param YearLow The YearLow
     */
    public void setYearLow(String YearLow) {
        this.YearLow = YearLow;
    }

    /**
     * @return The YearHigh
     */
    public String getYearHigh() {
        return YearHigh;
    }

    /**
     * @param YearHigh The YearHigh
     */
    public void setYearHigh(String YearHigh) {
        this.YearHigh = YearHigh;
    }

    /**
     * @return The HoldingsGainPercent
     */
    public Object getHoldingsGainPercent() {
        return HoldingsGainPercent;
    }

    /**
     * @param HoldingsGainPercent The HoldingsGainPercent
     */
    public void setHoldingsGainPercent(Object HoldingsGainPercent) {
        this.HoldingsGainPercent = HoldingsGainPercent;
    }

    /**
     * @return The AnnualizedGain
     */
    public Object getAnnualizedGain() {
        return AnnualizedGain;
    }

    /**
     * @param AnnualizedGain The AnnualizedGain
     */
    public void setAnnualizedGain(Object AnnualizedGain) {
        this.AnnualizedGain = AnnualizedGain;
    }

    /**
     * @return The HoldingsGain
     */
    public Object getHoldingsGain() {
        return HoldingsGain;
    }

    /**
     * @param HoldingsGain The HoldingsGain
     */
    public void setHoldingsGain(Object HoldingsGain) {
        this.HoldingsGain = HoldingsGain;
    }

    /**
     * @return The HoldingsGainPercentRealtime
     */
    public Object getHoldingsGainPercentRealtime() {
        return HoldingsGainPercentRealtime;
    }

    /**
     * @param HoldingsGainPercentRealtime The HoldingsGainPercentRealtime
     */
    public void setHoldingsGainPercentRealtime(Object HoldingsGainPercentRealtime) {
        this.HoldingsGainPercentRealtime = HoldingsGainPercentRealtime;
    }

    /**
     * @return The HoldingsGainRealtime
     */
    public Object getHoldingsGainRealtime() {
        return HoldingsGainRealtime;
    }

    /**
     * @param HoldingsGainRealtime The HoldingsGainRealtime
     */
    public void setHoldingsGainRealtime(Object HoldingsGainRealtime) {
        this.HoldingsGainRealtime = HoldingsGainRealtime;
    }

    /**
     * @return The MoreInfo
     */
    public Object getMoreInfo() {
        return MoreInfo;
    }

    /**
     * @param MoreInfo The MoreInfo
     */
    public void setMoreInfo(Object MoreInfo) {
        this.MoreInfo = MoreInfo;
    }

    /**
     * @return The OrderBookRealtime
     */
    public Object getOrderBookRealtime() {
        return OrderBookRealtime;
    }

    /**
     * @param OrderBookRealtime The OrderBookRealtime
     */
    public void setOrderBookRealtime(Object OrderBookRealtime) {
        this.OrderBookRealtime = OrderBookRealtime;
    }

    /**
     * @return The MarketCapitalization
     */
    public String getMarketCapitalization() {
        return MarketCapitalization;
    }

    /**
     * @param MarketCapitalization The MarketCapitalization
     */
    public void setMarketCapitalization(String MarketCapitalization) {
        this.MarketCapitalization = MarketCapitalization;
    }

    /**
     * @return The MarketCapRealtime
     */
    public Object getMarketCapRealtime() {
        return MarketCapRealtime;
    }

    /**
     * @param MarketCapRealtime The MarketCapRealtime
     */
    public void setMarketCapRealtime(Object MarketCapRealtime) {
        this.MarketCapRealtime = MarketCapRealtime;
    }

    /**
     * @return The EBITDA
     */
    public String getEBITDA() {
        return EBITDA;
    }

    /**
     * @param EBITDA The EBITDA
     */
    public void setEBITDA(String EBITDA) {
        this.EBITDA = EBITDA;
    }

    /**
     * @return The ChangeFromYearLow
     */
    public String getChangeFromYearLow() {
        return ChangeFromYearLow;
    }

    /**
     * @param ChangeFromYearLow The ChangeFromYearLow
     */
    public void setChangeFromYearLow(String ChangeFromYearLow) {
        this.ChangeFromYearLow = ChangeFromYearLow;
    }

    /**
     * @return The PercentChangeFromYearLow
     */
    public String getPercentChangeFromYearLow() {
        return PercentChangeFromYearLow;
    }

    /**
     * @param PercentChangeFromYearLow The PercentChangeFromYearLow
     */
    public void setPercentChangeFromYearLow(String PercentChangeFromYearLow) {
        this.PercentChangeFromYearLow = PercentChangeFromYearLow;
    }

    /**
     * @return The LastTradeRealtimeWithTime
     */
    public Object getLastTradeRealtimeWithTime() {
        return LastTradeRealtimeWithTime;
    }

    /**
     * @param LastTradeRealtimeWithTime The LastTradeRealtimeWithTime
     */
    public void setLastTradeRealtimeWithTime(Object LastTradeRealtimeWithTime) {
        this.LastTradeRealtimeWithTime = LastTradeRealtimeWithTime;
    }

    /**
     * @return The ChangePercentRealtime
     */
    public Object getChangePercentRealtime() {
        return ChangePercentRealtime;
    }

    /**
     * @param ChangePercentRealtime The ChangePercentRealtime
     */
    public void setChangePercentRealtime(Object ChangePercentRealtime) {
        this.ChangePercentRealtime = ChangePercentRealtime;
    }

    /**
     * @return The ChangeFromYearHigh
     */
    public String getChangeFromYearHigh() {
        return ChangeFromYearHigh;
    }

    /**
     * @param ChangeFromYearHigh The ChangeFromYearHigh
     */
    public void setChangeFromYearHigh(String ChangeFromYearHigh) {
        this.ChangeFromYearHigh = ChangeFromYearHigh;
    }

    /**
     * @return The PercebtChangeFromYearHigh
     */
    public String getPercebtChangeFromYearHigh() {
        return PercebtChangeFromYearHigh;
    }

    /**
     * @param PercebtChangeFromYearHigh The PercebtChangeFromYearHigh
     */
    public void setPercebtChangeFromYearHigh(String PercebtChangeFromYearHigh) {
        this.PercebtChangeFromYearHigh = PercebtChangeFromYearHigh;
    }

    /**
     * @return The LastTradeWithTime
     */
    public String getLastTradeWithTime() {
        return LastTradeWithTime;
    }

    /**
     * @param LastTradeWithTime The LastTradeWithTime
     */
    public void setLastTradeWithTime(String LastTradeWithTime) {
        this.LastTradeWithTime = LastTradeWithTime;
    }

    /**
     * @return The LastTradePriceOnly
     */
    public String getLastTradePriceOnly() {
        return LastTradePriceOnly;
    }

    /**
     * @param LastTradePriceOnly The LastTradePriceOnly
     */
    public void setLastTradePriceOnly(String LastTradePriceOnly) {
        this.LastTradePriceOnly = LastTradePriceOnly;
    }

    /**
     * @return The HighLimit
     */
    public Object getHighLimit() {
        return HighLimit;
    }

    /**
     * @param HighLimit The HighLimit
     */
    public void setHighLimit(Object HighLimit) {
        this.HighLimit = HighLimit;
    }

    /**
     * @return The LowLimit
     */
    public Object getLowLimit() {
        return LowLimit;
    }

    /**
     * @param LowLimit The LowLimit
     */
    public void setLowLimit(Object LowLimit) {
        this.LowLimit = LowLimit;
    }

    /**
     * @return The DaysRange
     */
    public String getDaysRange() {
        return DaysRange;
    }

    /**
     * @param DaysRange The DaysRange
     */
    public void setDaysRange(String DaysRange) {
        this.DaysRange = DaysRange;
    }

    /**
     * @return The DaysRangeRealtime
     */
    public Object getDaysRangeRealtime() {
        return DaysRangeRealtime;
    }

    /**
     * @param DaysRangeRealtime The DaysRangeRealtime
     */
    public void setDaysRangeRealtime(Object DaysRangeRealtime) {
        this.DaysRangeRealtime = DaysRangeRealtime;
    }

    /**
     * @return The FiftydayMovingAverage
     */
    public String getFiftydayMovingAverage() {
        return FiftydayMovingAverage;
    }

    /**
     * @param FiftydayMovingAverage The FiftydayMovingAverage
     */
    public void setFiftydayMovingAverage(String FiftydayMovingAverage) {
        this.FiftydayMovingAverage = FiftydayMovingAverage;
    }

    /**
     * @return The TwoHundreddayMovingAverage
     */
    public String getTwoHundreddayMovingAverage() {
        return TwoHundreddayMovingAverage;
    }

    /**
     * @param TwoHundreddayMovingAverage The TwoHundreddayMovingAverage
     */
    public void setTwoHundreddayMovingAverage(String TwoHundreddayMovingAverage) {
        this.TwoHundreddayMovingAverage = TwoHundreddayMovingAverage;
    }

    /**
     * @return The ChangeFromTwoHundreddayMovingAverage
     */
    public String getChangeFromTwoHundreddayMovingAverage() {
        return ChangeFromTwoHundreddayMovingAverage;
    }

    /**
     * @param ChangeFromTwoHundreddayMovingAverage The ChangeFromTwoHundreddayMovingAverage
     */
    public void setChangeFromTwoHundreddayMovingAverage(String ChangeFromTwoHundreddayMovingAverage) {
        this.ChangeFromTwoHundreddayMovingAverage = ChangeFromTwoHundreddayMovingAverage;
    }

    /**
     * @return The PercentChangeFromTwoHundreddayMovingAverage
     */
    public String getPercentChangeFromTwoHundreddayMovingAverage() {
        return PercentChangeFromTwoHundreddayMovingAverage;
    }

    /**
     * @param PercentChangeFromTwoHundreddayMovingAverage The PercentChangeFromTwoHundreddayMovingAverage
     */
    public void setPercentChangeFromTwoHundreddayMovingAverage(String PercentChangeFromTwoHundreddayMovingAverage) {
        this.PercentChangeFromTwoHundreddayMovingAverage = PercentChangeFromTwoHundreddayMovingAverage;
    }

    /**
     * @return The ChangeFromFiftydayMovingAverage
     */
    public String getChangeFromFiftydayMovingAverage() {
        return ChangeFromFiftydayMovingAverage;
    }

    /**
     * @param ChangeFromFiftydayMovingAverage The ChangeFromFiftydayMovingAverage
     */
    public void setChangeFromFiftydayMovingAverage(String ChangeFromFiftydayMovingAverage) {
        this.ChangeFromFiftydayMovingAverage = ChangeFromFiftydayMovingAverage;
    }

    /**
     * @return The PercentChangeFromFiftydayMovingAverage
     */
    public String getPercentChangeFromFiftydayMovingAverage() {
        return PercentChangeFromFiftydayMovingAverage;
    }

    /**
     * @param PercentChangeFromFiftydayMovingAverage The PercentChangeFromFiftydayMovingAverage
     */
    public void setPercentChangeFromFiftydayMovingAverage(String PercentChangeFromFiftydayMovingAverage) {
        this.PercentChangeFromFiftydayMovingAverage = PercentChangeFromFiftydayMovingAverage;
    }

    /**
     * @return The Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name The Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return The Notes
     */
    public Object getNotes() {
        return Notes;
    }

    /**
     * @param Notes The Notes
     */
    public void setNotes(Object Notes) {
        this.Notes = Notes;
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
     * @return The PreviousClose
     */
    public String getPreviousClose() {
        return PreviousClose;
    }

    /**
     * @param PreviousClose The PreviousClose
     */
    public void setPreviousClose(String PreviousClose) {
        this.PreviousClose = PreviousClose;
    }

    /**
     * @return The PricePaid
     */
    public Object getPricePaid() {
        return PricePaid;
    }

    /**
     * @param PricePaid The PricePaid
     */
    public void setPricePaid(Object PricePaid) {
        this.PricePaid = PricePaid;
    }

    /**
     * @return The ChangeinPercent
     */
    public String getChangeinPercent() {
        return ChangeinPercent;
    }

    /**
     * @param ChangeinPercent The ChangeinPercent
     */
    public void setChangeinPercent(String ChangeinPercent) {
        this.ChangeinPercent = ChangeinPercent;
    }

    /**
     * @return The PriceSales
     */
    public String getPriceSales() {
        return PriceSales;
    }

    /**
     * @param PriceSales The PriceSales
     */
    public void setPriceSales(String PriceSales) {
        this.PriceSales = PriceSales;
    }

    /**
     * @return The PriceBook
     */
    public String getPriceBook() {
        return PriceBook;
    }

    /**
     * @param PriceBook The PriceBook
     */
    public void setPriceBook(String PriceBook) {
        this.PriceBook = PriceBook;
    }

    /**
     * @return The ExDividendDate
     */
    public Object getExDividendDate() {
        return ExDividendDate;
    }

    /**
     * @param ExDividendDate The ExDividendDate
     */
    public void setExDividendDate(Object ExDividendDate) {
        this.ExDividendDate = ExDividendDate;
    }

    /**
     * @return The PERatio
     */
    public Object getPERatio() {
        return PERatio;
    }

    /**
     * @param PERatio The PERatio
     */
    public void setPERatio(Object PERatio) {
        this.PERatio = PERatio;
    }

    /**
     * @return The DividendPayDate
     */
    public Object getDividendPayDate() {
        return DividendPayDate;
    }

    /**
     * @param DividendPayDate The DividendPayDate
     */
    public void setDividendPayDate(Object DividendPayDate) {
        this.DividendPayDate = DividendPayDate;
    }

    /**
     * @return The PERatioRealtime
     */
    public Object getPERatioRealtime() {
        return PERatioRealtime;
    }

    /**
     * @param PERatioRealtime The PERatioRealtime
     */
    public void setPERatioRealtime(Object PERatioRealtime) {
        this.PERatioRealtime = PERatioRealtime;
    }

    /**
     * @return The PEGRatio
     */
    public String getPEGRatio() {
        return PEGRatio;
    }

    /**
     * @param PEGRatio The PEGRatio
     */
    public void setPEGRatio(String PEGRatio) {
        this.PEGRatio = PEGRatio;
    }

    /**
     * @return The PriceEPSEstimateCurrentYear
     */
    public String getPriceEPSEstimateCurrentYear() {
        return PriceEPSEstimateCurrentYear;
    }

    /**
     * @param PriceEPSEstimateCurrentYear The PriceEPSEstimateCurrentYear
     */
    public void setPriceEPSEstimateCurrentYear(String PriceEPSEstimateCurrentYear) {
        this.PriceEPSEstimateCurrentYear = PriceEPSEstimateCurrentYear;
    }

    /**
     * @return The PriceEPSEstimateNextYear
     */
    public String getPriceEPSEstimateNextYear() {
        return PriceEPSEstimateNextYear;
    }

    /**
     * @param PriceEPSEstimateNextYear The PriceEPSEstimateNextYear
     */
    public void setPriceEPSEstimateNextYear(String PriceEPSEstimateNextYear) {
        this.PriceEPSEstimateNextYear = PriceEPSEstimateNextYear;
    }

    /**
     * @return The SharesOwned
     */
    public Object getSharesOwned() {
        return SharesOwned;
    }

    /**
     * @param SharesOwned The SharesOwned
     */
    public void setSharesOwned(Object SharesOwned) {
        this.SharesOwned = SharesOwned;
    }

    /**
     * @return The ShortRatio
     */
    public String getShortRatio() {
        return ShortRatio;
    }

    /**
     * @param ShortRatio The ShortRatio
     */
    public void setShortRatio(String ShortRatio) {
        this.ShortRatio = ShortRatio;
    }

    /**
     * @return The LastTradeTime
     */
    public String getLastTradeTime() {
        return LastTradeTime;
    }

    /**
     * @param LastTradeTime The LastTradeTime
     */
    public void setLastTradeTime(String LastTradeTime) {
        this.LastTradeTime = LastTradeTime;
    }

    /**
     * @return The TickerTrend
     */
    public Object getTickerTrend() {
        return TickerTrend;
    }

    /**
     * @param TickerTrend The TickerTrend
     */
    public void setTickerTrend(Object TickerTrend) {
        this.TickerTrend = TickerTrend;
    }

    /**
     * @return The OneyrTargetPrice
     */
    public String getOneyrTargetPrice() {
        return OneyrTargetPrice;
    }

    /**
     * @param OneyrTargetPrice The OneyrTargetPrice
     */
    public void setOneyrTargetPrice(String OneyrTargetPrice) {
        this.OneyrTargetPrice = OneyrTargetPrice;
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
     * @return The HoldingsValue
     */
    public Object getHoldingsValue() {
        return HoldingsValue;
    }

    /**
     * @param HoldingsValue The HoldingsValue
     */
    public void setHoldingsValue(Object HoldingsValue) {
        this.HoldingsValue = HoldingsValue;
    }

    /**
     * @return The HoldingsValueRealtime
     */
    public Object getHoldingsValueRealtime() {
        return HoldingsValueRealtime;
    }

    /**
     * @param HoldingsValueRealtime The HoldingsValueRealtime
     */
    public void setHoldingsValueRealtime(Object HoldingsValueRealtime) {
        this.HoldingsValueRealtime = HoldingsValueRealtime;
    }

    /**
     * @return The YearRange
     */
    public String getYearRange() {
        return YearRange;
    }

    /**
     * @param YearRange The YearRange
     */
    public void setYearRange(String YearRange) {
        this.YearRange = YearRange;
    }

    /**
     * @return The DaysValueChange
     */
    public Object getDaysValueChange() {
        return DaysValueChange;
    }

    /**
     * @param DaysValueChange The DaysValueChange
     */
    public void setDaysValueChange(Object DaysValueChange) {
        this.DaysValueChange = DaysValueChange;
    }

    /**
     * @return The DaysValueChangeRealtime
     */
    public Object getDaysValueChangeRealtime() {
        return DaysValueChangeRealtime;
    }

    /**
     * @param DaysValueChangeRealtime The DaysValueChangeRealtime
     */
    public void setDaysValueChangeRealtime(Object DaysValueChangeRealtime) {
        this.DaysValueChangeRealtime = DaysValueChangeRealtime;
    }

    /**
     * @return The StockExchange
     */
    public String getStockExchange() {
        return StockExchange;
    }

    /**
     * @param StockExchange The StockExchange
     */
    public void setStockExchange(String StockExchange) {
        this.StockExchange = StockExchange;
    }

    /**
     * @return The DividendYield
     */
    public Object getDividendYield() {
        return DividendYield;
    }

    /**
     * @param DividendYield The DividendYield
     */
    public void setDividendYield(Object DividendYield) {
        this.DividendYield = DividendYield;
    }

    /**
     * @return The PercentChange
     */
    public String getPercentChange() {
        return PercentChange;
    }

    /**
     * @param PercentChange The PercentChange
     */
    public void setPercentChange(String PercentChange) {
        this.PercentChange = PercentChange;
    }

    protected Quote(Parcel in) {
        symbol = in.readString();
        Ask = in.readString();
        AverageDailyVolume = in.readString();
        Bid = in.readString();
        AskRealtime = (Object) in.readValue(Object.class.getClassLoader());
        BidRealtime = (Object) in.readValue(Object.class.getClassLoader());
        BookValue = in.readString();
        ChangePercentChange = in.readString();
        Change = in.readString();
        Commission = (Object) in.readValue(Object.class.getClassLoader());
        Currency = in.readString();
        ChangeRealtime = (Object) in.readValue(Object.class.getClassLoader());
        AfterHoursChangeRealtime = (Object) in.readValue(Object.class.getClassLoader());
        DividendShare = (Object) in.readValue(Object.class.getClassLoader());
        LastTradeDate = in.readString();
        TradeDate = (Object) in.readValue(Object.class.getClassLoader());
        EarningsShare = in.readString();
        ErrorIndicationreturnedforsymbolchangedinvalid = (Object) in.readValue(Object.class.getClassLoader());
        EPSEstimateCurrentYear = in.readString();
        EPSEstimateNextYear = in.readString();
        EPSEstimateNextQuarter = in.readString();
        DaysLow = in.readString();
        DaysHigh = in.readString();
        YearLow = in.readString();
        YearHigh = in.readString();
        HoldingsGainPercent = (Object) in.readValue(Object.class.getClassLoader());
        AnnualizedGain = (Object) in.readValue(Object.class.getClassLoader());
        HoldingsGain = (Object) in.readValue(Object.class.getClassLoader());
        HoldingsGainPercentRealtime = (Object) in.readValue(Object.class.getClassLoader());
        HoldingsGainRealtime = (Object) in.readValue(Object.class.getClassLoader());
        MoreInfo = (Object) in.readValue(Object.class.getClassLoader());
        OrderBookRealtime = (Object) in.readValue(Object.class.getClassLoader());
        MarketCapitalization = in.readString();
        MarketCapRealtime = (Object) in.readValue(Object.class.getClassLoader());
        EBITDA = in.readString();
        ChangeFromYearLow = in.readString();
        PercentChangeFromYearLow = in.readString();
        LastTradeRealtimeWithTime = (Object) in.readValue(Object.class.getClassLoader());
        ChangePercentRealtime = (Object) in.readValue(Object.class.getClassLoader());
        ChangeFromYearHigh = in.readString();
        PercebtChangeFromYearHigh = in.readString();
        LastTradeWithTime = in.readString();
        LastTradePriceOnly = in.readString();
        HighLimit = (Object) in.readValue(Object.class.getClassLoader());
        LowLimit = (Object) in.readValue(Object.class.getClassLoader());
        DaysRange = in.readString();
        DaysRangeRealtime = (Object) in.readValue(Object.class.getClassLoader());
        FiftydayMovingAverage = in.readString();
        TwoHundreddayMovingAverage = in.readString();
        ChangeFromTwoHundreddayMovingAverage = in.readString();
        PercentChangeFromTwoHundreddayMovingAverage = in.readString();
        ChangeFromFiftydayMovingAverage = in.readString();
        PercentChangeFromFiftydayMovingAverage = in.readString();
        Name = in.readString();
        Notes = (Object) in.readValue(Object.class.getClassLoader());
        Open = in.readString();
        PreviousClose = in.readString();
        PricePaid = (Object) in.readValue(Object.class.getClassLoader());
        ChangeinPercent = in.readString();
        PriceSales = in.readString();
        PriceBook = in.readString();
        ExDividendDate = (Object) in.readValue(Object.class.getClassLoader());
        PERatio = (Object) in.readValue(Object.class.getClassLoader());
        DividendPayDate = (Object) in.readValue(Object.class.getClassLoader());
        PERatioRealtime = (Object) in.readValue(Object.class.getClassLoader());
        PEGRatio = in.readString();
        PriceEPSEstimateCurrentYear = in.readString();
        PriceEPSEstimateNextYear = in.readString();
        SharesOwned = (Object) in.readValue(Object.class.getClassLoader());
        ShortRatio = in.readString();
        LastTradeTime = in.readString();
        TickerTrend = (Object) in.readValue(Object.class.getClassLoader());
        OneyrTargetPrice = in.readString();
        Volume = in.readString();
        HoldingsValue = (Object) in.readValue(Object.class.getClassLoader());
        HoldingsValueRealtime = (Object) in.readValue(Object.class.getClassLoader());
        YearRange = in.readString();
        DaysValueChange = (Object) in.readValue(Object.class.getClassLoader());
        DaysValueChangeRealtime = (Object) in.readValue(Object.class.getClassLoader());
        StockExchange = in.readString();
        DividendYield = (Object) in.readValue(Object.class.getClassLoader());
        PercentChange = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(symbol);
        dest.writeString(Ask);
        dest.writeString(AverageDailyVolume);
        dest.writeString(Bid);
        dest.writeValue(AskRealtime);
        dest.writeValue(BidRealtime);
        dest.writeString(BookValue);
        dest.writeString(ChangePercentChange);
        dest.writeString(Change);
        dest.writeValue(Commission);
        dest.writeString(Currency);
        dest.writeValue(ChangeRealtime);
        dest.writeValue(AfterHoursChangeRealtime);
        dest.writeValue(DividendShare);
        dest.writeString(LastTradeDate);
        dest.writeValue(TradeDate);
        dest.writeString(EarningsShare);
        dest.writeValue(ErrorIndicationreturnedforsymbolchangedinvalid);
        dest.writeString(EPSEstimateCurrentYear);
        dest.writeString(EPSEstimateNextYear);
        dest.writeString(EPSEstimateNextQuarter);
        dest.writeString(DaysLow);
        dest.writeString(DaysHigh);
        dest.writeString(YearLow);
        dest.writeString(YearHigh);
        dest.writeValue(HoldingsGainPercent);
        dest.writeValue(AnnualizedGain);
        dest.writeValue(HoldingsGain);
        dest.writeValue(HoldingsGainPercentRealtime);
        dest.writeValue(HoldingsGainRealtime);
        dest.writeValue(MoreInfo);
        dest.writeValue(OrderBookRealtime);
        dest.writeString(MarketCapitalization);
        dest.writeValue(MarketCapRealtime);
        dest.writeString(EBITDA);
        dest.writeString(ChangeFromYearLow);
        dest.writeString(PercentChangeFromYearLow);
        dest.writeValue(LastTradeRealtimeWithTime);
        dest.writeValue(ChangePercentRealtime);
        dest.writeString(ChangeFromYearHigh);
        dest.writeString(PercebtChangeFromYearHigh);
        dest.writeString(LastTradeWithTime);
        dest.writeString(LastTradePriceOnly);
        dest.writeValue(HighLimit);
        dest.writeValue(LowLimit);
        dest.writeString(DaysRange);
        dest.writeValue(DaysRangeRealtime);
        dest.writeString(FiftydayMovingAverage);
        dest.writeString(TwoHundreddayMovingAverage);
        dest.writeString(ChangeFromTwoHundreddayMovingAverage);
        dest.writeString(PercentChangeFromTwoHundreddayMovingAverage);
        dest.writeString(ChangeFromFiftydayMovingAverage);
        dest.writeString(PercentChangeFromFiftydayMovingAverage);
        dest.writeString(Name);
        dest.writeValue(Notes);
        dest.writeString(Open);
        dest.writeString(PreviousClose);
        dest.writeValue(PricePaid);
        dest.writeString(ChangeinPercent);
        dest.writeString(PriceSales);
        dest.writeString(PriceBook);
        dest.writeValue(ExDividendDate);
        dest.writeValue(PERatio);
        dest.writeValue(DividendPayDate);
        dest.writeValue(PERatioRealtime);
        dest.writeString(PEGRatio);
        dest.writeString(PriceEPSEstimateCurrentYear);
        dest.writeString(PriceEPSEstimateNextYear);
        dest.writeValue(SharesOwned);
        dest.writeString(ShortRatio);
        dest.writeString(LastTradeTime);
        dest.writeValue(TickerTrend);
        dest.writeString(OneyrTargetPrice);
        dest.writeString(Volume);
        dest.writeValue(HoldingsValue);
        dest.writeValue(HoldingsValueRealtime);
        dest.writeString(YearRange);
        dest.writeValue(DaysValueChange);
        dest.writeValue(DaysValueChangeRealtime);
        dest.writeString(StockExchange);
        dest.writeValue(DividendYield);
        dest.writeString(PercentChange);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Quote> CREATOR = new Parcelable.Creator<Quote>() {
        @Override
        public Quote createFromParcel(Parcel in) {
            return new Quote(in);
        }

        @Override
        public Quote[] newArray(int size) {
            return new Quote[size];
        }
    };
}
