package com.drodrigues17.webflux.exception;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
@Order(-2)
public class ExceptionHandler extends AbstractErrorWebExceptionHandler {


  /**
   * Create a new {@code AbstractErrorWebExceptionHandler}.
   *
   * @param errorAttributes    the error attributes
   * @param resources          the resources configuration properties
   * @param applicationContext the application context
   * @since 2.4.0
   */
  public ExceptionHandler(ErrorAttributes errorAttributes,
                          WebProperties.Resources resources,
                          ApplicationContext applicationContext,
                          ServerCodecConfigurer codecConfigurer) {
    super(errorAttributes, resources, applicationContext);
    this.setMessageWriters(codecConfigurer.getWriters());
  }


  /**
   * Create a {@link RouterFunction} that can route and handle errors as JSON responses
   * or HTML views.
   * <p>
   * If the returned {@link RouterFunction} doesn't route to a {@code HandlerFunction},
   * the original exception is propagated in the pipeline and can be processed by other
   * {@link WebExceptionHandler}s.
   *
   * @param errorAttributes the {@code ErrorAttributes} instance to use to extract error
   *                        information
   * @return a {@link RouterFunction} that routes and handles errors
   */
  @Override
  protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
    return RouterFunctions.route(RequestPredicates.all(), this::formatErrorResponse);
  }

  private Mono<ServerResponse> formatErrorResponse(ServerRequest request) {
    Map<String, Object> e = getErrorAttributes(request, ErrorAttributeOptions.defaults());

    return ServerResponse
        .status(((int) e.get("status")))
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(e));
  }


  public static <T> Mono<T> tratarErroObjetoNaoEncontrado() {
    return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "anime não encontrado"));
  }
}
