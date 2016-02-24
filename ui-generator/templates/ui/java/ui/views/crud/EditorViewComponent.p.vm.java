$output.java("${configuration.rootPackage}.web.ui.components","EditorViewComponent")##

$output.require("com.vaadin.ui.Component")##
$output.require("${configuration.rootPackage}.shared.dtos.Dto")##

public interface $output.currentClass<BEAN extends Dto> extends Component {
    void setDatasource(BEAN bean);
    void setValidationVisible(boolean isVisible);
}
