package net.minchev.documents.screen.document;

import io.jmix.core.Messages;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.ComboBox;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import net.minchev.documents.entity.Document;
import net.minchev.documents.entity.enums.DocumentKind;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@UiController("Document.edit")
@UiDescriptor("document-edit.xml")
@EditedEntityContainer("documentDc")
public class DocumentEdit extends StandardEditor<Document> {

    @Autowired
    protected InstanceContainer<Document> documentDc;

    @Autowired
    protected Notifications notifications;

    @Autowired
    private Messages me;

    @Subscribe
    public void onInit(InitEvent event) {

    }

    @Subscribe(id = "documentDc", target = Target.DATA_CONTAINER)
    protected void onCustomerDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Document> event) {
        itemPropertyChanged(event);
    }

    protected void itemPropertyChanged(InstanceContainer.ItemPropertyChangeEvent<?> event) {
        String msg = event.getItem().getClass().getSimpleName() + "." + event.getProperty() + " = " + event.getValue();
        notifications.create()
                .withCaption(msg)
                .show();
    }
}
