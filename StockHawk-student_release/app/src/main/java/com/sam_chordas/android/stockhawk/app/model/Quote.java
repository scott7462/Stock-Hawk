package com.sam_chordas.android.stockhawk.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by scott7462 on 3/28/16.
 */
@DatabaseTable
public class Quote implements Parcelable {

    private static final String FIELD_ID = "_id";
    public static final String SYMBOL = "symbol";
    @DatabaseField(generatedId = true, columnName = FIELD_ID)
    private int id;
    @DatabaseField
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @DatabaseField
    @SerializedName("Ask")
    @Expose
    private String ask;
    @DatabaseField
    @SerializedName("AverageDailyVolume")
    @Expose
    private String averageDailyVolume;
    @DatabaseField
    @SerializedName("Bid")
    @Expose
    private String bid;
    @DatabaseField
    @SerializedName("AskRealtime")
    @Expose
    private String askRealtime;
    @DatabaseField
    @SerializedName("BidRealtime")
    @Expose
    private String bidRealtime;
    @DatabaseField
    @SerializedName("BookValue")
    @Expose
    private String bookValue;
    @DatabaseField
    @SerializedName("Change_PercentChange")
    @Expose
    private String changePercentChange;
    @DatabaseField
    @SerializedName("Change")
    @Expose
    private String change;
    @DatabaseField
    @SerializedName("Commission")
    @Expose
    private String commission;
    @DatabaseField
    @SerializedName("Currency")
    @Expose
    private String currency;
    @DatabaseField
    @SerializedName("ChangeRealtime")
    @Expose
    private String changeRealtime;
    @DatabaseField
    @SerializedName("AfterHoursChangeRealtime")
    @Expose
    private String afterHoursChangeRealtime;
    @DatabaseField
    @SerializedName("DividendShare")
    @Expose
    private String dividendShare;
    @DatabaseField
    @SerializedName("LastTradeDate")
    @Expose
    private String lastTradeDate;
    @DatabaseField
    @SerializedName("TradeDate")
    @Expose
    private String tradeDate;
    @DatabaseField
    @SerializedName("EarningsShare")
    @Expose
    private String earningsShare;
    @DatabaseField
    @SerializedName("ErrorIndicationreturnedforsymbolchangedinvalid")
    @Expose
    private String errorIndicationreturnedforsymbolchangedinvalid;
    @DatabaseField
    @SerializedName("EPSEstimateCurrentYear")
    @Expose
    private String EPSEstimateCurrentYear;
    @DatabaseField
    @SerializedName("EPSEstimateNextYear")
    @Expose
    private String EPSEstimateNextYear;
    @DatabaseField
    @SerializedName("EPSEstimateNextQuarter")
    @Expose
    private String EPSEstimateNextQuarter;
    @DatabaseField
    @SerializedName("DaysLow")
    @Expose
    private String daysLow;
    @DatabaseField
    @SerializedName("DaysHigh")
    @Expose
    private String daysHigh;
    @DatabaseField
    @SerializedName("YearLow")
    @Expose
    private String yearLow;
    @DatabaseField
    @SerializedName("YearHigh")
    @Expose
    private String yearHigh;
    @DatabaseField
    @SerializedName("HoldingsGainPercent")
    @Expose
    private String holdingsGainPercent;
    @DatabaseField
    @SerializedName("AnnualizedGain")
    @Expose
    private String annualizedGain;
    @DatabaseField
    @SerializedName("HoldingsGain")
    @Expose
    private String holdingsGain;
    @DatabaseField
    @SerializedName("HoldingsGainPercentRealtime")
    @Expose
    private String holdingsGainPercentRealtime;
    @DatabaseField
    @SerializedName("HoldingsGainRealtime")
    @Expose
    private String holdingsGainRealtime;
    @DatabaseField
    @SerializedName("MoreInfo")
    @Expose
    private String moreInfo;
    @DatabaseField
    @SerializedName("OrderBookRealtime")
    @Expose
    private String orderBookRealtime;
    @DatabaseField
    @SerializedName("MarketCapitalization")
    @Expose
    private String marketCapitalization;
    @DatabaseField
    @SerializedName("MarketCapRealtime")
    @Expose
    private String marketCapRealtime;
    @DatabaseField
    @SerializedName("EBITDA")
    @Expose
    private String EBITDA;
    @DatabaseField
    @SerializedName("ChangeFromYearLow")
    @Expose
    private String changeFromYearLow;
    @DatabaseField
    @SerializedName("PercentChangeFromYearLow")
    @Expose
    private String percentChangeFromYearLow;
    @DatabaseField
    @SerializedName("LastTradeRealtimeWithTime")
    @Expose
    private String lastTradeRealtimeWithTime;
    @DatabaseField
    @SerializedName("ChangePercentRealtime")
    @Expose
    private String changePercentRealtime;
    @DatabaseField
    @SerializedName("ChangeFromYearHigh")
    @Expose
    private String changeFromYearHigh;
    @DatabaseField
    @SerializedName("PercebtChangeFromYearHigh")
    @Expose
    private String percebtChangeFromYearHigh;
    @DatabaseField
    @SerializedName("LastTradeWithTime")
    @Expose
    private String lastTradeWithTime;
    @DatabaseField
    @SerializedName("LastTradePriceOnly")
    @Expose
    private String lastTradePriceOnly;
    @DatabaseField
    @SerializedName("HighLimit")
    @Expose
    private String highLimit;
    @DatabaseField
    @SerializedName("LowLimit")
    @Expose
    private String lowLimit;
    @DatabaseField
    @SerializedName("DaysRange")
    @Expose
    private String daysRange;
    @DatabaseField
    @SerializedName("DaysRangeRealtime")
    @Expose
    private String daysRangeRealtime;
    @DatabaseField
    @SerializedName("FiftydayMovingAverage")
    @Expose
    private String fiftydayMovingAverage;
    @DatabaseField
    @SerializedName("TwoHundreddayMovingAverage")
    @Expose
    private String twoHundreddayMovingAverage;
    @DatabaseField
    @SerializedName("ChangeFromTwoHundreddayMovingAverage")
    @Expose
    private String changeFromTwoHundreddayMovingAverage;
    @DatabaseField
    @SerializedName("PercentChangeFromTwoHundreddayMovingAverage")
    @Expose
    private String percentChangeFromTwoHundreddayMovingAverage;
    @DatabaseField
    @SerializedName("ChangeFromFiftydayMovingAverage")
    @Expose
    private String changeFromFiftydayMovingAverage;
    @DatabaseField
    @SerializedName("PercentChangeFromFiftydayMovingAverage")
    @Expose
    private String percentChangeFromFiftydayMovingAverage;
    @DatabaseField
    @SerializedName("Name")
    @Expose
    private String name;
    @DatabaseField
    @SerializedName("Notes")
    @Expose
    private String notes;
    @DatabaseField
    @SerializedName("Open")
    @Expose
    private String open;
    @DatabaseField
    @SerializedName("PreviousClose")
    @Expose
    private String previousClose;
    @DatabaseField
    @SerializedName("PricePaid")
    @Expose
    private String pricePaid;
    @DatabaseField
    @SerializedName("ChangeinPercent")
    @Expose
    private String changeinPercent;
    @DatabaseField
    @SerializedName("PriceSales")
    @Expose
    private String priceSales;
    @DatabaseField
    @SerializedName("PriceBook")
    @Expose
    private String priceBook;
    @DatabaseField
    @SerializedName("ExDividendDate")
    @Expose
    private String exDividendDate;
    @SerializedName("PERatio")
    @Expose
    private String pERatio;
    @DatabaseField
    @SerializedName("DividendPayDate")
    @Expose
    private String dividendPayDate;
    @DatabaseField
    @SerializedName("PERatioRealtime")
    @Expose
    private String pERatioRealtime;
    @DatabaseField
    @SerializedName("PEGRatio")
    @Expose
    private String pEGRatio;
    @DatabaseField
    @SerializedName("PriceEPSEstimateCurrentYear")
    @Expose
    private String priceEPSEstimateCurrentYear;
    @DatabaseField
    @SerializedName("PriceEPSEstimateNextYear")
    @Expose
    private String priceEPSEstimateNextYear;
    @DatabaseField
    @SerializedName("SharesOwned")
    @Expose
    private String sharesOwned;
    @DatabaseField
    @SerializedName("ShortRatio")
    @Expose
    private String shortRatio;
    @DatabaseField
    @SerializedName("LastTradeTime")
    @Expose
    private String lastTradeTime;
    @DatabaseField
    @SerializedName("TickerTrend")
    @Expose
    private String tickerTrend;
    @DatabaseField
    @SerializedName("OneyrTargetPrice")
    @Expose
    private String oneyrTargetPrice;
    @DatabaseField
    @SerializedName("Volume")
    @Expose
    private String volume;
    @DatabaseField
    @SerializedName("HoldingsValue")
    @Expose
    private String holdingsValue;
    @DatabaseField
    @SerializedName("HoldingsValueRealtime")
    @Expose
    private String holdingsValueRealtime;
    @DatabaseField
    @SerializedName("YearRange")
    @Expose
    private String yearRange;
    @DatabaseField
    @SerializedName("DaysValueChange")
    @Expose
    private String daysValueChange;
    @DatabaseField
    @SerializedName("DaysValueChangeRealtime")
    @Expose
    private String daysValueChangeRealtime;
    @DatabaseField
    @SerializedName("StockExchange")
    @Expose
    private String stockExchange;
    @DatabaseField
    @SerializedName("DividendYield")
    @Expose
    private String dividendYield;
    @DatabaseField
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

    /**
     * @return The ask
     */
    public String getAsk() {
        return ask;
    }

    /**
     * @param Ask The ask
     */
    public void setAsk(String Ask) {
        this.ask = Ask;
    }

    public String getAverageDailyVolume() {
        return averageDailyVolume;
    }

    public void setAverageDailyVolume(String averageDailyVolume) {
        this.averageDailyVolume = averageDailyVolume;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAskRealtime() {
        return askRealtime;
    }

    public void setAskRealtime(String askRealtime) {
        this.askRealtime = askRealtime;
    }

    public String getBidRealtime() {
        return bidRealtime;
    }

    public void setBidRealtime(String bidRealtime) {
        this.bidRealtime = bidRealtime;
    }

    public String getBookValue() {
        return bookValue;
    }

    public void setBookValue(String bookValue) {
        this.bookValue = bookValue;
    }

    public String getChangePercentChange() {
        return changePercentChange;
    }

    public void setChangePercentChange(String changePercentChange) {
        this.changePercentChange = changePercentChange;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getChangeRealtime() {
        return changeRealtime;
    }

    public void setChangeRealtime(String changeRealtime) {
        this.changeRealtime = changeRealtime;
    }

    public String getAfterHoursChangeRealtime() {
        return afterHoursChangeRealtime;
    }

    public void setAfterHoursChangeRealtime(String afterHoursChangeRealtime) {
        this.afterHoursChangeRealtime = afterHoursChangeRealtime;
    }

    public String getDividendShare() {
        return dividendShare;
    }

    public void setDividendShare(String dividendShare) {
        this.dividendShare = dividendShare;
    }

    public String getLastTradeDate() {
        return lastTradeDate;
    }

    public void setLastTradeDate(String lastTradeDate) {
        this.lastTradeDate = lastTradeDate;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getEarningsShare() {
        return earningsShare;
    }

    public void setEarningsShare(String earningsShare) {
        this.earningsShare = earningsShare;
    }

    public String getErrorIndicationreturnedforsymbolchangedinvalid() {
        return errorIndicationreturnedforsymbolchangedinvalid;
    }

    public void setErrorIndicationreturnedforsymbolchangedinvalid(String errorIndicationreturnedforsymbolchangedinvalid) {
        this.errorIndicationreturnedforsymbolchangedinvalid = errorIndicationreturnedforsymbolchangedinvalid;
    }

    public String getEPSEstimateCurrentYear() {
        return EPSEstimateCurrentYear;
    }

    public void setEPSEstimateCurrentYear(String EPSEstimateCurrentYear) {
        this.EPSEstimateCurrentYear = EPSEstimateCurrentYear;
    }

    public String getEPSEstimateNextYear() {
        return EPSEstimateNextYear;
    }

    public void setEPSEstimateNextYear(String EPSEstimateNextYear) {
        this.EPSEstimateNextYear = EPSEstimateNextYear;
    }

    public String getEPSEstimateNextQuarter() {
        return EPSEstimateNextQuarter;
    }

    public void setEPSEstimateNextQuarter(String EPSEstimateNextQuarter) {
        this.EPSEstimateNextQuarter = EPSEstimateNextQuarter;
    }

    public String getDaysLow() {
        return daysLow;
    }

    public void setDaysLow(String daysLow) {
        this.daysLow = daysLow;
    }

    public String getDaysHigh() {
        return daysHigh;
    }

    public void setDaysHigh(String daysHigh) {
        this.daysHigh = daysHigh;
    }

    public String getYearLow() {
        return yearLow;
    }

    public void setYearLow(String yearLow) {
        this.yearLow = yearLow;
    }

    public String getYearHigh() {
        return yearHigh;
    }

    public void setYearHigh(String yearHigh) {
        this.yearHigh = yearHigh;
    }

    public String getHoldingsGainPercent() {
        return holdingsGainPercent;
    }

    public void setHoldingsGainPercent(String holdingsGainPercent) {
        this.holdingsGainPercent = holdingsGainPercent;
    }

    public String getAnnualizedGain() {
        return annualizedGain;
    }

    public void setAnnualizedGain(String annualizedGain) {
        this.annualizedGain = annualizedGain;
    }

    public String getHoldingsGain() {
        return holdingsGain;
    }

    public void setHoldingsGain(String holdingsGain) {
        this.holdingsGain = holdingsGain;
    }

    public String getHoldingsGainPercentRealtime() {
        return holdingsGainPercentRealtime;
    }

    public void setHoldingsGainPercentRealtime(String holdingsGainPercentRealtime) {
        this.holdingsGainPercentRealtime = holdingsGainPercentRealtime;
    }

    public String getHoldingsGainRealtime() {
        return holdingsGainRealtime;
    }

    public void setHoldingsGainRealtime(String holdingsGainRealtime) {
        this.holdingsGainRealtime = holdingsGainRealtime;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getOrderBookRealtime() {
        return orderBookRealtime;
    }

    public void setOrderBookRealtime(String orderBookRealtime) {
        this.orderBookRealtime = orderBookRealtime;
    }

    public String getMarketCapitalization() {
        return marketCapitalization;
    }

    public void setMarketCapitalization(String marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
    }

    public String getMarketCapRealtime() {
        return marketCapRealtime;
    }

    public void setMarketCapRealtime(String marketCapRealtime) {
        this.marketCapRealtime = marketCapRealtime;
    }

    public String getEBITDA() {
        return EBITDA;
    }

    public void setEBITDA(String EBITDA) {
        this.EBITDA = EBITDA;
    }

    public String getChangeFromYearLow() {
        return changeFromYearLow;
    }

    public void setChangeFromYearLow(String changeFromYearLow) {
        this.changeFromYearLow = changeFromYearLow;
    }

    public String getPercentChangeFromYearLow() {
        return percentChangeFromYearLow;
    }

    public void setPercentChangeFromYearLow(String percentChangeFromYearLow) {
        this.percentChangeFromYearLow = percentChangeFromYearLow;
    }

    public String getLastTradeRealtimeWithTime() {
        return lastTradeRealtimeWithTime;
    }

    public void setLastTradeRealtimeWithTime(String lastTradeRealtimeWithTime) {
        this.lastTradeRealtimeWithTime = lastTradeRealtimeWithTime;
    }

    public String getChangePercentRealtime() {
        return changePercentRealtime;
    }

    public void setChangePercentRealtime(String changePercentRealtime) {
        this.changePercentRealtime = changePercentRealtime;
    }

    public String getChangeFromYearHigh() {
        return changeFromYearHigh;
    }

    public void setChangeFromYearHigh(String changeFromYearHigh) {
        this.changeFromYearHigh = changeFromYearHigh;
    }

    public String getPercebtChangeFromYearHigh() {
        return percebtChangeFromYearHigh;
    }

    public void setPercebtChangeFromYearHigh(String percebtChangeFromYearHigh) {
        this.percebtChangeFromYearHigh = percebtChangeFromYearHigh;
    }

    public String getLastTradeWithTime() {
        return lastTradeWithTime;
    }

    public void setLastTradeWithTime(String lastTradeWithTime) {
        this.lastTradeWithTime = lastTradeWithTime;
    }

    public String getLastTradePriceOnly() {
        return lastTradePriceOnly;
    }

    public void setLastTradePriceOnly(String lastTradePriceOnly) {
        this.lastTradePriceOnly = lastTradePriceOnly;
    }

    public String getHighLimit() {
        return highLimit;
    }

    public void setHighLimit(String highLimit) {
        this.highLimit = highLimit;
    }

    public String getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(String lowLimit) {
        this.lowLimit = lowLimit;
    }

    public String getDaysRange() {
        return daysRange;
    }

    public void setDaysRange(String daysRange) {
        this.daysRange = daysRange;
    }

    public String getDaysRangeRealtime() {
        return daysRangeRealtime;
    }

    public void setDaysRangeRealtime(String daysRangeRealtime) {
        this.daysRangeRealtime = daysRangeRealtime;
    }

    public String getFiftydayMovingAverage() {
        return fiftydayMovingAverage;
    }

    public void setFiftydayMovingAverage(String fiftydayMovingAverage) {
        this.fiftydayMovingAverage = fiftydayMovingAverage;
    }

    public String getTwoHundreddayMovingAverage() {
        return twoHundreddayMovingAverage;
    }

    public void setTwoHundreddayMovingAverage(String twoHundreddayMovingAverage) {
        this.twoHundreddayMovingAverage = twoHundreddayMovingAverage;
    }

    public String getChangeFromTwoHundreddayMovingAverage() {
        return changeFromTwoHundreddayMovingAverage;
    }

    public void setChangeFromTwoHundreddayMovingAverage(String changeFromTwoHundreddayMovingAverage) {
        this.changeFromTwoHundreddayMovingAverage = changeFromTwoHundreddayMovingAverage;
    }

    public String getPercentChangeFromTwoHundreddayMovingAverage() {
        return percentChangeFromTwoHundreddayMovingAverage;
    }

    public void setPercentChangeFromTwoHundreddayMovingAverage(String percentChangeFromTwoHundreddayMovingAverage) {
        this.percentChangeFromTwoHundreddayMovingAverage = percentChangeFromTwoHundreddayMovingAverage;
    }

    public String getChangeFromFiftydayMovingAverage() {
        return changeFromFiftydayMovingAverage;
    }

    public void setChangeFromFiftydayMovingAverage(String changeFromFiftydayMovingAverage) {
        this.changeFromFiftydayMovingAverage = changeFromFiftydayMovingAverage;
    }

    public String getPercentChangeFromFiftydayMovingAverage() {
        return percentChangeFromFiftydayMovingAverage;
    }

    public void setPercentChangeFromFiftydayMovingAverage(String percentChangeFromFiftydayMovingAverage) {
        this.percentChangeFromFiftydayMovingAverage = percentChangeFromFiftydayMovingAverage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(String previousClose) {
        this.previousClose = previousClose;
    }

    public String getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(String pricePaid) {
        this.pricePaid = pricePaid;
    }

    public String getChangeinPercent() {
        return changeinPercent;
    }

    public void setChangeinPercent(String changeinPercent) {
        this.changeinPercent = changeinPercent;
    }

    public String getPriceSales() {
        return priceSales;
    }

    public void setPriceSales(String priceSales) {
        this.priceSales = priceSales;
    }

    public String getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(String priceBook) {
        this.priceBook = priceBook;
    }

    public String getExDividendDate() {
        return exDividendDate;
    }

    public void setExDividendDate(String exDividendDate) {
        this.exDividendDate = exDividendDate;
    }

    public String getpERatio() {
        return pERatio;
    }

    public void setpERatio(String pERatio) {
        this.pERatio = pERatio;
    }

    public String getDividendPayDate() {
        return dividendPayDate;
    }

    public void setDividendPayDate(String dividendPayDate) {
        this.dividendPayDate = dividendPayDate;
    }

    public String getpERatioRealtime() {
        return pERatioRealtime;
    }

    public void setpERatioRealtime(String pERatioRealtime) {
        this.pERatioRealtime = pERatioRealtime;
    }

    public String getpEGRatio() {
        return pEGRatio;
    }

    public void setpEGRatio(String pEGRatio) {
        this.pEGRatio = pEGRatio;
    }

    public String getPriceEPSEstimateCurrentYear() {
        return priceEPSEstimateCurrentYear;
    }

    public void setPriceEPSEstimateCurrentYear(String priceEPSEstimateCurrentYear) {
        this.priceEPSEstimateCurrentYear = priceEPSEstimateCurrentYear;
    }

    public String getPriceEPSEstimateNextYear() {
        return priceEPSEstimateNextYear;
    }

    public void setPriceEPSEstimateNextYear(String priceEPSEstimateNextYear) {
        this.priceEPSEstimateNextYear = priceEPSEstimateNextYear;
    }

    public String getSharesOwned() {
        return sharesOwned;
    }

    public void setSharesOwned(String sharesOwned) {
        this.sharesOwned = sharesOwned;
    }

    public String getShortRatio() {
        return shortRatio;
    }

    public void setShortRatio(String shortRatio) {
        this.shortRatio = shortRatio;
    }

    public String getLastTradeTime() {
        return lastTradeTime;
    }

    public void setLastTradeTime(String lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
    }

    public String getTickerTrend() {
        return tickerTrend;
    }

    public void setTickerTrend(String tickerTrend) {
        this.tickerTrend = tickerTrend;
    }

    public String getOneyrTargetPrice() {
        return oneyrTargetPrice;
    }

    public void setOneyrTargetPrice(String oneyrTargetPrice) {
        this.oneyrTargetPrice = oneyrTargetPrice;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getHoldingsValue() {
        return holdingsValue;
    }

    public void setHoldingsValue(String holdingsValue) {
        this.holdingsValue = holdingsValue;
    }

    public String getHoldingsValueRealtime() {
        return holdingsValueRealtime;
    }

    public void setHoldingsValueRealtime(String holdingsValueRealtime) {
        this.holdingsValueRealtime = holdingsValueRealtime;
    }

    public String getYearRange() {
        return yearRange;
    }

    public void setYearRange(String yearRange) {
        this.yearRange = yearRange;
    }

    public String getDaysValueChange() {
        return daysValueChange;
    }

    public void setDaysValueChange(String daysValueChange) {
        this.daysValueChange = daysValueChange;
    }

    public String getDaysValueChangeRealtime() {
        return daysValueChangeRealtime;
    }

    public void setDaysValueChangeRealtime(String daysValueChangeRealtime) {
        this.daysValueChangeRealtime = daysValueChangeRealtime;
    }

    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    public String getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(String dividendYield) {
        this.dividendYield = dividendYield;
    }

    public String getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.symbol);
        dest.writeString(this.ask);
        dest.writeString(this.averageDailyVolume);
        dest.writeString(this.bid);
        dest.writeString(this.askRealtime);
        dest.writeString(this.bidRealtime);
        dest.writeString(this.bookValue);
        dest.writeString(this.changePercentChange);
        dest.writeString(this.change);
        dest.writeString(this.commission);
        dest.writeString(this.currency);
        dest.writeString(this.changeRealtime);
        dest.writeString(this.afterHoursChangeRealtime);
        dest.writeString(this.dividendShare);
        dest.writeString(this.lastTradeDate);
        dest.writeString(this.tradeDate);
        dest.writeString(this.earningsShare);
        dest.writeString(this.errorIndicationreturnedforsymbolchangedinvalid);
        dest.writeString(this.EPSEstimateCurrentYear);
        dest.writeString(this.EPSEstimateNextYear);
        dest.writeString(this.EPSEstimateNextQuarter);
        dest.writeString(this.daysLow);
        dest.writeString(this.daysHigh);
        dest.writeString(this.yearLow);
        dest.writeString(this.yearHigh);
        dest.writeString(this.holdingsGainPercent);
        dest.writeString(this.annualizedGain);
        dest.writeString(this.holdingsGain);
        dest.writeString(this.holdingsGainPercentRealtime);
        dest.writeString(this.holdingsGainRealtime);
        dest.writeString(this.moreInfo);
        dest.writeString(this.orderBookRealtime);
        dest.writeString(this.marketCapitalization);
        dest.writeString(this.marketCapRealtime);
        dest.writeString(this.EBITDA);
        dest.writeString(this.changeFromYearLow);
        dest.writeString(this.percentChangeFromYearLow);
        dest.writeString(this.lastTradeRealtimeWithTime);
        dest.writeString(this.changePercentRealtime);
        dest.writeString(this.changeFromYearHigh);
        dest.writeString(this.percebtChangeFromYearHigh);
        dest.writeString(this.lastTradeWithTime);
        dest.writeString(this.lastTradePriceOnly);
        dest.writeString(this.highLimit);
        dest.writeString(this.lowLimit);
        dest.writeString(this.daysRange);
        dest.writeString(this.daysRangeRealtime);
        dest.writeString(this.fiftydayMovingAverage);
        dest.writeString(this.twoHundreddayMovingAverage);
        dest.writeString(this.changeFromTwoHundreddayMovingAverage);
        dest.writeString(this.percentChangeFromTwoHundreddayMovingAverage);
        dest.writeString(this.changeFromFiftydayMovingAverage);
        dest.writeString(this.percentChangeFromFiftydayMovingAverage);
        dest.writeString(this.name);
        dest.writeString(this.notes);
        dest.writeString(this.open);
        dest.writeString(this.previousClose);
        dest.writeString(this.pricePaid);
        dest.writeString(this.changeinPercent);
        dest.writeString(this.priceSales);
        dest.writeString(this.priceBook);
        dest.writeString(this.exDividendDate);
        dest.writeString(this.pERatio);
        dest.writeString(this.dividendPayDate);
        dest.writeString(this.pERatioRealtime);
        dest.writeString(this.pEGRatio);
        dest.writeString(this.priceEPSEstimateCurrentYear);
        dest.writeString(this.priceEPSEstimateNextYear);
        dest.writeString(this.sharesOwned);
        dest.writeString(this.shortRatio);
        dest.writeString(this.lastTradeTime);
        dest.writeString(this.tickerTrend);
        dest.writeString(this.oneyrTargetPrice);
        dest.writeString(this.volume);
        dest.writeString(this.holdingsValue);
        dest.writeString(this.holdingsValueRealtime);
        dest.writeString(this.yearRange);
        dest.writeString(this.daysValueChange);
        dest.writeString(this.daysValueChangeRealtime);
        dest.writeString(this.stockExchange);
        dest.writeString(this.dividendYield);
        dest.writeString(this.percentChange);
    }

    public Quote() {
    }

    protected Quote(Parcel in) {
        this.id = in.readInt();
        this.symbol = in.readString();
        this.ask = in.readString();
        this.averageDailyVolume = in.readString();
        this.bid = in.readString();
        this.askRealtime = in.readString();
        this.bidRealtime = in.readString();
        this.bookValue = in.readString();
        this.changePercentChange = in.readString();
        this.change = in.readString();
        this.commission = in.readString();
        this.currency = in.readString();
        this.changeRealtime = in.readString();
        this.afterHoursChangeRealtime = in.readString();
        this.dividendShare = in.readString();
        this.lastTradeDate = in.readString();
        this.tradeDate = in.readString();
        this.earningsShare = in.readString();
        this.errorIndicationreturnedforsymbolchangedinvalid = in.readString();
        this.EPSEstimateCurrentYear = in.readString();
        this.EPSEstimateNextYear = in.readString();
        this.EPSEstimateNextQuarter = in.readString();
        this.daysLow = in.readString();
        this.daysHigh = in.readString();
        this.yearLow = in.readString();
        this.yearHigh = in.readString();
        this.holdingsGainPercent = in.readString();
        this.annualizedGain = in.readString();
        this.holdingsGain = in.readString();
        this.holdingsGainPercentRealtime = in.readString();
        this.holdingsGainRealtime = in.readString();
        this.moreInfo = in.readString();
        this.orderBookRealtime = in.readString();
        this.marketCapitalization = in.readString();
        this.marketCapRealtime = in.readString();
        this.EBITDA = in.readString();
        this.changeFromYearLow = in.readString();
        this.percentChangeFromYearLow = in.readString();
        this.lastTradeRealtimeWithTime = in.readString();
        this.changePercentRealtime = in.readString();
        this.changeFromYearHigh = in.readString();
        this.percebtChangeFromYearHigh = in.readString();
        this.lastTradeWithTime = in.readString();
        this.lastTradePriceOnly = in.readString();
        this.highLimit = in.readString();
        this.lowLimit = in.readString();
        this.daysRange = in.readString();
        this.daysRangeRealtime = in.readString();
        this.fiftydayMovingAverage = in.readString();
        this.twoHundreddayMovingAverage = in.readString();
        this.changeFromTwoHundreddayMovingAverage = in.readString();
        this.percentChangeFromTwoHundreddayMovingAverage = in.readString();
        this.changeFromFiftydayMovingAverage = in.readString();
        this.percentChangeFromFiftydayMovingAverage = in.readString();
        this.name = in.readString();
        this.notes = in.readString();
        this.open = in.readString();
        this.previousClose = in.readString();
        this.pricePaid = in.readParcelable(Object.class.getClassLoader());
        this.changeinPercent = in.readString();
        this.priceSales = in.readString();
        this.priceBook = in.readString();
        this.exDividendDate = in.readString();
        this.pERatio = in.readString();
        this.dividendPayDate = in.readString();
        this.pERatioRealtime = in.readString();
        this.pEGRatio = in.readString();
        this.priceEPSEstimateCurrentYear = in.readString();
        this.priceEPSEstimateNextYear = in.readString();
        this.sharesOwned = in.readString();
        this.shortRatio = in.readString();
        this.lastTradeTime = in.readString();
        this.tickerTrend = in.readString();
        this.oneyrTargetPrice = in.readString();
        this.volume = in.readString();
        this.holdingsValue = in.readString();
        this.holdingsValueRealtime = in.readString();
        this.yearRange = in.readString();
        this.daysValueChange = in.readString();
        this.daysValueChangeRealtime = in.readString();
        this.stockExchange = in.readString();
        this.dividendYield = in.readString();
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
