$output.java("${configuration.rootPackage}.web.ui.views.${entity.model.typeLow}.crud","${entity.entityConfig.entityName}List")##

$output.require("com.vaadin.spring.annotation.SpringComponent")##
$output.require("com.vaadin.ui.Grid")##
$output.require("${configuration.rootPackage}.shared.dtos.${entity.entityConfig.entityName}ListDto")##
$output.require("${configuration.rootPackage}.web.ui.components.ListComponent")##
$output.require("${configuration.rootPackage}.web.ui.presenter.AbstractPresenter")##
$output.require("${configuration.rootPackage}.web.ui.views.${entity.model.typeLow}.${entity.entityConfig.entityName}Presenter")##
$output.require("org.springframework.beans.factory.annotation.Autowired")##
$output.require("org.springframework.beans.factory.annotation.Qualifier")##
$output.require("org.springframework.beans.factory.config.BeanDefinition")##
$output.require("org.springframework.context.annotation.Scope")##
$output.require("java.util.Optional")##

@SpringComponent
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class $output.currentClass extends ListComponent<${entity.entityConfig.entityName}ListDto, $entity.primaryKey.type> {

    @Override
    protected void editAction(Grid.RowReference rowReference) {
        presenter.edit((${entity.entityConfig.entityName}ListDto) rowReference.getItemId());
    }

    @Override
    protected void removeAction(Grid.RowReference rowReference) {
        presenter.remove((${entity.entityConfig.entityName}ListDto) rowReference.getItemId());
        presenter.showList();
    }

    @Override
    protected void configureGrid() {
    }

    @Override
    protected void configureGridColumns() {
        Optional.ofNullable(grid.getColumn("id")).ifPresent(c -> grid.removeColumn("id"));
        grid.setColumnOrder("name", "brand");
    }

    @Override
    @Autowired
    @Qualifier(${entity.entityConfig.entityName}Presenter.PRESENTER_NAME)
    public void setPresenter(AbstractPresenter presenter) {
        super.setPresenter(presenter);
    }

}
