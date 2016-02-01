$output.java("${configuration.rootPackage}.shared.services", "${entity.entityConfig.entityName}Converter")##

$output.require($entity.model)##
$output.require("${configuration.rootPackage}.shared.dtos.${entity.entityConfig.entityName}Dto")##
$output.require("org.slf4j.Logger")##
$output.require("org.slf4j.LoggerFactory")##
$output.require("java.util.Set")##
$output.require("ma.glasnost.orika.BoundMapperFacade")##
$output.require("ma.glasnost.orika.MapperFactory")##
$output.require("ma.glasnost.orika.impl.DefaultMapperFactory")##
$output.require("org.springframework.stereotype.Service")##

@Service
public class $output.currentClass {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(${output.currentClass}.class);

    protected static final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    protected static final BoundMapperFacade<${entity.entityConfig.entityName}, ${entity.entityConfig.entityName}Dto> mapperFacade = mapperFactory.getMapperFacade(${entity.entityConfig.entityName}.class, ${entity.entityConfig.entityName}Dto.class);

    public ${entity.entityConfig.entityName}Dto convertToDto(${entity.entityConfig.entityName} entity) {
        return getMapperFacade().map(entity);
    }

    public Set<${entity.entityConfig.entityName}Dto> convertToDtoSet(Iterable<${entity.entityConfig.entityName}> entities) {
        return mapperFactory.getMapperFacade().mapAsSet(entities, ${entity.entityConfig.entityName}Dto.class);
    }

    public ${entity.entityConfig.entityName} convertToEntity(${entity.entityConfig.entityName}Dto dto) {
        return getMapperFacade().mapReverse(dto);
    }

    public Set<${entity.entityConfig.entityName}> convertToEntitySet(Iterable<${entity.entityConfig.entityName}Dto> dtos) {
        return mapperFactory.getMapperFacade().mapAsSet(dtos, ${entity.entityConfig.entityName}.class);
    }

    protected MapperFactory getMapperFactory() {
        return mapperFactory;
    }

    protected BoundMapperFacade<${entity.entityConfig.entityName}, ${entity.entityConfig.entityName}Dto> getMapperFacade() {
        return mapperFacade;
    }
}