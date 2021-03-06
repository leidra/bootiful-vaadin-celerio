$output.java($WebUi, "MainUI")

$output.require("com.vaadin.annotations.PreserveOnRefresh")##
$output.require("com.vaadin.annotations.Theme")##
$output.require("com.vaadin.navigator.Navigator")##
$output.require("com.vaadin.server.DefaultErrorHandler")##
$output.require("com.vaadin.server.ErrorHandler")##
$output.require("com.vaadin.server.VaadinRequest")##
$output.require("com.vaadin.spring.annotation.SpringUI")##
$output.require("com.vaadin.spring.navigator.SpringViewProvider")##
$output.require("com.vaadin.ui.*")##
$output.require("org.springframework.beans.factory.annotation.Autowired")##
$output.require("org.springframework.util.CollectionUtils")##
$output.require("org.vaadin.spring.security.util.SecurityExceptionUtils")##

$output.require("${configuration.rootPackage}.web.ui.components.Menu")##
$output.require("${configuration.rootPackage}.web.ui.views.AccessDeniedView")##
$output.require("${configuration.rootPackage}.web.ui.views.ErrorView")##
##$output.require("${configuration.rootPackage}.web.ui.views.products.ProductView")##
$output.require("java.util.HashMap")##
$output.require("java.util.Map")##

@SpringUI
@Theme(MainUI.THEME_NAME)
@PreserveOnRefresh
public class $output.currentClass extends UI {
    public final static String THEME_NAME = "mytheme";

    private CssLayout contentContainer;

    @Autowired
    private SpringViewProvider viewProvider;

    @Autowired
    private Menu menu;

    @Override
    protected void init(VaadinRequest request) {
        // Let's register a custom error handler to make the 'access denied' messages a bit friendlier.
        setErrorHandler(createErrorHandler());
        this.setContent(createUILayout());

        configureNavigator();
    }

    private CssLayout createUILayout() {
        CssLayout uiLayout = new CssLayout();
        uiLayout.addStyleName("ui-container");
        uiLayout.addComponent(this.createHeader());
        uiLayout.addComponent(this.createViewContainer());
        uiLayout.addComponent(this.createFooter());

        return uiLayout;
    }

    private Component createViewContainer() {
        CssLayout viewContainer = new CssLayout();
        viewContainer.addStyleName("ui-view");
        viewContainer.addComponent(this.createSideBar());
        viewContainer.addComponent(this.createContent());

        return viewContainer;
    }

    private Component createHeader() {
        CssLayout headerContainer = new CssLayout();
        headerContainer.addStyleName("ui-header");
        headerContainer.addComponent(new Label("ProMan"));
        return headerContainer;
    }

    private Component createSideBar() {
        if(menu.getDatasource().isEmpty()) {
            Map<String, Runnable> datasource = new HashMap<>();
  ##          datasource.put("Products", () -> getUI().getNavigator().navigateTo(ProductView.VIEW_NAME));
            datasource.put("Logout", () -> getPage().setLocation("/logout"));

            menu.setDatasource(datasource);
        }

        return menu;
    }

    private Component createContent() {
        contentContainer = new CssLayout();
        contentContainer.addStyleName("content-container");
        return contentContainer;
    }

    private Component createFooter() {
        CssLayout footerContainer = new CssLayout();
        footerContainer.addStyleName("footer-container");
        return footerContainer;
    }

    public void configureNavigator() {
        Navigator navigator = new Navigator(this, contentContainer);

        viewProvider.setAccessDeniedViewClass(AccessDeniedView.class);
        navigator.addProvider(viewProvider);
        navigator.setErrorView(ErrorView.class);
        this.setNavigator(navigator);
    }

    protected ErrorHandler createErrorHandler() {
        return new DefaultErrorHandler() {
            @Override
            public void error(com.vaadin.server.ErrorEvent event) {
                if (SecurityExceptionUtils.isAccessDeniedException(event.getThrowable())) {
                    Notification.show("Sorry, you don't have access to do that.");
                } else {
                    super.error(event);
                }
            }
        };
    }

    public SpringViewProvider getViewProvider() {
        return viewProvider;
    }
}