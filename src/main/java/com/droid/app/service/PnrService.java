package com.droid.app.service;

import com.droid.app.entity.PnrStatus;
import com.droid.app.http.client.IrctcWebClient;
import com.droid.app.response.parser.ResponseParser;
import org.springframework.stereotype.Service;

/**
 * Created by vinay on 19/8/16.
 */
@Service
public class PnrService {


    private IrctcWebClient irctcWebClient;
    private ResponseParser<PnrStatus,String> pnrStatusResponseParser;

    public PnrService(IrctcWebClient irctcWebClient, ResponseParser<PnrStatus, String> pnrStatusResponseParser) {
        this.irctcWebClient = irctcWebClient;
        this.pnrStatusResponseParser = pnrStatusResponseParser;
    }

    public PnrStatus getPnrStatus(String pnr) {
        String response = irctcWebClient.queryPnr(pnr);
        return pnrStatusResponseParser.parseResponse(response);
    }
}
