package com.nttdata.emeal.util.exception.enums;

import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.nttdata.emeal.util.Constants.BUSINESS;
import static com.nttdata.emeal.util.Constants.TECHNICAL;

/**
 * <br/> ExceptionCatalog <br/>
 * <b>Class</b>: ExceptionCatalog<br/>
 * Copyright: &copy; 2025 JMR Code.<br/>
 *
 * @author JMR Code <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 *     <li>Sergi Jhilmar Alvarez Toledo (SJAT)</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 *     <li>Ago. 11, 2025 Creaci&oacute;n de Clase.</li>
 * </ul>
 * @version 1.0
 */
@AllArgsConstructor
@Getter
public enum ExceptionCatalog {

  EXCHANGE_RATE_NOT_FOUND("EX001",
      "Exchange rate not found for the given currency.",
      BUSINESS,
      Response.Status.NOT_FOUND),
  EXCHANGE_RATE_API_ERROR("EX002",
      "Error occurred while fetching exchange rate from external API.",
      TECHNICAL,
      Response.Status.INTERNAL_SERVER_ERROR),
  MANAGEMENT_EXCHANGE_RATE_ERROR("EX003",
      "Error occurred while managing exchange rate.",
      TECHNICAL,
      Response.Status.INTERNAL_SERVER_ERROR),
  BUSINESS_ERROR_LIMIT_EXCEEDED("EX004",
      "Business operation limit exceeded.",
      BUSINESS,
      Response.Status.TOO_MANY_REQUESTS),
  BUSINESS_ERROR_INVALID_REQUEST("EX005",
      "Invalid request parameters for business operation.",
      BUSINESS,
      Response.Status.BAD_REQUEST),
  BUSINESS_ERROR_DNI_NOT_FOUND("EX006",
      "DNI not found for the consultant user.",
      BUSINESS,
      Response.Status.NOT_FOUND);

  private final String code;
  private final String description;
  private final String type;
  private final Response.Status httpStatus;

}
