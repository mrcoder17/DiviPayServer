package ru.nsu.boxberger.DiviPay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.boxberger.DiviPay.model.Request;
import ru.nsu.boxberger.DiviPay.repository.RequestRepository;

import java.util.List;

@Service
public class RequestService {
    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Request getRequestById(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    public Request updateRequest(Long requestID, Request request) {
        Request existingRequest = requestRepository.findById(requestID).orElse(null);
        if (existingRequest != null) {
            existingRequest.setRequestID(requestID);
            existingRequest.setUserID(request.getUserID());
            existingRequest.setItemName(request.getItemName());
            existingRequest.setQuantity(request.getQuantity());

            return requestRepository.save(existingRequest);
        }
        return null;
    }

    public void deleteRequest(Long id) {
        requestRepository.findById(id).ifPresent(requestRepository::delete);
    }
}
