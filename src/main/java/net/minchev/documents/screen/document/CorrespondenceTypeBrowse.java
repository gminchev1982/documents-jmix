package net.minchev.documents.screen.document;

import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import net.minchev.documents.entity.CorrespondenceType;

@UiController("CorrespondenceTypeBrowse.browse")
@UiDescriptor("correspondence-type-browse.xml")
@LookupComponent("corresponcenTypesTable")
public class CorrespondenceTypeBrowse extends StandardLookup<CorrespondenceType> {
}
