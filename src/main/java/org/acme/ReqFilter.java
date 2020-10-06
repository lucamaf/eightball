package org.acme;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ServerResponse;

import io.vertx.core.http.HttpServerRequest;

@Provider
public class ReqFilter implements ContainerRequestFilter {
  //private static final ServerResponse WRONG_QUERY = new ServerResponse("Unprocessable request", 422, new Headers < Object > ());
  private static final Logger LOG = Logger.getLogger(ReqFilter.class);

  @Context
  UriInfo info;

  @Context
  HttpServerRequest request;

  @Override
  public void filter(ContainerRequestContext context) {
    //int size = info.getQueryParameters().size();
    //boolean test = info.getQueryParameters().containsKey("sentiment");
    //if (size >= 1 && test == false) {
    //  context.abortWith(WRONG_QUERY);
    //}
    final String method = context.getMethod();
    final String path = info.getPath();
    final String address = request.remoteAddress().toString();
    //final String headers = request.headers().toString();
    LOG.infof("Request %s %s from IP %s", method, path, address);
  }
}