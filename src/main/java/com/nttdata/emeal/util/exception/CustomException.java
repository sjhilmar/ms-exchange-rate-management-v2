package com.nttdata.emeal.util.exception;

import com.nttdata.emeal.util.exception.enums.ExceptionCatalog;
import lombok.Builder;
import lombok.Getter;

/**
 * <br/> CustomException <br/>
 * <b>Class</b>: CustomException<br/>
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
@Builder
@Getter
public class CustomException extends  RuntimeException{

  private final ExceptionCatalog errorCatalog;

  public CustomException(ExceptionCatalog errorCatalog) {
    super(errorCatalog.getDescription());
    this.errorCatalog = errorCatalog;
  }
  public CustomException(ExceptionCatalog errorCatalog,
                         Throwable cause) {
    super(errorCatalog.getDescription(), cause);
    this.errorCatalog = errorCatalog;
  }

}
