package org.deeper.archery.service;

import lombok.AllArgsConstructor;
import org.deeper.archery.api.model.request.IntersectionRequest;
import org.deeper.archery.api.model.response.IntersectionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IntersectionService {
    public IntersectionResponse intersection(IntersectionRequest request) {
        return new IntersectionResponse(List.of());
    }
}
