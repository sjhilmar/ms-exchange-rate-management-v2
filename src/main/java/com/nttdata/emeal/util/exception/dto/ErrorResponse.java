package com.nttdata.emeal.util.exception.dto;

import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <br/> ErrorResponse <br/>
 * <b>Class</b>: ErrorResponse<br/>
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
@NoArgsConstructor
@Data
@Builder
public class ErrorResponse {
  private String code;
  private String description;
  private String typeError;
  private Response.Status httpStatus;
  private String dateTimeException;
}
