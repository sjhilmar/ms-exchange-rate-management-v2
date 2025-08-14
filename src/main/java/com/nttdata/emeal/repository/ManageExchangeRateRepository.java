package com.nttdata.emeal.repository;

import com.nttdata.emeal.domain.ManageExchangeRate;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import static com.nttdata.emeal.util.Constants.CONSULTANT_USER_DNI;
import static com.nttdata.emeal.util.Constants.COUNT_BY_DNI_AND_DATE;

/**
 * <br/> ManageExchangeRateRepository <br/>
 * <b>Class</b>: ManageExchangeRateRepository<br/>
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
public class ManageExchangeRateRepository implements PanacheMongoRepository<ManageExchangeRate> {

  public ManageExchangeRate findByConsultantDni(String dni) {
    return find(CONSULTANT_USER_DNI, dni).firstResult();
  }

  public void deleteByConsultantDni(String dni) {
    delete(CONSULTANT_USER_DNI, dni);
  }

  public long countByDniAndDate(String dni, String date) {
    return count(COUNT_BY_DNI_AND_DATE, dni, date);
  }
}
