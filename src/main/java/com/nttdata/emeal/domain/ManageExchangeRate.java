package com.nttdata.emeal.domain;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.nttdata.emeal.openapi.model.ExchangeRateResponse;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <br/> ManageEchageRate <br/>
 * <b>Class</b>: ManageEchageRate<br/>
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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@MongoEntity(collection = "manage-exchange-rate")
public class ManageExchangeRate {
  @JsonTypeId
  private String id;
  private ConsultantUser consultantUser;
  private ExchangeRateResponse exchangeRate;
  private String fetchDate;
}
