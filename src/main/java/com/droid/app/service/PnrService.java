package com.droid.app.service;

import com.droid.app.http.client.IrctcWebClient;
import org.springframework.stereotype.Service;

/**
 * Created by vinay on 19/8/16.
 */
@Service
public class PnrService {


    private IrctcWebClient irctcWebClient;

    public PnrService(IrctcWebClient irctcWebClient) {
        this.irctcWebClient = irctcWebClient;
    }

    public String getPnrStatus(String pnr) {
        return irctcWebClient.queryPnr(pnr);

    }
}
