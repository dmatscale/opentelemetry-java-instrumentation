/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.javaagent.instrumentation.dropwizardviews;

import io.dropwizard.views.View;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.instrumentation.api.config.ExperimentalConfig;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;

public final class DropwizardSingletons {

  private static final String INSTRUMENTATION_NAME = "io.opentelemetry.dropwizard-views-0.7";

  private static final Instrumenter<View, Void> INSTRUMENTER =
      Instrumenter.<View, Void>newBuilder(
              GlobalOpenTelemetry.get(), INSTRUMENTATION_NAME, DropwizardSingletons::spanName)
          .setDisabled(ExperimentalConfig.get().suppressControllerSpans())
          .newInstrumenter();

  private static String spanName(View view) {
    return "Render " + view.getTemplateName();
  }

  public static Instrumenter<View, Void> instrumenter() {
    return INSTRUMENTER;
  }

  private DropwizardSingletons() {}
}
