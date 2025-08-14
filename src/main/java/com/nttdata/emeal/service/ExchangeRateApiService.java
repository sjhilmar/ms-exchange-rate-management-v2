package com.nttdata.emeal.service;

import com.nttdata.emeal.openapi.api.ExchangeRateApi;
import com.nttdata.emeal.openapi.model.ExchangeRateResponse;
import com.nttdata.emeal.util.exception.CustomException;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import static com.nttdata.emeal.util.exception.enums.ExceptionCatalog.EXCHANGE_RATE_API_ERROR;

/**
 * <br/> ExchangeRateApi <br/>
 * <b>Class</b>: ExchangeRateApi<br/>
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
@ApplicationScoped
@Slf4j
public class ExchangeRateApiService {

  @RestClient
  ExchangeRateApi exchangeRateApi;

  public ExchangeRateResponse getCurrentExchangeRate() {
    try {
      log.info("Fetching current exchange rate from API");
      return exchangeRateApi.getCurrentExchangeRate();
    } catch (Exception e) {
      log.error("Error fetching current exchange rate: {}", e.getMessage(), e);
      throw new CustomException(EXCHANGE_RATE_API_ERROR, e);
    }
  }

}
