package net.minchev.documents.screen.document;

import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import net.minchev.documents.entity.CorrespondenceType;

@UiController("CorrespondenceType.edit")
@UiDescriptor("correspondence-type-edit.xml")
@EditedEntityContainer("correspondenceTypeDc")
public class CorrespondenceTypeEdit extends StandardEditor<CorrespondenceType> {
}
