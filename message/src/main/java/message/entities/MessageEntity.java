package message.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode()
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
@Table(name = "gen_message")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "date_created")
    private LocalDateTime dateCreated = LocalDateTime.now();

    @Column(name = "message_content")
    private String content;
}
