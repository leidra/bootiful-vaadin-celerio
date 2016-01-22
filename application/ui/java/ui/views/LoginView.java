package net.leidra.pm.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

/**
 * Created by afuentes on 14/12/15.
 */
@SpringView(name = LoginView.VIEW_NAME)
public class LoginView extends CssLayout implements View {
    public final static String VIEW_NAME = "login";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        addComponent(new Label("<h1>Login</h1>", ContentMode.HTML));
    }
}
