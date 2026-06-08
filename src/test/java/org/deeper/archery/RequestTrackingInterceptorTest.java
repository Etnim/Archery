package org.deeper.archery;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.deeper.archery.interceptor.RequestTrackingInterceptor;
import org.deeper.archery.service.RequestTrackingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RequestTrackingInterceptorTest {

    @Mock
    private RequestTrackingService requestTrackingService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @InjectMocks
    private RequestTrackingInterceptor interceptor;

    @Test
    void preHandle_shouldIncrementActiveRequests() {
        interceptor.preHandle(request, response, new Object());

        verify(requestTrackingService).increment();
    }

    @Test
    void preHandle_shouldReturnTrue() {
        boolean result = interceptor.preHandle(request, response, new Object());

        assertTrue(result);
    }

    @Test
    void afterCompletion_shouldDecrementActiveRequests() {
        interceptor.afterCompletion(request, response, new Object(), null);

        verify(requestTrackingService).decrement();
    }

    @Test
    void afterCompletion_shouldDecrementEvenWhenExceptionOccurs() {
        interceptor.afterCompletion(request, response, new Object(), new RuntimeException("error"));

        verify(requestTrackingService).decrement();
    }

    @Test
    void preHandle_shouldIncrementBeforeRequestIsProcessed() {
        interceptor.preHandle(request, response, new Object());

        verify(requestTrackingService, times(1)).increment();
        verify(requestTrackingService, never()).decrement();
    }
}
