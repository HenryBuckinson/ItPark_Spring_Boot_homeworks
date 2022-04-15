package Application.service.impl;

import Application.model.Subscriber;
import Application.repository.SubscriberRepository;
import Application.service.SubscriberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SubscriberServiceImpl implements SubscriberService {

    private final SubscriberRepository subscriberRepository;

    @Override
    public void save(Subscriber subscriber) {
        subscriberRepository.save(subscriber);
    }
}
