/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.javaagent.instrumentation.apachehttpclient.v4_0;

import io.opentelemetry.instrumentation.api.instrumenter.http.HttpAttributesExtractor;
import org.apache.http.HttpResponse;
import org.checkerframework.checker.nullness.qual.Nullable;

final class ApacheHttpClientHttpAttributesExtractor
    extends HttpAttributesExtractor<ApacheHttpClientRequest, HttpResponse> {

  @Override
  protected String method(ApacheHttpClientRequest request) {
    return request.getMethod();
  }

  @Override
  protected String url(ApacheHttpClientRequest request) {
    return request.getUrl();
  }

  @Override
  protected String target(ApacheHttpClientRequest request) {
    return request.getTarget();
  }

  @Override
  @Nullable
  protected String host(ApacheHttpClientRequest request) {
    return request.getHeader("Host");
  }

  @Override
  @Nullable
  protected String scheme(ApacheHttpClientRequest request) {
    return request.getScheme();
  }

  @Override
  @Nullable
  protected String userAgent(ApacheHttpClientRequest request) {
    return request.getHeader("User-Agent");
  }

  @Override
  @Nullable
  protected Long requestContentLength(
      ApacheHttpClientRequest request, @Nullable HttpResponse response) {
    return null;
  }

  @Override
  @Nullable
  protected Long requestContentLengthUncompressed(
      ApacheHttpClientRequest request, @Nullable HttpResponse response) {
    return null;
  }

  @Override
  protected Integer statusCode(ApacheHttpClientRequest request, HttpResponse response) {
    return response.getStatusLine().getStatusCode();
  }

  @Override
  @Nullable
  protected String flavor(ApacheHttpClientRequest request, @Nullable HttpResponse response) {
    return request.getFlavor();
  }

  @Override
  @Nullable
  protected Long responseContentLength(ApacheHttpClientRequest request, HttpResponse response) {
    return null;
  }

  @Override
  @Nullable
  protected Long responseContentLengthUncompressed(
      ApacheHttpClientRequest request, HttpResponse response) {
    return null;
  }

  @Override
  @Nullable
  protected String serverName(ApacheHttpClientRequest request, @Nullable HttpResponse response) {
    return null;
  }

  @Override
  @Nullable
  protected String route(ApacheHttpClientRequest request) {
    return null;
  }
}
