$output.java("${configuration.rootPackage}.web.ui.components","Menu")##

$output.require("com.vaadin.spring.annotation.SpringComponent")##
$output.require("com.vaadin.ui.Button")##
$output.require("com.vaadin.ui.CssLayout")##
$output.require("org.springframework.context.annotation.Scope")##
$output.require("org.springframework.util.Assert")##
$output.require("javax.annotation.PostConstruct")##
$output.require("java.util.HashMap")##
$output.require("java.util.Map")##

@SpringComponent
@Scope("session")
public class $output.currentClass extends CssLayout {
    protected Map<String, Runnable> datasource = new HashMap<>();

    public Menu(Map<String, Runnable> datasource) {
        this();
        this.datasource = datasource;
    }

    public Menu() {
        this.addStyleName("ui-menu");
    }

    @PostConstruct
    protected void postConstruct() {
        buildComponent();
    }

    public Map<String, Runnable> getDatasource() {
        return datasource;
    }

    public void setDatasource(Map<String, Runnable> datasource) {
        this.datasource = datasource;
        buildComponent();
    }

    protected void buildComponent() {
        Assert.notNull(datasource);
        datasource.entrySet().stream()
                .forEach(itemMenu -> this.addComponent(new Button(itemMenu.getKey(), e -> itemMenu.getValue().run())));
    }
}