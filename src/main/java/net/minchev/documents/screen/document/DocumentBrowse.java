package net.minchev.documents.screen.document;

import io.jmix.core.DataManager;
import io.jmix.core.LoadContext;
import io.jmix.core.Messages;
import io.jmix.core.metamodel.model.MetaClass;
import io.jmix.core.querycondition.PropertyConditionUtils;
import io.jmix.ui.UiComponents;
import io.jmix.ui.component.Filter;
import io.jmix.ui.component.FilterComponent;
import io.jmix.ui.component.PropertyFilter;
import io.jmix.ui.component.filter.configuration.DesignTimeConfiguration;
import io.jmix.ui.component.propertyfilter.SingleFilterSupport;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.DataLoader;
import io.jmix.ui.screen.*;
import net.minchev.documents.entity.Document;
import io.jmix.ui.navigation.Route;
import net.minchev.documents.entity.DocumentType;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@UiController("Document.browse")
@UiDescriptor("document-browse.xml")
@LookupComponent("documentsTable")
@Route("documents")
public class DocumentBrowse extends StandardLookup<Document> {

    @Autowired
    protected UiComponents uiComponents;

    @Autowired
    protected SingleFilterSupport singleFilterSupport;

    @Autowired
    protected Filter filter;

    @Autowired
    protected DataManager dataManager;

    @Subscribe
    protected void onInit(InitEvent event) {
       List<FilterComponent> filterComponents = filter.getCurrentConfiguration().getRootLogicalFilterComponent().getFilterComponents();

      DesignTimeConfiguration javaDefaultConfigurationPF =
                filter.addConfiguration("javaDefaultConfiguration",
                        "Default configuration");

        DataLoader dataLoaderPF = filter.getDataLoader();

        PropertyFilter<DocumentType> documentTypePropertyFilter = uiComponents.create(PropertyFilter.NAME);

        documentTypePropertyFilter.setConditionModificationDelegated(true);
        documentTypePropertyFilter.setDataLoader(dataLoaderPF);
        documentTypePropertyFilter.setProperty("type");
        documentTypePropertyFilter.setOperation(PropertyFilter.Operation.IN_LIST);
        documentTypePropertyFilter.setOperationEditable(true);
        documentTypePropertyFilter.setParameterName(PropertyConditionUtils.generateParameterName(
                documentTypePropertyFilter.getProperty()));
        documentTypePropertyFilter.setValueComponent(singleFilterSupport.generateValueComponent(
                dataLoaderPF.getContainer().getEntityMetaClass(),
                documentTypePropertyFilter.getProperty(),
                documentTypePropertyFilter.getOperation()
        ));

       /* Set<DocumentType> types = new HashSet<>();
        DocumentType documentType  = dataManager.load(DocumentType.class).id(1).one();
        DocumentType documentType2  = dataManager.load(DocumentType.class).id(101).one();
        types.add(documentType);
        types.add(documentType2);

        documentTypePropertyFilter.setValue(types);
        javaDefaultConfigurationPF.setFilterComponentDefaultValue(
                documentTypePropertyFilter.getParameterName(), types);*/

        javaDefaultConfigurationPF.getRootLogicalFilterComponent().add(documentTypePropertyFilter);

        filter.setCurrentConfiguration(javaDefaultConfigurationPF);
    }



}
