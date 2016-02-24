$output.java("${configuration.rootPackage}.web.ui.views","LoginView")##

$output.require("com.vaadin.navigator.View")##
$output.require("com.vaadin.navigator.ViewChangeListener")##
$output.require("com.vaadin.shared.ui.label.ContentMode")##
$output.require("com.vaadin.spring.annotation.SpringView")##
$output.require("com.vaadin.ui.CssLayout")##
$output.require("com.vaadin.ui.Label")##

/**
 * Created by afuentes on 14/12/15.
 */
@SpringView(name = LoginView.VIEW_NAME)
public class $output.currentClass extends CssLayout implements View {
    public final static String VIEW_NAME = "login";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        addComponent(new Label("<h1>Login</h1>", ContentMode.HTML));
    }
}
