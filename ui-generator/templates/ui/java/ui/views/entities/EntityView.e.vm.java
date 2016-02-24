$output.java("${configuration.rootPackage}.web.ui.views.${entity.model.typeLow}","${entity.entityConfig.entityName}View")##

$output.require("com.vaadin.spring.annotation.SpringView")##
$output.require("com.vaadin.ui.Button")##
$output.require("${configuration.rootPackage}.web.ui.views.AbstractView")##
$output.require(${entity.model})##
$output.require("${configuration.rootPackage}.web.ui.presenter.Presenter")##
$output.require("${configuration.rootPackage}.web.ui.views.${entity.model.typeLow}.${entity.entityConfig.entityName}Presenter")##
$output.require("${configuration.rootPackage}.web.ui.views.${entity.model.typeLow}.crud.${entity.entityConfig.entityName}Editor")##
$output.require("${configuration.rootPackage}.web.ui.views.${entity.model.typeLow}.crud.${entity.entityConfig.entityName}List")##
$output.require("org.springframework.beans.factory.annotation.Autowired")##
$output.require("org.springframework.beans.factory.annotation.Qualifier")##

@SpringView(name = ${output.currentClass}.VIEW_NAME)
public class $output.currentClass extends AbstractView<${entity.entityConfig.entityName}> {
    public final static String VIEW_NAME = "${entity.entityConfig.entityName}";

    @Autowired
    public void setEditor(${entity.entityConfig.entityName}Editor editor) {
        this.editor = editor;
    }

    @Autowired
    public void setList(${entity.entityConfig.entityName}List list) {
        this.list = list;
    }

    @Override
    @Autowired
    @Qualifier(${entity.entityConfig.entityName}Presenter.PRESENTER_NAME)
    protected void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public Button getNewButton() {
        return newButton;
    }

    public Button getListButton() {
        return listButton;
    }

}