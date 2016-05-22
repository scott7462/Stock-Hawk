package com.sam_chordas.android.stockhawk.app.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
public class DateTimeUtils {

    public static String convertToPatternFromPattern(String fromPattern, String date, String toPattern) {
        return getStringPatternFromDateTime(toPattern, getDateTimeFromPattern(fromPattern, date));
    }

    private static DateTime getDateTimeFromPattern(String inputPattern, String date) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(inputPattern);
        return formatter.parseDateTime(date);
    }

    public static String getStringPatternFromDateTime(String pattern, DateTime date) {
        DateTimeFormatter presenter = DateTimeFormat.forPattern(pattern);
        return presenter.print(date);
    }

}
