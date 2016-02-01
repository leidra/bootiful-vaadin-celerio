$output.java("${configuration.rootPackage}.domain.support", "Identifiable")##

$output.require("org.springframework.data.domain.Persistable")##
$output.require("java.io.Serializable")##

public interface $output.currentClass<ID extends Serializable> extends Persistable<ID>{
    void setId(ID id);
    boolean isIdSet();
}
