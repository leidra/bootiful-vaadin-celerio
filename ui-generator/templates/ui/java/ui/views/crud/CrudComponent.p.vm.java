$output.java("${configuration.rootPackage}.web.ui.components","CrudComponent")##

$output.require("com.vaadin.ui.CssLayout")##
$output.require("com.vaadin.ui.CustomComponent")##
$output.require("${configuration.rootPackage}.shared.dtos.Dto")##
$output.require("${configuration.rootPackage}.web.ui.presenter.AbstractPresenter")##
$output.require("javax.annotation.PostConstruct")##
$output.require("java.io.Serializable")##

public abstract class $output.currentClass<BEAN extends Dto, ID extends Serializable> extends CustomComponent {
    protected BEAN bean;
    protected AbstractPresenter<BEAN, ID> presenter;

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