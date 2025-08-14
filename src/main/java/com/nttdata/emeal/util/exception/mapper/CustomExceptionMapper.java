package com.nttdata.emeal.util.exception.mapper;

import com.nttdata.emeal.util.exception.CustomException;
import com.nttdata.emeal.util.exception.dto.ErrorResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import static com.nttdata.emeal.util.Util.getCurrentDateTimeFormatted;

/**
 * <br/> CustomExceptionMapper <br/>
 * <b>Class</b>: CustomExceptionMapper<br/>
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
@Provider
public class CustomExceptionMapper implements ExceptionMapper<CustomException> {

  @Override
  public Response toResponse(CustomException exception) {
    ErrorResponse response = ErrorResponse.builder()
        .code(exception.getErrorCatalog().getCode())
        .description(exception.getErrorCatalog().getDescription())
        .typeError(exception.getErrorCatalog().getType())
        .httpStatus(exception.getErrorCatalog().getHttpStatus())
        .dateTimeException(getCurrentDateTimeFormatted())
        .build();

    return Response.status(exception.getErrorCatalog().getHttpStatus())
        .entity(response)
        .build();
  }
}
