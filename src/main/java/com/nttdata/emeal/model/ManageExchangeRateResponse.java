package com.nttdata.emeal.model;

import com.nttdata.emeal.domain.ConsultantUser;
import com.nttdata.emeal.openapi.model.ExchangeRateResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <br/> ManageExchangeRateResponse <br/>
 * <b>Class</b>: ManageExchangeRateResponse<br/>
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
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ManageExchangeRateResponse {
  private ConsultantUser consultantUser;
  private ExchangeRateResponse exchangeRate;
  private String fetchDate;
  private long fetchCount;
}
