$output.java("${configuration.rootPackage}.web.ui.views.${entity.model.typeLow}.crud","${entity.entityConfig.entityName}Editor")##

$output.require("com.vaadin.data.fieldgroup.BeanFieldGroup")##
$output.require("com.vaadin.spring.annotation.SpringComponent")##
$output.require("com.vaadin.ui.CssLayout")##
$output.require("com.vaadin.ui.TextField")##
$output.require("${configuration.rootPackage}.domain.${entity.entityConfig.entityName}")##
$output.require("${configuration.rootPackage}.shared.dtos.${entity.entityConfig.entityName}Dto")##
$output.require("${configuration.rootPackage}.web.ui.components.EditorComponent")##
$output.require("${configuration.rootPackage}.web.ui.presenter.AbstractPresenter")##
$output.require("${configuration.rootPackage}.web.ui.views.${entity.model.typeLow}.${entity.entityConfig.entityName}Presenter")##
$output.require("org.springframework.beans.factory.annotation.Autowired")##
$output.require("org.springframework.beans.factory.annotation.Qualifier")##
$output.require("org.springframework.beans.factory.config.BeanDefinition")##
$output.require("org.springframework.context.annotation.Scope")##

@SpringComponent
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ${entity.entityConfig.entityName}Editor extends EditorComponent<${entity.entityConfig.entityName}Dto, $entity.primaryKey.type> {
    private TextField name;
    private TextField brand;

    @Override
    @Autowired
    @Qualifier(${entity.entityConfig.entityName}Presenter.PRESENTER_NAME)
    public void setPresenter(AbstractPresenter presenter) {
        super.setPresenter(presenter);
    }

    @Override
    protected void configureFields() {
        fieldGroup = new BeanFieldGroup<>(${entity.entityConfig.entityName}Dto.class);

        brand.setNullRepresentation("");
        name.setNullRepresentation("");

        super.configureFields(name, brand);
    }

    @Override
    protected void createFieldsComponents(CssLayout editorLayout) {
        name = new TextField("Name");
        brand = new TextField("Brand");

        editorLayout.addComponent(createFieldContainer(name));
        editorLayout.addComponent(createFieldContainer(brand));
    }

}