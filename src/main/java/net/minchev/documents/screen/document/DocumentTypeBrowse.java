package net.minchev.documents.screen.document;

import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import net.minchev.documents.entity.DocumentType;

@UiController("DocumentType.browse")
@UiDescriptor("document-type-browse.xml")
@LookupComponent("documentTypessTable")
public class DocumentTypeBrowse extends StandardLookup<DocumentType> {
}
