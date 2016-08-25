package com.droid.app.entity;

/**
 * Created by vinay on 19/8/16.
 */
public class TrainDetails {

    private String number;
    private String name;
    private String boardingDate;
    private String fromStation;
    private String toStation;
    private String reservedUpto;
    private String boardingStation;
    private String seatType;

    private TrainDetails(String number, String name, String boardingDate, String fromStation, String toStation, String reservedUpto, String boardingStation, String seatType) {
        this.number = number;
        this.name = name;
        this.boardingDate = boardingDate;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.reservedUpto = reservedUpto;
        this.boardingStation = boardingStation;
        this.seatType = seatType;
    }

    class TrainDetailsBuilder {
        private String number;
        private String name;
        private String boardingDate;
        private String fromStation;
        private String toStation;
        private String reservedUpto;
        private String boardingStation;
        private String seatType;

        public TrainDetailsBuilder number(String number) {
            this.number = number;
            return this;
        }

        public TrainDetailsBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TrainDetailsBuilder boardingDate(String boardingDate) {
            this.boardingDate = boardingDate;
            return this;
        }

        public TrainDetailsBuilder fromStation(String fromStation) {
            this.fromStation = fromStation;
            return this;
        }

        public TrainDetailsBuilder toStation(String toStation) {
            this.toStation = toStation;
            return this;
        }
        public TrainDetailsBuilder reservedUpto(String reservedUpto) {
            this.reservedUpto = reservedUpto;
            return this;
        }

        public TrainDetailsBuilder boardingStation(String boardingStation) {
            this.boardingStation = boardingStation;
            return this;
        }

        public TrainDetailsBuilder seatType(String seatType) {
            this.seatType = seatType;
            return this;
        }

        public TrainDetails getTrainDetails(){
            return new TrainDetails(number,name,boardingDate,fromStation,toStation,reservedUpto,boardingStation,seatType);
        }



    }
}
