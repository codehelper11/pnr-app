package com.droid.app.entity;

import java.util.List;

/**
 * Created by vinay on 19/8/16.
 */
public class PnrStatus {

    private String pnrNumber;
    private List<SeatStatus> seatStatuses;
    private TrainDetails trainDetails;


    public PnrStatus(String pnrNumber, List<SeatStatus> seatStatuses, TrainDetails trainDetails) {
        this.pnrNumber = pnrNumber;
        this.seatStatuses = seatStatuses;
        this.trainDetails = trainDetails;
    }

    public String getPnrNumber() {
        return pnrNumber;
    }

    public List<SeatStatus> getSeatStatuses() {
        return seatStatuses;
    }

    public TrainDetails getTrainDetails() {
        return trainDetails;
    }

    @Override
    public String toString() {
        return "PnrStatus{" +
                "pnrNumber='" + pnrNumber + '\'' +
                ", seatStatuses=" + seatStatuses +
                ", trainDetails=" + trainDetails +
                '}';
    }
}
