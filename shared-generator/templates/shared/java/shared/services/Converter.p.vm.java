$output.java("${configuration.rootPackage}.shared.services", "Converter")##

$output.require("java.util.Set")##
$output.require("${configuration.rootPackage}.shared.dtos.Dto")##
$output.require("${configuration.rootPackage}.domain.support.Identifiable")##

public interface $output.currentClass {
    <DTO extends Dto, ENTITY extends Identifiable> DTO convertToDto(ENTITY entity);
    <DTO extends Dto> Set<DTO> convertToDtoSet(Iterable<? extends Identifiable> entities);
    <DTO extends Dto, ENTITY extends Identifiable> ENTITY convertToEntity(DTO dto);
    <DTO extends Dto, ENTITY extends Identifiable> Set<ENTITY> convertToEntitySet(Iterable<DTO> dtos);
    <DTO extends Dto> Set<DTO> convertToListDtoSet(Iterable<? extends Identifiable> entities);
}
