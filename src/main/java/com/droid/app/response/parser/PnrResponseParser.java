package com.droid.app.response.parser;

import com.droid.app.entity.PnrStatus;
import com.droid.app.entity.SeatStatus;
import com.droid.app.entity.TrainDetails;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinay on 25/8/16.
 */
@Component
public class PnrResponseParser implements ResponseParser<PnrStatus, String> {

    private static final String TRAIN_DATA_ROW_SELECTOR = "tr.heading_table";
    private static final String PNR_DATA_TABLE_SELECTOR = "center_table";
    private static final String TABLE_ROW_SELECTOR = "tr";
    private static final String TABLE_CELL_SELECTOR = "td";
    private static final String PASSENGER_ROW_IDENTIFIER = "Passenger";

    @Override
    public PnrStatus parseResponse(String response) {
        Document responseDocument = Jsoup.parse(response);
        TrainDetails trainDetails = getTrainDetails(responseDocument);
        List<SeatStatus> seatStatuses = getSeatStatus(responseDocument);
        return new PnrStatus(getPnrNumber(responseDocument), seatStatuses, trainDetails);


    }

    private TrainDetails getTrainDetails(Document document) {
        Element trainDataRow = document.select(TRAIN_DATA_ROW_SELECTOR).get(0).nextElementSibling();
        Elements trainDataCells = trainDataRow.getAllElements();
        return TrainDetails.getBuilder()
                .number(trainDataCells.get(1).text())
                .name(trainDataCells.get(2).text())
                .boardingDate(trainDataCells.get(3).text())
                .fromStation(trainDataCells.get(4).text())
                .toStation(trainDataCells.get(5).text())
                .reservedUpto(trainDataCells.get(6).text())
                .boardingStation(trainDataCells.get(7).text())
                .seatType(trainDataCells.get(8).text())
                .createTrainDetails();
    }

    private List<SeatStatus> getSeatStatus(Document responseDocument) {
        List<SeatStatus> seatStatuses = new ArrayList<>();
        Elements pnrDataRows = responseDocument.getElementById(PNR_DATA_TABLE_SELECTOR).select(TABLE_ROW_SELECTOR);
        for (Element pnrRow : pnrDataRows) {
            if (isPassengerInfoRow(pnrRow)) {
                SeatStatus seatStatus = new SeatStatus(pnrRow.select(TABLE_CELL_SELECTOR).get(1).text(), pnrRow.select(TABLE_CELL_SELECTOR).get(2).text());
                seatStatuses.add(seatStatus);
            }
        }
        return seatStatuses;
    }

    private boolean isPassengerInfoRow(Element row) {
        return row.getAllElements().select(TABLE_CELL_SELECTOR).first().text().startsWith(PASSENGER_ROW_IDENTIFIER);
    }

    private String getPnrNumber(Document document) {
        return document.select("td.Enq_heading:contains(PNR Number)").text().substring(31);
    }





}
