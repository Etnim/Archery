package org.deeper.archery.api.model;

import jakarta.validation.constraints.NotNull;

public record Point(
  @NotNull Double x,
  @NotNull Double y
) {}