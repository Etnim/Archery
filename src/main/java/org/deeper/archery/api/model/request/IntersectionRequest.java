package org.deeper.archery.api.model.request;

import jakarta.validation.Valid;

public record IntersectionRequest(
  @Valid CrackerRequest cracker,
  @Valid ArrowRequest arrow
) {}