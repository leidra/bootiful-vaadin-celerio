$output.java($Service, "Service")##

import java.util.Set;

public interface $output.currentClass<DTO, ID> {
    DTO findOne(ID id);

    Set<DTO> findAll();

    void remove(ID id);

    DTO save(DTO dto);
}
