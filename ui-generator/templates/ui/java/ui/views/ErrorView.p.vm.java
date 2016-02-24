$output.java("${configuration.rootPackage}.web.ui.views","ErrorView")##

$output.require("com.vaadin.navigator.View")##
$output.require("com.vaadin.navigator.ViewChangeListener")##
$output.require("com.vaadin.ui.Label")##
$output.require("com.vaadin.ui.VerticalLayout")##
$output.require("com.vaadin.ui.themes.ValoTheme")##

public class $output.currentClass extends VerticalLayout implements View {
    private Label message;

    public ${output.currentClass}() {
        setMargin(true);
        addComponent(message = new Label());
        message.setSizeUndefined();
        message.addStyleName(ValoTheme.LABEL_FAILURE);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        message.setValue(String.format("No such view: %s", event.getViewName()));
    }
}