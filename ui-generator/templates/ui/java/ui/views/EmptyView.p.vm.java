$output.java("${configuration.rootPackage}.web.ui.views","EptyView")##

$output.require("com.vaadin.navigator.View")##
$output.require("com.vaadin.navigator.ViewChangeListener")##
$output.require("com.vaadin.spring.annotation.SpringView")##
$output.require("com.vaadin.ui.CssLayout")##

@SpringView
        ##(name = $output.currentClass.VIEW_NAME)
public class $output.currentClass extends CssLayout implements View {
    public final static String VIEW_NAME = "";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
