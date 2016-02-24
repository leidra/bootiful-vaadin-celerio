$output.java("${configuration.rootPackage}.web.ui.views","AbstractView")##

$output.require("com.vaadin.navigator.View")##
$output.require("com.vaadin.navigator.ViewChangeListener")##
$output.require("com.vaadin.ui.Button")##
$output.require("com.vaadin.ui.Component")##
$output.require("com.vaadin.ui.CssLayout")##
$output.require("com.vaadin.ui.CustomComponent")##
$output.require("${configuration.rootPackage}.web.ui.presenter.Presenter")##
$output.require("${configuration.rootPackage}.web.ui.components.EditorViewComponent")##
$output.require("${configuration.rootPackage}.web.ui.components.ListViewComponent")##
$output.require("javax.annotation.PostConstruct")##

public abstract class $output.currentClass<BEAN> extends CustomComponent implements View {
    protected ListViewComponent list;
    protected EditorViewComponent editor;
    private CssLayout componentContainer = new CssLayout();

    protected Button newButton = new Button("New", e -> getPresenter().showEditor());
    protected Button listButton = new Button("List", e -> getPresenter().showList());

    protected Presenter presenter;

    @PostConstruct
    public void postConstruct() {
        this.addStyleName("view");

        CssLayout rootLayout = new CssLayout();
        rootLayout.addStyleName("view-container_root");
        rootLayout.addComponent(createViewMenu());

        componentContainer.addStyleName("component-container");
        rootLayout.addComponent(componentContainer);

        setCompositionRoot(rootLayout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        getPresenter().showList();
    }

    public void changeViewComponent(Component component) {
        componentContainer.removeAllComponents();
        componentContainer.addComponent(component);
    }

    protected Component createViewMenu() {
        CssLayout componentMenuContainer = new CssLayout();
        componentMenuContainer.addStyleName("view-menu");

        componentMenuContainer.addComponent(newButton);
        componentMenuContainer.addComponent(listButton);

        return componentMenuContainer;
    }

    protected Presenter getPresenter() {
        return presenter;
    }

    protected abstract void setPresenter(Presenter presenter);

    public ListViewComponent getList() {
        return list;
    }

    public EditorViewComponent getEditor() {
        return editor;
    }
}