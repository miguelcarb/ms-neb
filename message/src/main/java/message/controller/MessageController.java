package message.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import message.api.MessageRequestDto;
import message.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/message")
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping(value = "/saveMessage")
    public ResponseEntity<Void> saveMessage(@RequestBody MessageRequestDto messageRequestDto) {

        log.debug("Entering save message {}  :", messageRequestDto);

        messageService.saveMessage(messageRequestDto);

        return ResponseEntity.noContent().build();
    }
}
