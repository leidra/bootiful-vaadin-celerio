package net.leidra.pm.ui.views.crud;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import net.leidra.pm.shared.dtos.Dto;
import net.leidra.pm.ui.views.Presenter.AbstractPresenter;

import javax.annotation.PostConstruct;

/**
 * Created by afuentes on 27/12/15.
 */
public abstract class AbstractComponent<BEAN extends Dto> extends CustomComponent {
    protected BEAN bean;
    protected AbstractPresenter<BEAN> presenter;

    @PostConstruct
    public void postConstruct() {
        this.addStyleName("view-component");
        this.setCompositionRoot(buildView());
    }

    protected abstract CssLayout buildView();

    public void setPresenter(AbstractPresenter presenter) {
        this.presenter = presenter;
    }

}