package org.deeper.archery.api.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.deeper.archery.api.model.Point;

public record CrackerRequest (
  @Valid @NotNull Point topLeft,
  @Valid @NotNull Point topRight,
  @Valid @NotNull Point bottomLeft,
  @Valid @NotNull Point bottomRight
){}