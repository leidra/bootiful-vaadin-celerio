$output.java($Service, "Service")##

$output.require("java.io.Serializable")##
$output.require("java.util.Set")##

public interface $output.currentClass<DTO, ID extends Serializable> {
    DTO findOne(ID id);
    Set<DTO> findAll();
    void remove(DTO id);
    void remove(ID id);
    DTO save(DTO dto);
}
