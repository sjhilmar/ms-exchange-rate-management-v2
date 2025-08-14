package com.nttdata.emeal.mapper;

import com.nttdata.emeal.domain.ManageExchangeRate;
import com.nttdata.emeal.model.ManageExchangeRateResponse;
import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;

/**
 * <br/> ManageExchangeRateMapper <br/>
 * <b>Class</b>: ManageExchangeRateMapper<br/>
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
@Mapper
@ApplicationScoped
public interface ManageExchangeRateMapper {
  ManageExchangeRateMapper INSTANCE = org.mapstruct.factory.Mappers
      .getMapper(ManageExchangeRateMapper.class);

  ManageExchangeRateResponse manageExchangeRateToResponse(
      ManageExchangeRate manageExchangeRate);

}
