$output.java("${configuration.rootPackage}.web.ui.components","ListComponent")##

$output.require("com.vaadin.event.SelectionEvent")##
$output.require("com.vaadin.ui.Button")##
$output.require("com.vaadin.ui.Component")##
$output.require("com.vaadin.ui.CssLayout")##
$output.require("com.vaadin.ui.Grid")##
$output.require("${configuration.rootPackage}.shared.dtos.Dto")##
$output.require("java.io.Serializable")##

public abstract class $output.currentClass<BEAN extends Dto, ID extends Serializable> extends CrudComponent<BEAN, ID> implements ListViewComponent<BEAN> {
    protected Grid grid = new Grid();

    public void refresh() {
        grid.setContainerDataSource(presenter.createDatasource());
        configureGridColumns();
    }

    @Override
    protected CssLayout buildView() {
        CssLayout listLayout = new CssLayout();
        listLayout.addStyleName("list");
        listLayout.addComponent(createGrid());
        refresh();

        return listLayout;
    }

    protected Grid createGrid() {
        grid.addStyleName("list_datagrid");
        grid.setSizeFull();
        grid.addSelectionListener(this::rowSelected);
        grid.setDetailsGenerator(this::getDetails);

        configureGrid();

        return grid;
    }

    protected void configureGrid() {
    }

    protected void configureGridColumns() {
    }

    public Component getDetails(Grid.RowReference rowReference) {
        CssLayout layout = new CssLayout();

        layout.addComponent(new Button("Edit", e -> this.editAction(rowReference)));
        layout.addComponent(new Button("Remove", e -> this.removeAction(rowReference)));
        return layout;
    }

    public BEAN getValue() {
        return bean;
    }

    protected void rowSelected(SelectionEvent e) {
        grid.setDetailsVisible(this.bean, false);
        this.bean = (BEAN) grid.getSelectedRow();
        grid.setDetailsVisible(this.bean, true);
    }

    protected abstract void editAction(Grid.RowReference rowReference);

    protected abstract void removeAction(Grid.RowReference rowReference);
}