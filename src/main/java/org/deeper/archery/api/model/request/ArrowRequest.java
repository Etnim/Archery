package org.deeper.archery.api.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.deeper.archery.api.model.Point;

public record ArrowRequest(
  @Valid @NotNull Point start,
  @Valid @NotNull Point end
) {}