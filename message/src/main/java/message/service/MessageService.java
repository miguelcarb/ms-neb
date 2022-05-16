package message.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import message.api.MessageRequestDto;
import message.entities.MessageEntity;
import message.repository.MessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    @Transactional
    public void saveMessage(MessageRequestDto dto) {

        MessageEntity messageEntity = new MessageEntity();

        messageEntity.setEmail(dto.getEmail());
        messageEntity.setContent(dto.getContent());

        messageRepository.save(messageEntity);
    }
}
