package net.leidra.pm.ui.views.products;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import net.leidra.pm.core.services.ProductService;
import net.leidra.pm.core.services.Service;
import net.leidra.pm.shared.dtos.ProductListDto;
import net.leidra.pm.shared.dtos.ProductDto;
import net.leidra.pm.ui.MainUI;
import net.leidra.pm.ui.views.AbstractView;
import net.leidra.pm.ui.views.Presenter.AbstractPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.util.TagUtils;

import java.util.Set;

/**
 * Created by afuentes on 27/12/15.
 */
@SpringComponent(ProductPresenter.PRESENTER_NAME)
@Scope(TagUtils.SCOPE_SESSION)
public class ProductPresenter extends AbstractPresenter<ProductDto> {
    public final static String PRESENTER_NAME = "ProductPresenter";

    public ProductDto save(BeanFieldGroup fieldGroup) {
        ProductDto dto = (ProductDto) fieldGroup.getItemDataSource().getBean();
        try {
            getCurrentView().getEditor().setValidationVisible(!fieldGroup.isValid());
            fieldGroup.commit();
            dto = (ProductDto) fieldGroup.getItemDataSource().getBean();
            dto = getService().save(dto);
        } catch (FieldGroup.CommitException ex) {
            StringBuilder error = new StringBuilder("No se pudo guardar. Errores: ");
            Notification.show(error.toString(), Notification.Type.ERROR_MESSAGE);
        }

        return dto;
    }

    protected AbstractView getCurrentView() {
        return (AbstractView) ((MainUI) UI.getCurrent()).getViewProvider().getView(ProductView.VIEW_NAME);
    }

    public Set<ProductDto> findAll() {
        return getService().findAll();
    }

    public void showEditor() {
        edit(new ProductDto());
    }

    @Override
    public BeanItemContainer createDatasource() {
        return new BeanItemContainer<>(ProductListDto.class, ((ProductService) getService()).findAllForList());
    }

    @Override
    @Autowired
    @Qualifier(ProductService.SERVICE_NAME)
    public void setService(Service service) {
        this.service = service;
    }
}