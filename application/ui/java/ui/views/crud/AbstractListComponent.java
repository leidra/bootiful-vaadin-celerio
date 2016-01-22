package net.leidra.pm.ui.views.crud;

import com.vaadin.event.SelectionEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import net.leidra.pm.shared.dtos.Dto;

/**
 * Created by afuentes on 28/12/15.
 */
public abstract class AbstractListComponent<BEAN extends Dto> extends AbstractComponent<BEAN> implements ListViewComponent<BEAN> {
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