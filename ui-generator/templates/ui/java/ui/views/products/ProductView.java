package net.leidra.pm.ui.views.products;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import net.leidra.pm.ui.views.AbstractView;
import net.leidra.pm.ui.views.Presenter.Presenter;
import net.leidra.pm.ui.views.products.crud.ProductEditor;
import net.leidra.pm.ui.views.products.crud.ProductsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by afuentes on 14/12/15.
 */
@SpringView(name = ProductView.VIEW_NAME)
public class ProductView extends AbstractView {
    public final static String VIEW_NAME = "Product";

    @Autowired
    public void setEditor(ProductEditor editor) {
        this.editor = editor;
    }

    @Autowired
    public void setList(ProductsList list) {
        this.list = list;
    }

    @Override
    @Autowired
    @Qualifier(ProductPresenter.PRESENTER_NAME)
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