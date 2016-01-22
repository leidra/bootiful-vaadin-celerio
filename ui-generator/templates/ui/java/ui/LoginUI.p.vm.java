$output.java($WebUi, "LoginUI")

$output.require("com.vaadin.annotations.Theme")##
$output.require("com.vaadin.event.ShortcutAction")##
$output.require("com.vaadin.server.VaadinRequest")##
$output.require("com.vaadin.spring.annotation.SpringUI")##
$output.require("com.vaadin.ui.*")##
$output.require("com.vaadin.ui.themes.ValoTheme")##
$output.require("org.slf4j.LoggerFactory")##
$output.require("org.springframework.beans.factory.annotation.Autowired")##
$output.require("org.springframework.security.core.AuthenticationException")##
$output.require("org.vaadin.spring.security.VaadinSecurity")##

@SpringUI(path = "/login")
@Theme(ValoTheme.THEME_NAME)
public class $output.currentClass extends UI {
    @Autowired
    private VaadinSecurity vaadinSecurity;

    private TextField userName;
    private PasswordField passwordField;
    private Button login;

    private Label loginFailedLabel;
    private Label loggedOutLabel;

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Product management");

        FormLayout loginForm = new FormLayout();
        loginForm.setSizeUndefined();

        loginForm.addComponent(userName = new TextField("Username"));
        loginForm.addComponent(passwordField = new PasswordField("Password"));
        loginForm.addComponent(login = new Button("Login"));
        login.addStyleName(ValoTheme.BUTTON_PRIMARY);
        login.setDisableOnClick(true);
        login.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        login.addClickListener((event) -> login());

        VerticalLayout loginLayout = new VerticalLayout();
        loginLayout.setSpacing(true);
        loginLayout.setSizeUndefined();

        if (request.getParameter("logout") != null) {
            loggedOutLabel = new Label("You have been logged out!");
            loggedOutLabel.addStyleName(ValoTheme.LABEL_SUCCESS);
            loggedOutLabel.setSizeUndefined();
            loginLayout.addComponent(loggedOutLabel);
            loginLayout.setComponentAlignment(loggedOutLabel, Alignment.BOTTOM_CENTER);
        }

        loginLayout.addComponent(loginFailedLabel = new Label());
        loginLayout.setComponentAlignment(loginFailedLabel, Alignment.BOTTOM_CENTER);
        loginFailedLabel.setSizeUndefined();
        loginFailedLabel.addStyleName(ValoTheme.LABEL_FAILURE);
        loginFailedLabel.setVisible(false);

        loginLayout.addComponent(loginForm);
        loginLayout.setComponentAlignment(loginForm, Alignment.TOP_CENTER);

        VerticalLayout rootLayout = new VerticalLayout(loginLayout);
        rootLayout.setSizeFull();
        rootLayout.setComponentAlignment(loginLayout, Alignment.MIDDLE_CENTER);
        setContent(rootLayout);
        setSizeFull();
    }

    private void login() {
        try {
            vaadinSecurity.login(userName.getValue(), passwordField.getValue());
        } catch (AuthenticationException ex) {
            userName.focus();
            userName.selectAll();
            passwordField.setValue("");
            loginFailedLabel.setValue(String.format("Login failed: %s", ex.getMessage()));
            loginFailedLabel.setVisible(true);
            if (loggedOutLabel != null) {
                loggedOutLabel.setVisible(false);
            }
        } catch (Exception ex) {
            Notification.show("An unexpected error occurred", ex.getMessage(), Notification.Type.ERROR_MESSAGE);
            LoggerFactory.getLogger(getClass()).error("Unexpected error while logging in", ex);
        } finally {
            login.setEnabled(true);
        }
    }
}