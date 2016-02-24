$output.java("${configuration.rootPackage}.web.ui.presenter","Presenter")##

$output.require("com.vaadin.data.fieldgroup.BeanFieldGroup")##
$output.require("${configuration.rootPackage}.service.Service")##
$output.require("${configuration.rootPackage}.shared.dtos.Dto")##
$output.require("java.util.Set")##
$output.require("java.io.Serializable")##

public interface $output.currentClass<BEAN extends Dto, ID extends Serializable> {
    BEAN save(BeanFieldGroup fieldGroup);

    Set<BEAN> findAll();

    void showEditor();

    void showList();

    void setService(Service<BEAN, ID> service);

    Service<BEAN, ID> getService();
}
