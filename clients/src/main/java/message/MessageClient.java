package message;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "message",
        url = "${clients.message.url}"
)
public interface MessageClient {

    @PostMapping(path = "api/v1/message/saveMessage")
    ResponseEntity<Void> saveMessage(@RequestBody MessageRequestDto messageRequestDto);
}
