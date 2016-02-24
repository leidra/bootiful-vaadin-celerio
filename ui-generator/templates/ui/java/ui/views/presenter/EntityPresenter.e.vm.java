$output.java("${configuration.rootPackage}.web.ui.views.${entity.model.typeLow}","${entity.entityConfig.entityName}Presenter")##

$output.require("com.vaadin.data.fieldgroup.BeanFieldGroup")##
$output.require("com.vaadin.data.fieldgroup.FieldGroup")##
$output.require("com.vaadin.data.util.BeanItemContainer")##
$output.require("com.vaadin.spring.annotation.SpringComponent")##
$output.require("com.vaadin.ui.Notification")##
$output.require("com.vaadin.ui.UI")##
$output.require("${configuration.rootPackage}.service.${entity.entityConfig.entityName}Service")##
$output.require("${configuration.rootPackage}.service.Service")##
$output.require("${configuration.rootPackage}.shared.dtos.${entity.entityConfig.entityName}ListDto")##
$output.require("${configuration.rootPackage}.shared.dtos.${entity.entityConfig.entityName}Dto")##
$output.require("${configuration.rootPackage}.web.ui.MainUI")##
$output.require("${configuration.rootPackage}.web.ui.views.AbstractView")##
$output.require("${configuration.rootPackage}.web.ui.presenter.AbstractPresenter")##
$output.require("org.springframework.beans.factory.annotation.Autowired")##
$output.require("org.springframework.beans.factory.annotation.Qualifier")##
$output.require("org.springframework.context.annotation.Scope")##
$output.require("org.springframework.web.util.TagUtils")##
$output.require("java.util.Set")##

@SpringComponent(${output.currentClass}.PRESENTER_NAME)
@Scope(TagUtils.SCOPE_SESSION)
public class $output.currentClass extends AbstractPresenter<${entity.entityConfig.entityName}Dto, $entity.primaryKey.type> {
    public final static String PRESENTER_NAME = "${entity.entityConfig.entityName}Presenter";

    public ${entity.entityConfig.entityName}Dto save(BeanFieldGroup fieldGroup) {
        ${entity.entityConfig.entityName}Dto dto = (${entity.entityConfig.entityName}Dto) fieldGroup.getItemDataSource().getBean();
        try {
            getCurrentView().getEditor().setValidationVisible(!fieldGroup.isValid());
            fieldGroup.commit();
            dto = (${entity.entityConfig.entityName}Dto) fieldGroup.getItemDataSource().getBean();
            dto = getService().save(dto);
        } catch (FieldGroup.CommitException ex) {
            StringBuilder error = new StringBuilder("No se pudo guardar. Errores: ");
            Notification.show(error.toString(), Notification.Type.ERROR_MESSAGE);
        }

        return dto;
    }

    protected AbstractView getCurrentView() {
        return (AbstractView) ((MainUI) UI.getCurrent()).getViewProvider().getView(${entity.entityConfig.entityName}View.VIEW_NAME);
    }

    public Set<${entity.entityConfig.entityName}Dto> findAll() {
        return getService().findAll();
    }

    public void showEditor() {
        edit(new ${entity.entityConfig.entityName}Dto());
    }

    @Override
    public BeanItemContainer createDatasource() {
        return new BeanItemContainer<>(${entity.entityConfig.entityName}ListDto.class, ((${entity.entityConfig.entityName}Service) getService()).findAllForList());
    }

    @Override
    @Autowired
    @Qualifier(${entity.entityConfig.entityName}Service.SERVICE_NAME)
    public void setService(Service service) {
        this.service = service;
    }
}