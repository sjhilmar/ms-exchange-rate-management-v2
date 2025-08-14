package com.nttdata.emeal.service;

import com.nttdata.emeal.model.ExchangeRateCountResponse;
import com.nttdata.emeal.model.ManageExchangeRateRequest;
import com.nttdata.emeal.model.ManageExchangeRateResponse;

/**
 * <br/> ManageExchangeRateService <br/>
 * <b>Class</b>: ManageExchangeRateService<br/>
 * Copyright: &copy; 2025 JMR Code.<br/>
 *
 * @author JMR Code <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 *     <li>Sergi Jhilmar Alvarez Toledo (SJAT)</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 *     <li>Ago. 10, 2025 Creaci&oacute;n de Clase.</li>
 * </ul>
 * @version 1.0
 */
public interface ManageExchangeRateService {
    /**
     * Method to manage the exchange rate.
     *
     * @param request the request containing consultant user information
     * @return response containing exchange rate and fetch date
     */
    ManageExchangeRateResponse fetchExchangeRate(ManageExchangeRateRequest request);

    /**
     * Get detailed fetch count information by consultant's DNI.
     *
     * @param dni the consultant user's DNI
     * @return detailed fetch count response
     */
    ExchangeRateCountResponse getRequestCountByDni(String dni);

}
