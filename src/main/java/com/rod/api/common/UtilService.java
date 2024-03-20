package com.rod.api.common;

public interface UtilService {
    int createRandomInteger(int start,int end);
    double createRandomDouble(int start,int end);

    String createRandomName();
    String createRandomTitle();
    String createRandomContent();
    String createRandomCompany();
    String createRandomUsername();
    String createRandomJob();
}
