package net.minchev.documents.listener;

import io.jmix.core.event.EntitySavingEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minchev.documents.entity.Document;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Component
@AllArgsConstructor
public class DocumentListener {

    @EventListener
    public void onBeforeInsert(EntitySavingEvent<Document> event) {

        if (event.isNewEntity()) {
            //when entity is a new record, set number, date and statusDate
            final LocalDateTime now = LocalDateTime.now();
            event.getEntity().setNumber(_setDocumentNumber());
            event.getEntity().setDate(now);
            event.getEntity().setStatusDate(now);
            log.info("document listener: set document number, date and status date before insert : {}", event.getEntity());
        }
    }

    private String _setDocumentNumber(){
        return UUID.randomUUID().toString();
    }
}
