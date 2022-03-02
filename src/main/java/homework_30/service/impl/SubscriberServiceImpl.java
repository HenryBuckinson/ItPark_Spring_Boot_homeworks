package homework_30.service.impl;

import homework_30.model.Subscriber;
import homework_30.repository.SubscriberRepository;
import homework_30.service.SubscriberService;
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
