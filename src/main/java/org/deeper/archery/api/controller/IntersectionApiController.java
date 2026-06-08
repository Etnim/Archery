package org.deeper.archery.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.deeper.archery.api.IntersectionApi;
import org.deeper.archery.api.model.request.IntersectionRequest;
import org.deeper.archery.api.model.response.IntersectionResponse;
import org.deeper.archery.api.model.response.RequestCountResponse;
import org.deeper.archery.service.IntersectionService;
import org.deeper.archery.service.RequestTrackingService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class IntersectionApiController implements IntersectionApi {
    private final IntersectionService intersectionService;
    private final RequestTrackingService requestTrackingService;

    @Override
    public IntersectionResponse checkIntersection(@Valid @RequestBody IntersectionRequest request) {
        return intersectionService.intersection(request);
    }

    @Override
    public RequestCountResponse getRequestCount() {
        return new RequestCountResponse(requestTrackingService.getActiveRequestCount());
    }
}