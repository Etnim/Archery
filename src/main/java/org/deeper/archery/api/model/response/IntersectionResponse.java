package org.deeper.archery.api.model.response;

import org.deeper.archery.api.model.Point;

import java.util.List;

public record IntersectionResponse(
  List<Point> intersectionPoints
) {}