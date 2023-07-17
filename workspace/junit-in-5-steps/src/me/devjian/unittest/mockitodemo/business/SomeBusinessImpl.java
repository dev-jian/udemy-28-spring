package me.devjian.unittest.mockitodemo.business;

public class SomeBusinessImpl {

    private DataService dataService;

    public SomeBusinessImpl() {
    }

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData() {
        int[] datas = dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;
        for (int i = 0; i < datas.length; i++) {
            if (datas[i] > greatestValue)
                greatestValue = datas[i];
        }
        return greatestValue;
    }
}

interface DataService {
    int[] retrieveAllData();
}