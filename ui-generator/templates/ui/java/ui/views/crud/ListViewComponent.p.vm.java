$output.java("${configuration.rootPackage}.web.ui.components","ListViewComponent")##

$output.require("com.vaadin.ui.Component")##
$output.require("${configuration.rootPackage}.shared.dtos.Dto")##

public interface $output.currentClass<BEAN extends Dto> extends Component {
    void refresh();

    BEAN getValue();
}
