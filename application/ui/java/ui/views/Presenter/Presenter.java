package net.leidra.pm.ui.views.Presenter;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import net.leidra.pm.core.services.Service;
import net.leidra.pm.shared.dtos.Dto;

import java.util.Set;

/**
 * Created by afuentes on 28/12/15.
 */
public interface Presenter<BEAN extends Dto> {
    BEAN save(BeanFieldGroup fieldGroup);

    Set<BEAN> findAll();

    void showEditor();

    void showList();

    void setService(Service<BEAN> service);

    Service<BEAN> getService();
}
