package com.nttdata.emeal.service.impl;

import com.nttdata.emeal.domain.ManageExchangeRate;
import com.nttdata.emeal.mapper.ManageExchangeRateMapper;
import com.nttdata.emeal.model.ExchangeRateCountResponse;
import com.nttdata.emeal.model.ManageExchangeRateRequest;
import com.nttdata.emeal.model.ManageExchangeRateResponse;
import com.nttdata.emeal.openapi.model.ExchangeRateResponse;
import com.nttdata.emeal.repository.ManageExchangeRateRepository;
import com.nttdata.emeal.service.ExchangeRateApiService;
import com.nttdata.emeal.service.ManageExchangeRateService;
import com.nttdata.emeal.util.exception.CustomException;
import dev.mccue.guava.base.Throwables;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.UUID;

import static com.nttdata.emeal.util.Util.getCurrentDateFormatted;
import static com.nttdata.emeal.util.Util.getCurrentDateTimeFormatted;
import static com.nttdata.emeal.util.exception.enums.ExceptionCatalog.BUSINESS_ERROR_DNI_NOT_FOUND;
import static com.nttdata.emeal.util.exception.enums.ExceptionCatalog.BUSINESS_ERROR_INVALID_REQUEST;
import static com.nttdata.emeal.util.exception.enums.ExceptionCatalog.BUSINESS_ERROR_LIMIT_EXCEEDED;
import static com.nttdata.emeal.util.exception.enums.ExceptionCatalog.MANAGEMENT_EXCHANGE_RATE_ERROR;

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
@ApplicationScoped
@AllArgsConstructor
@Slf4j
public class ManageExchangeRateServiceImpl implements ManageExchangeRateService {

  private final ExchangeRateApiService exchangeRateApiService;
  private final ManageExchangeRateRepository manageExchangeRateRepository;
  private static final ManageExchangeRateMapper mapper = ManageExchangeRateMapper.INSTANCE;

    /**
     * Method to manage the exchange rate.
     *
     * @param request the request containing consultant user information
     * @return response containing exchange rate and fetch date
     */
  @Override
  public ManageExchangeRateResponse fetchExchangeRate(ManageExchangeRateRequest request) {

    try {
      String dni = request.getConsultantUser().getDni();
      long fetchCount = requestCountByDni(dni);
      limitExceededValidation(dni, fetchCount);

      ExchangeRateResponse exchangeRateResponse = exchangeRateApiService.getCurrentExchangeRate();
      ManageExchangeRate manageExchangeRate = ManageExchangeRate.builder()
          .id(UUID.randomUUID().toString())
          .consultantUser(request.getConsultantUser())
          .exchangeRate(exchangeRateResponse)
          .fetchDate(getCurrentDateTimeFormatted())
          .build();

      manageExchangeRateRepository.persist(manageExchangeRate);
      ManageExchangeRateResponse response = mapper.manageExchangeRateToResponse(manageExchangeRate);
      response.setFetchCount(requestCountByDni(dni));
      return response;

    } catch (Exception e) {
      log.error("CustomException occurred: {}", e.getMessage(), e);
      Throwable cause = Throwables.getRootCause(e);
      if (cause instanceof CustomException ce) {
        throw ce;
      }
      throw new CustomException(MANAGEMENT_EXCHANGE_RATE_ERROR, e);
    }
  }

  @Override
  public ExchangeRateCountResponse getRequestCountByDni(String dni) {

    log.info("Getting request count by Consultant DNI: {}", dni);
    long count = requestCountByDni(dni);
    requestNumberValidation(dni, count);
    return ExchangeRateCountResponse.builder()
        .fetchCount(manageExchangeRateRepository.countByDniAndDate(dni,
            getCurrentDateFormatted()))
        .build();
  }

  private long requestCountByDni(String dni) {

    log.info("Counting requests for consultant DNI: {}", dni);
    dniValidation(dni);
    return manageExchangeRateRepository.countByDniAndDate(dni,
        getCurrentDateFormatted());
  }

  private void dniValidation(String dni) {
    if (Optional.ofNullable(dni).isEmpty() || dni.isBlank()) {
      log.error("DNI is null or empty");
      throw new CustomException(BUSINESS_ERROR_INVALID_REQUEST);
    }
  }

  private void requestNumberValidation(String dni, long count) {
    if (count == 0) {
      log.warn("No fetches found for DNI: {}", dni);
      throw new CustomException(BUSINESS_ERROR_DNI_NOT_FOUND);
    }
  }

  private void limitExceededValidation(String dni, long fetchCount) {
    if (fetchCount >= 10) {
      log.error("Fetch limit exceeded for consultant: {}", dni);
      throw new CustomException(BUSINESS_ERROR_LIMIT_EXCEEDED);
    }
  }
}
