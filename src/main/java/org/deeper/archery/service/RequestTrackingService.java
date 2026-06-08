package org.deeper.archery.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RequestTrackingService {

    private final AtomicInteger activeRequests = new AtomicInteger(0);

    public void increment() {
        activeRequests.incrementAndGet();
    }

    public void decrement() {
        activeRequests.decrementAndGet();
    }

    public int getActiveRequestCount() {
        return activeRequests.get();
    }
}