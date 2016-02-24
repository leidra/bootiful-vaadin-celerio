$output.java("${configuration.rootPackage}.web.ui.views","AccessDeniedView")##

$output.require("com.vaadin.navigator.View")##
$output.require("com.vaadin.navigator.ViewChangeListener")##
$output.require("com.vaadin.spring.annotation.SpringComponent")##
$output.require("com.vaadin.spring.annotation.UIScope")##
$output.require("com.vaadin.ui.Label")##
$output.require("com.vaadin.ui.VerticalLayout")##
$output.require("com.vaadin.ui.themes.ValoTheme")##

@SpringComponent
@UIScope
public class $output.currentClass extends VerticalLayout implements View {
    private Label message;

    public AccessDeniedView() {
        setMargin(true);
        addComponent(message = new Label());
        message.setSizeUndefined();
        message.addStyleName(ValoTheme.LABEL_FAILURE);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        message.setValue(String.format("You do not have access to this view: %s", event.getViewName()));
    }
}