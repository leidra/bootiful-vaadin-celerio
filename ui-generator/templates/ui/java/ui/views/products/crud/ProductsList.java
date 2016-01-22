package net.leidra.pm.ui.views.products.crud;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Grid;
import net.leidra.pm.shared.dtos.ProductListDto;
import net.leidra.pm.ui.views.crud.AbstractListComponent;
import net.leidra.pm.ui.views.Presenter.AbstractPresenter;
import net.leidra.pm.ui.views.products.ProductPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import java.util.Optional;

/**
 * Created by afuentes on 27/12/15.
 */
@SpringComponent
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProductsList extends AbstractListComponent<ProductListDto> {

    @Override
    protected void editAction(Grid.RowReference rowReference) {
        presenter.edit((ProductListDto) rowReference.getItemId());
    }

    @Override
    protected void removeAction(Grid.RowReference rowReference) {
        presenter.remove((ProductListDto) rowReference.getItemId());
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
    @Qualifier(ProductPresenter.PRESENTER_NAME)
    public void setPresenter(AbstractPresenter presenter) {
        super.setPresenter(presenter);
    }

}
