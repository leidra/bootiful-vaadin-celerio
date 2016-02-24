$output.java("${configuration.rootPackage}.shared.services", "AbstractConverter")##

$output.require("${configuration.rootPackage}.shared.services.Converter")##
$output.require("java.util.Set")##
$output.require("ma.glasnost.orika.MapperFacade")##
$output.require("${configuration.rootPackage}.shared.dtos.Dto")##
$output.require("${configuration.rootPackage}.domain.support.Identifiable")##

public abstract class $output.currentClass implements Converter {
    protected MapperFacade mapperFacade;

    public <DTO extends Dto, ENTITY extends Identifiable> DTO convertToDto(ENTITY entity) {
        return getMapperFacade().map(entity, getDtoType());
    }

    public <DTO extends Dto> Set<DTO> convertToDtoSet(Iterable<? extends Identifiable> entities) {
        return ((MapperFacade)getMapperFacade()).mapAsSet(entities, getDtoType());
    }

    public <DTO extends Dto> Set<DTO> convertToListDtoSet(Iterable<? extends Identifiable> entities) {
        return ((MapperFacade) getMapperFacade()).mapAsSet(entities, getListDtoType());
    }

    public <DTO extends Dto, ENTITY extends Identifiable> ENTITY convertToEntity(DTO dto) {
        return getMapperFacade().map(dto, getEntityType());
    }

    public <DTO extends Dto, ENTITY extends Identifiable> Set<ENTITY> convertToEntitySet(Iterable<DTO> dtos) {
        return ((MapperFacade)getMapperFacade()).mapAsSet(dtos, getEntityType());
    }

    protected MapperFacade getMapperFacade() {
        return mapperFacade;
    }

    protected void setMapperFacade(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }

    protected abstract <DTO extends Dto> Class<DTO> getDtoType();
    protected abstract <DTO extends Dto> Class<DTO> getListDtoType();
    protected abstract <ENTITY extends Identifiable> Class<ENTITY> getEntityType();
}