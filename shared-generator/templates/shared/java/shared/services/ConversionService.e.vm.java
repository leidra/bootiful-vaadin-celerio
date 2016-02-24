$output.java("${configuration.rootPackage}.shared.services", "${entity.entityConfig.entityName}Converter")##

$output.require($entity.model)##
$output.require("${configuration.rootPackage}.shared.dtos.${entity.entityConfig.entityName}Dto")##
$output.require("${configuration.rootPackage}.shared.dtos.${entity.entityConfig.entityName}ListDto")##
$output.require("org.slf4j.Logger")##
$output.require("org.slf4j.LoggerFactory")##
$output.require("org.springframework.stereotype.Service")##
$output.require("ma.glasnost.orika.MapperFacade")##
$output.require("org.springframework.beans.factory.annotation.Autowired")##
$output.require("${configuration.rootPackage}.shared.dtos.Dto")##
$output.require("${configuration.rootPackage}.domain.support.Identifiable")##

@Service(value = ${output.currentClass}.CONVERTER_NAME)
public class $output.currentClass extends AbstractConverter {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(${output.currentClass}.class);
    public static final String CONVERTER_NAME = "${output.currentClass}";

    @Autowired
    @Override
    protected void setMapperFacade(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }

    protected Class<? extends Dto> getDtoType() {
        return ${entity.entityConfig.entityName}Dto.class;
    }

    protected Class<? extends Dto> getListDtoType() {
        return ${entity.entityConfig.entityName}ListDto.class;
    }

    protected Class<? extends Identifiable> getEntityType() {
        return ${entity.entityConfig.entityName}.class;
    }
}