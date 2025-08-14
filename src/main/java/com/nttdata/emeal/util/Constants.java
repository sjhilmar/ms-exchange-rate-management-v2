package com.nttdata.emeal.util;

import lombok.NoArgsConstructor;

/**
 * <br/> Constants <br/>
 * <b>Class</b>: Constants<br/>
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
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Constants {
  public static final String CONSULTANT_USER_DNI = "consultantUser.dni";
  public static final String COUNT_BY_DNI_AND_DATE = "{ \"consultantUser.dni\": ?1, "
      + "\"$expr\": { \"$eq\": [ { \"$substrCP\": [ \"$fetchDate\", 0, 10 ] }, ?2 ] } }";
  public static final String BUSINESS = "Business";
  public static final String TECHNICAL = "Technical";
}
