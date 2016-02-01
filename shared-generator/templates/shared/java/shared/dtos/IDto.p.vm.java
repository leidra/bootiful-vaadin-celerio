$output.java("${configuration.rootPackage}.shared.dtos", "Dto")##
$output.require("java.io.Serializable")##

public interface $output.currentClass<ID extends Serializable> {
    ID getId();

    void setId(ID id);
}
