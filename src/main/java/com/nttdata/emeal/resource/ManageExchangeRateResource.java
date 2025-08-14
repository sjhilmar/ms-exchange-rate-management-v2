package com.nttdata.emeal.resource;

import com.nttdata.emeal.model.ExchangeRateCountResponse;
import com.nttdata.emeal.model.ManageExchangeRateRequest;
import com.nttdata.emeal.model.ManageExchangeRateResponse;
import com.nttdata.emeal.service.ExchangeRateApiService;
import com.nttdata.emeal.service.ManageExchangeRateService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <br/> ManageExchangeRate <br/>
 * <b>Class</b>: ManageExchangeRate<br/>
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
@Slf4j
@Path("manage-exchange-rate")
@Consumes("application/json")
@Produces("application/json")
@AllArgsConstructor
public class ManageExchangeRateResource {

  private final ExchangeRateApiService exchangeRateApiService;
  private final ManageExchangeRateService manageExchangeRateService;

  @POST
  @Path("/fetch-exchange-rate")
  public Response fetchExchangeRate(@Valid ManageExchangeRateRequest request) {
    log.info("Fetching exchange rate via POST request");
    ManageExchangeRateResponse response = manageExchangeRateService.fetchExchangeRate(request);
    return Response.ok(response).build();
  }
  @GET
  @Path("/request-count/{dni}")
  public Response getFetchCount(@PathParam("dni") String dni) {
    log.info("Fetching count of exchange rate request");
    ExchangeRateCountResponse response = manageExchangeRateService.getRequestCountByDni(dni);
    return Response.ok(response).build();
  }

}
