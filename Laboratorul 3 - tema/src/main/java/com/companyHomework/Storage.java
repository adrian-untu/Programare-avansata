package com.companyHomework;

/**
 * Storage computer
 */
public interface Storage {
    int getData();

    default int convert(Units units) {
        if (units == Units.BYTE)
            return getData() * 1000000000;

        if (units == Units.KILOBYTE)
            return getData() * 1000000;

        if (units == Units.MEGABYTE)
            return getData() * 1000;

        return getData();
    }
}